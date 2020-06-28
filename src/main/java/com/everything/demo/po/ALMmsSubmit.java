package com.everything.demo.po;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ALMmsSubmit extends BaseObject{
	private static final long serialVersionUID = -4428582784982521967L;

	@JsonProperty("username")
	private String accessKey;
	
	@JsonProperty("sequenceNumber")
	private String sequenceNumber;
	
	@JsonProperty("userNumber")
	private String destNumber;
	
	@JsonProperty("id")
	private String templateId;
	
	@JsonProperty("sign")
	private String sign;
	
	@JsonProperty("timestamp")
	private String timestamp;
	
	@JsonProperty("extNum")
	private String extNum;


	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getDestNumber() {
		return destNumber;
	}

	public void setDestNumber(String destNumber) {
		this.destNumber = destNumber;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getExtNum() {
		return extNum;
	}

	public void setExtNum(String extNum) {
		this.extNum = extNum;
	}

}
