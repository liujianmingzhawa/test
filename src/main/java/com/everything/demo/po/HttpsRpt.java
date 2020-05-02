package com.everything.demo.po;

import java.util.Date;



public class HttpsRpt extends BaseObject{
	private static final long serialVersionUID = 8545979787449449165L;

	private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private Long smsHistoryId;

    private String uuid;

    private String origin;

    private String srcMsgId;

    private String destSeqId;

    private String srcChannel;

    private String destChannel;

    private String srcNumber;

    private String destNumber;

    private Integer smsSize;

    private Integer smsNumber;

    private Integer status;

    private String code;

    private String error;

    private Integer gateway;

    private String country;

    private String province;

    private Date gmtSchedule;

    private Date gmtReport;

    private String hostName;

    private Integer hashValue;

    private Integer retryTimes;

    private Date gmtRetry;

    private Integer isPull;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public Long getSmsHistoryId() {
		return smsHistoryId;
	}

	public void setSmsHistoryId(Long smsHistoryId) {
		this.smsHistoryId = smsHistoryId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getSrcMsgId() {
		return srcMsgId;
	}

	public void setSrcMsgId(String srcMsgId) {
		this.srcMsgId = srcMsgId;
	}

	public String getDestSeqId() {
		return destSeqId;
	}

	public void setDestSeqId(String destSeqId) {
		this.destSeqId = destSeqId;
	}

	public String getSrcChannel() {
		return srcChannel;
	}

	public void setSrcChannel(String srcChannel) {
		this.srcChannel = srcChannel;
	}

	public String getDestChannel() {
		return destChannel;
	}

	public void setDestChannel(String destChannel) {
		this.destChannel = destChannel;
	}

	public String getSrcNumber() {
		return srcNumber;
	}

	public void setSrcNumber(String srcNumber) {
		this.srcNumber = srcNumber;
	}

	public String getDestNumber() {
		return destNumber;
	}

	public void setDestNumber(String destNumber) {
		this.destNumber = destNumber;
	}

	public Integer getSmsSize() {
		return smsSize;
	}

	public void setSmsSize(Integer smsSize) {
		this.smsSize = smsSize;
	}

	public Integer getSmsNumber() {
		return smsNumber;
	}

	public void setSmsNumber(Integer smsNumber) {
		this.smsNumber = smsNumber;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Integer getGateway() {
		return gateway;
	}

	public void setGateway(Integer gateway) {
		this.gateway = gateway;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Date getGmtSchedule() {
		return gmtSchedule;
	}

	public void setGmtSchedule(Date gmtSchedule) {
		this.gmtSchedule = gmtSchedule;
	}

	public Date getGmtReport() {
		return gmtReport;
	}

	public void setGmtReport(Date gmtReport) {
		this.gmtReport = gmtReport;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public Integer getHashValue() {
		return hashValue;
	}

	public void setHashValue(Integer hashValue) {
		this.hashValue = hashValue;
	}

	public Integer getRetryTimes() {
		return retryTimes;
	}

	public void setRetryTimes(Integer retryTimes) {
		this.retryTimes = retryTimes;
	}

	public Date getGmtRetry() {
		return gmtRetry;
	}

	public void setGmtRetry(Date gmtRetry) {
		this.gmtRetry = gmtRetry;
	}

	public Integer getIsPull() {
		return isPull;
	}

	public void setIsPull(Integer isPull) {
		this.isPull = isPull;
	}

}