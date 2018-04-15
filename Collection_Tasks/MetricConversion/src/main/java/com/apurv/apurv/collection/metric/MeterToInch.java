package com.apurv.apurv.collection.metric;

public class MeterToInch implements MetricConverter {

	public double convert(double value) {
		return (value*39.37);
	}

}
