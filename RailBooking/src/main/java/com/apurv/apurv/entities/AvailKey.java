package com.apurv.apurv.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.stereotype.Component;

@Embeddable
public class AvailKey implements Serializable {
	@Column(name = "date")
	String date;

	@Override
	public String toString() {
		return "AvailKey [date=" + date + ", trainno=" + trainno + "]";
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTrainno() {
		return trainno;
	}

	public void setTrainno(int trainno) {
		this.trainno = trainno;
	}

	@Column(name = "trainno")
	int trainno;
}
