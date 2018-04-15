package com.apurv.apurv.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name ="passanger")
public class Passanger {
	@EmbeddedId
	PassangerKey key;
	
	@Column(name="seatnumber")
	String seatnumber ;

	public PassangerKey getKey() {
		return key;
	}

	public void setKey(PassangerKey key) {
		this.key = key;
	}

	public String getSeatnumber() {
		return seatnumber;
	}

	@Override
	public String toString() {
		return "Passanger [key=" + key + ", seatnumber=" + seatnumber + "]";
	}

	public void setSeatnumber(String seatnumber) {
		this.seatnumber = seatnumber;
	}
	
}
