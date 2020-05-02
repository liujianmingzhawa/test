package com.everything.demo.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.everything.demo.po.SmsHistory;

import java.util.List;
import java.util.Map;

@Mapper
public interface SmsHistoryMapper {
    int deleteByPrimaryKey(SmsHistory record);

    int insert(SmsHistory record);

    int insertSelective(SmsHistory record);

    SmsHistory selectByPrimaryKey(SmsHistory record);

    int updateByPrimaryKeySelective(SmsHistory record);

    int updateByPrimaryKey(SmsHistory record);

    Long selectByDestNumberByCount(Map<String, Object> map);

    List<SmsHistory> selectByDestNumberByPage(Map<String, Object> map);

    List<SmsHistory> selectByLimit(Map<String, Object> map);

    SmsHistory selectById(Map<String, Object> map);

	Long selectCountByDestNumberAndSrcChannel(Map<String, Object> map);

	List<SmsHistory> selectByDestNumberAndSrcChannelByPage(Map<String, Object> map);
}