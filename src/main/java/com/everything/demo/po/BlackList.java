package com.everything.demo.po;
	

import java.util.Date;

public class BlackList extends BaseObject {
    private static final long serialVersionUID = 8964926370597713115L;

    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String blackNumber;

    private String channelName;
    
    private Integer type;

    private String description;

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

    public String getBlackNumber() {
        return blackNumber;
    }

    public void setBlackNumber(String blackNumber) {
        this.blackNumber = blackNumber == null ? null : blackNumber.trim();
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}