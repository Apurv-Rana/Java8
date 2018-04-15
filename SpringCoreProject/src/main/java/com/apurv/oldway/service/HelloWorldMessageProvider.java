package com.apurv.oldway.service;

public class HelloWorldMessageProvider implements IMessageProvider {

	String message;
	public HelloWorldMessageProvider(String message) {
		super();
		this.message = message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

}
