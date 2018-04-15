package com.apurv.apurv.collection.metric;

public class FeetToMeter implements MetricConverter
{

	public double convert(double value) {
		
		return (value/3.281);
		
	}

}
