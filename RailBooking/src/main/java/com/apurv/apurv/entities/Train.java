package com.apurv.apurv.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity(name = "train")
public class Train {

	@Id
	@Column(name = "trainno")
	int trainno;
	@Column(name = "trainname")
	String trainname;
	@Column(name = "source")
	String source;
	@Column(name = "destination")
	String destination;
	@Column(name = "distance")
	int distance;

	@Override
	public String toString() {
		return "Train [trainno=" + trainno + ", trainname=" + trainname + ", source=" + source + ", destination="
				+ destination + ", distance=" + distance + "]";
	}

	public int getTrainno() {
		return trainno;
	}

	public void setTrainno(int trainno) {
		this.trainno = trainno;
	}

	public String getTrainname() {
		return trainname;
	}

	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

}
