package com.everything.demo.po;

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ALMmsUploadResource extends BaseObject{
	private static final long serialVersionUID = 3845712857975846286L;

	@JsonProperty("username")
	private String accessKey;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("timestamp")
	private String timestamp;
	
	@JsonProperty("type")
	private String templateId;
	
	@JsonProperty("param")
	private String resourceList;
	
	@JsonProperty("sign")
	private String sign;

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getResourceList() {
		return resourceList;
	}

	public void setResourceList(String resourceList) {
		this.resourceList = resourceList;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
