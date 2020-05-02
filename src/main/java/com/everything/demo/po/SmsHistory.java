package com.everything.demo.po;



import java.util.Date;

public class SmsHistory extends BaseObject {
    private static final long serialVersionUID = -3301577506024294710L;

    private String tabIndex;

    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String uuid;

    private String origin;

    private String srcSeqId;

    private String srcMsgId;

    private String destSeqId;

    private String destMsgId;

    private String srcChannel;

    private String destChannel;

    private String srcNumber;

    private String destNumber;

    private String feeNumber;

    private String extendCode;

    private String content;

    private Integer priority;

    private Integer smsType;

    private Integer smsSize;

    private Integer smsNumber;

    private Integer status;

    private String code;

    private String error;

    private Integer gateway;

    private String country;

    private String province;

    private Date gmtSchedule;

    private Date gmtResponse;

    private Date gmtReport;

    private Date gmtDeliver;

    private Integer deliverStatus;

    private String hostName;

    private Integer hashValue;

    public String getTabIndex() {
        return tabIndex;
    }

    public void setTabIndex(String tabIndex) {
        this.tabIndex = tabIndex;
    }

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

    public String getSrcSeqId() {
        return srcSeqId;
    }

    public void setSrcSeqId(String srcSeqId) {
        this.srcSeqId = srcSeqId == null ? null : srcSeqId.trim();
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

    public String getDestMsgId() {
        return destMsgId;
    }

    public void setDestMsgId(String destMsgId) {
        this.destMsgId = destMsgId == null ? null : destMsgId.trim();
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

    public String getFeeNumber() {
        return feeNumber;
    }

    public void setFeeNumber(String feeNumber) {
        this.feeNumber = feeNumber == null ? null : feeNumber.trim();
    }

    public String getExtendCode() {
        return extendCode;
    }

    public void setExtendCode(String extendCode) {
        this.extendCode = extendCode == null ? null : extendCode.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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

    public Date getGmtResponse() {
        return gmtResponse;
    }

    public void setGmtResponse(Date gmtResponse) {
        this.gmtResponse = gmtResponse;
    }

    public Date getGmtReport() {
        return gmtReport;
    }

    public void setGmtReport(Date gmtReport) {
        this.gmtReport = gmtReport;
    }

    public Date getGmtDeliver() {
        return gmtDeliver;
    }

    public void setGmtDeliver(Date gmtDeliver) {
        this.gmtDeliver = gmtDeliver;
    }

    public Integer getDeliverStatus() {
        return deliverStatus;
    }

    public void setDeliverStatus(Integer deliverStatus) {
        this.deliverStatus = deliverStatus;
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
}