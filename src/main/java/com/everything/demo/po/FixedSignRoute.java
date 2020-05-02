package com.everything.demo.po;

import java.util.Date;



public class FixedSignRoute extends BaseObject{
	private static final long serialVersionUID = -2731748553135766739L;

	private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String destChannel;

    private String signature;

    private String extendCode;

    private Integer isValid;

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

	public String getDestChannel() {
		return destChannel;
	}

	public void setDestChannel(String destChannel) {
		this.destChannel = destChannel;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getExtendCode() {
		return extendCode;
	}

	public void setExtendCode(String extendCode) {
		this.extendCode = extendCode;
	}

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

}