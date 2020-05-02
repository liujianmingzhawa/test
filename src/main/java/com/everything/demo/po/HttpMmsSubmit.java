package com.everything.demo.po;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HttpMmsSubmit extends BaseObject{
	private static final long serialVersionUID = -7076224581430448434L;

	@JsonProperty("access_key")
    private String accessKey;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("nonce")
    private String nonce;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("dest_number")
    private String destNumber;

    @JsonProperty("extend_code")
    private String extendCode;

    @JsonProperty("template_id")
    private String templateId;

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
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

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	} 
    
    
    
}
