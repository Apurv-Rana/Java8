package com.apurv.apurv.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.stereotype.Component;

@Embeddable
public class PassangerKey implements Serializable {

	@Column(name = "name")
	String name;
	@Column(name = "date")
	String date;
	@Column(name = "trainno")
	int trainno;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "PassangerKey [name=" + name + ", date=" + date + ", trainno=" + trainno + "]";
	}

	public int getTrainno() {
		return trainno;
	}

	public void setTrainno(int trainno) {
		this.trainno = trainno;
	}
}
