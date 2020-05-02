package com.everything.demo.po;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UploadResourcesMmsResult extends BaseObject{
	private static final long serialVersionUID = -4614056917466895626L;

	@JsonProperty("code")
    private Integer code = 0;

    @JsonProperty("template_id")
    private String templateId;

    @JsonProperty("message")
    private String message;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    
}
