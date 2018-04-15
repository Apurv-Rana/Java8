package com.apurv.apurv.collection.metric;

public class ConverterFactory {
	public static MetricConverter getConverter(int choice)
	{
		switch(choice)
		{
			case 1: return new InchToFeet();
			case 2: return new InchToMeter();
			case 3:	return new FeetToInch();
			case 4:	return new FeetToMeter();
			case 5:	return new MeterToInch();
			case 6: return new MeterToFeet();
		}
		return null; 
	}

}
