package com.everything.demo.po;

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UploadResourcesMms extends BaseObject {
	private static final long serialVersionUID = -1419853208299423960L;

	@JsonProperty("access_key")
    private String accessKey;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("nonce")
    private String nonce;
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("resource_list")
    private List<Map<String, String>> resourceList;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Map<String, String>> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<Map<String, String>> resourceList) {
		this.resourceList = resourceList;
	}
	
}
