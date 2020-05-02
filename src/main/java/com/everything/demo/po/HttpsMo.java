package com.everything.demo.po;

import java.util.Date;



public class HttpsMo extends BaseObject{
	private static final long serialVersionUID = 6617809258142367585L;

	private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private Long smsMoId;

    private String uuid;

    private String srcChannel;

    private String destChannel;

    private String srcNumber;

    private String destNumber;

    private String extendCode;

    private String content;

    private Integer smsType;

    private Integer smsSize;

    private Integer smsNumber;

    private Integer gateway;

    private String country;

    private String province;

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

	public Long getSmsMoId() {
		return smsMoId;
	}

	public void setSmsMoId(Long smsMoId) {
		this.smsMoId = smsMoId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public String getExtendCode() {
		return extendCode;
	}

	public void setExtendCode(String extendCode) {
		this.extendCode = extendCode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getSmsType() {
		return smsType;
	}

	public void setSmsType(Integer smsType) {
		this.smsType = smsType;
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