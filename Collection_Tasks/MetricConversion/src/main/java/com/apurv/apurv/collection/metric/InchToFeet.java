package com.apurv.apurv.collection.metric;

public class InchToFeet implements MetricConverter {

	public double convert(double value) {
		return value / 12.0;
	}

}
