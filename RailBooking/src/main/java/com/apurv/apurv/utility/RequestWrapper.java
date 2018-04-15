package com.apurv.apurv.utility;

import com.apurv.apurv.entities.AvailKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apurv.apurv.entities.Passanger;


public class RequestWrapper {
	
	AvailKey key;

	Passanger passanger;

	public AvailKey getKey() {
		return key;
	}

	public void setKey(AvailKey key) {
		this.key = key;
	}

	public Passanger getPassanger() {
		return passanger;
	}

	public void setPassanger(Passanger passanger) {
		this.passanger = passanger;
	}
}
