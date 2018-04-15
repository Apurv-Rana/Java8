package com.apurv.com.apurv.apurv.com.apurv.apurv.collection.hashset;

public class Main {
	public static void main(String[] args)
	{
		HashSet<Integer> h = new HashSet<Integer>();
		h.add(1);
		h.add(2);
	
	
		h.add(2);
		h.add(3);
		h.add(4);
		System.out.println(h.remove(1));
		System.out.println(h.contains(2));
		
		
	System.out.println(h);
	
		
		
	}
}
