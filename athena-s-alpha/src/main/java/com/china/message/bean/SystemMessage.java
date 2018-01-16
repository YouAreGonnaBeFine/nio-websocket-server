package com.china.message.bean;

import java.io.Serializable;

public class SystemMessage implements Serializable {

	private static final long serialVersionUID = -7771684300625389801L;

	private Long id;

	private String user;

	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
