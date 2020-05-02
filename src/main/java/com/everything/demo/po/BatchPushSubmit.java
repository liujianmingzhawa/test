package com.everything.demo.po;

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BatchPushSubmit extends BaseObject{
	private static final long serialVersionUID = 2466812375580102162L;

    @JsonProperty("dest_number_parameters")
    private List<Map<String, String>> destNumberParameters;

	public List<Map<String, String>> getDestNumberParameters() {
		return destNumberParameters;
	}

	public void setDestNumberParameters(List<Map<String, String>> destNumberParameters) {
		this.destNumberParameters = destNumberParameters;
	}









}
