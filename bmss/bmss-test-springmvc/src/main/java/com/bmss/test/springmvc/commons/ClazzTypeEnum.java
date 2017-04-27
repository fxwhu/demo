package com.bmss.test.springmvc.commons;

public enum ClazzTypeEnum {
	
	BEST("尖子班"), ORDINARY("普通班"),EXPERIMENTAL("实验班");
	
	ClazzTypeEnum(String message) {
		this.message = message;
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}