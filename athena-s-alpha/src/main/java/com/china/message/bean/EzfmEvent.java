package com.china.message.bean;

import java.io.Serializable;

public class EzfmEvent implements Serializable {

	private static final long serialVersionUID = -8133466565676008787L;

	private Long id;

	private String type;

	private Long targetID;

	private String targetType;

	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getTargetID() {
		return targetID;
	}

	public void setTargetID(Long targetID) {
		this.targetID = targetID;
	}

	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
