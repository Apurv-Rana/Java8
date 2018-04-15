package com.apurv.oldway.service;

import org.springframework.stereotype.Component;

@Component("messageprovider")
public class HelloWorldMessageProvider implements IMessageProvider {

	public String getMessage() {
		return "hello world";
	}

}
