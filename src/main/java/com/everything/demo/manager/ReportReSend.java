package com.everything.demo.manager;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everything.demo.common.AbstractFixedThread;
import com.everything.demo.common.FixedThreadPool;
import com.everything.demo.dao.SmsHistoryDAO;
import com.everything.demo.mapper.SmsRptTaskMapper;
import com.everything.demo.po.SmsHistory;
import com.everything.demo.po.SmsRptTask;


/**
 * 二期状态报告补发
 * @author ljm
 *
 */
//@Component
public class ReportReSend {
	protected FixedThreadPool executorService = new FixedThreadPool(20, getClass().getSimpleName());
	
	@Autowired
	private SmsHistoryDAO smsHistoryDAO;
	
	@Autowired
	private SmsRptTaskMapper smsRptTaskMapper;
	
	@PostConstruct
	public void inint(){
		SmsHistory record = new SmsHistory();
		record.setGmtSchedule(DateUtils.addDays(new Date(), -1));//TODO
		record.setDeliverStatus(1);
		record.setSrcChannel("客户A验证码");//TODO
		List<Long> ids = smsHistoryDAO.selectBySrcChannelAndStatus(record);
		for (Long id : ids) {
			executorService.submit(new ReSend(id));
		}
	}
	
	class ReSend extends AbstractFixedThread{
		
		private Long id;
		
		public ReSend(Long id){
			this.id = id;
		}

		@Override
		public void process() throws Exception {
			SmsHistory record = new SmsHistory();
			record.setGmtSchedule(DateUtils.addDays(new Date(), -1));//TODO
			record.setId(id);
			SmsHistory smsHistory = smsHistoryDAO.selectByPrimaryKey(record);
			SmsRptTask smsRptTask = getReport(smsHistory);
			System.err.println(smsRptTask);
			if(smsRptTaskMapper.insert(smsRptTask) !=1){
				System.err.println("insert smsRptTask failed");
			}
		}

		private SmsRptTask getReport(SmsHistory history) {
	        SmsRptTask smsRptTask = new SmsRptTask();
	        smsRptTask.setGmtCreate(new Date());
	        smsRptTask.setGmtModified(smsRptTask.getGmtCreate());
	        smsRptTask.setSmsHistoryId(history.getId());
	        smsRptTask.setUuid(history.getUuid());
	        smsRptTask.setOrigin(history.getOrigin());
	        smsRptTask.setSrcMsgId(history.getSrcMsgId());
	        smsRptTask.setDestSeqId(history.getDestSeqId());
	        smsRptTask.setSrcChannel(history.getSrcChannel());
	        smsRptTask.setDestChannel(history.getDestChannel());
	        smsRptTask.setSrcNumber(history.getSrcNumber());
	        smsRptTask.setDestNumber(history.getDestNumber());
	        smsRptTask.setSmsSize(history.getSmsSize());
	        smsRptTask.setSmsNumber(history.getSmsNumber());
	        smsRptTask.setStatus(history.getStatus());
	        smsRptTask.setCode(history.getCode());
	        smsRptTask.setError(history.getError());
	        smsRptTask.setGateway(history.getGateway());
	        smsRptTask.setCountry(history.getCountry());
	        smsRptTask.setProvince(history.getProvince());
	        smsRptTask.setGmtSchedule(history.getGmtSchedule());
	        smsRptTask.setGmtReport(history.getGmtReport());
	        smsRptTask.setHostName(history.getHostName());
	        smsRptTask.setHashValue(history.getHashValue());
	        smsRptTask.setRetryTimes(0);
	        smsRptTask.setGmtRetry(smsRptTask.getGmtCreate());
			return smsRptTask;
		}
		
	}
}
