package com.everything.demo.common;



public class HttpResult extends BaseObject {
    private static final long serialVersionUID = 7330650245228827183L;

    private Integer statusCode;

    private String httpBody;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getHttpBody() {
        return httpBody;
    }

    public void setHttpBody(String httpBody) {
        this.httpBody = httpBody;
    }
}
