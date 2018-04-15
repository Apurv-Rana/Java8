package com.apurv.apurv.collection.metric;

public class InchToMeter implements MetricConverter{

	public double convert(double value) {
		return  (value/39.37);
	}

}
