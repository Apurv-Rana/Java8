package com.apurv.apurv.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "available")
public class Available {

	@Override
	public String toString() {
		return "Available [myKey=" + myKey + ", Fc=" + Fc + ", Sl=" + Sl + "]";
	}

	@EmbeddedId
    private AvailKey myKey;

	@Column(name = "FC")
	int Fc;
	@Column(name = "SL")
	int Sl;

	public int getFc() {
		return Fc;
	}

	public void setFc(int fc) {
		Fc = fc;
	}

	public int getSl() {
		return Sl;
	}

	public void setSl(int sl) {
		Sl = sl;
	}

	public AvailKey getMyKey() {
		return myKey;
	}

	public void setMyKey(AvailKey myKey) {
		this.myKey = myKey;
	}

}
