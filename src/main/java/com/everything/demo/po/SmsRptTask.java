package com.everything.demo.po;



import java.util.Date;

public class SmsRptTask extends BaseObject {
    private static final long serialVersionUID = 1112322424667830184L;

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
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public String getSrcMsgId() {
        return srcMsgId;
    }

    public void setSrcMsgId(String srcMsgId) {
        this.srcMsgId = srcMsgId == null ? null : srcMsgId.trim();
    }

    public String getDestSeqId() {
        return destSeqId;
    }

    public void setDestSeqId(String destSeqId) {
        this.destSeqId = destSeqId == null ? null : destSeqId.trim();
    }

    public String getSrcChannel() {
        return srcChannel;
    }

    public void setSrcChannel(String srcChannel) {
        this.srcChannel = srcChannel == null ? null : srcChannel.trim();
    }

    public String getDestChannel() {
        return destChannel;
    }

    public void setDestChannel(String destChannel) {
        this.destChannel = destChannel == null ? null : destChannel.trim();
    }

    public String getSrcNumber() {
        return srcNumber;
    }

    public void setSrcNumber(String srcNumber) {
        this.srcNumber = srcNumber == null ? null : srcNumber.trim();
    }

    public String getDestNumber() {
        return destNumber;
    }

    public void setDestNumber(String destNumber) {
        this.destNumber = destNumber == null ? null : destNumber.trim();
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
        this.code = code == null ? null : code.trim();
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error == null ? null : error.trim();
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
        this.country = country == null ? null : country.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
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
        this.hostName = hostName == null ? null : hostName.trim();
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
}