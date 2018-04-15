package com.apurv.apurv.collection.metric;

public class MeterToFeet implements MetricConverter {

	public double convert(double value) {
		return (value*3.281);
	}

}
