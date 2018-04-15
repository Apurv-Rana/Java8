package com.apurv.oldway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("renderer")
public class StandardOutMessageRenderer implements IMessageRenderer {

	@Autowired
	
	private IMessageProvider messageProvider ;

	
	public void setMessageProvider(IMessageProvider provider) {
		this.messageProvider = provider;
	}

	public void render() {
	
		if(messageProvider == null) {
			throw new RuntimeException("you must set messageProvider");
		}
		System.out.println(messageProvider.getMessage());
	}

	public StandardOutMessageRenderer(IMessageProvider messageProvider) {
		super();
		this.messageProvider = messageProvider;
	}

	public IMessageProvider getMessageProvider() {
		return messageProvider;
	}

}
