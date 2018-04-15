package com.apurv.oldway.service;

public class StandardOutMessageRenderer implements IMessageRenderer {
private IMessageProvider messageProvider = null;
	
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
