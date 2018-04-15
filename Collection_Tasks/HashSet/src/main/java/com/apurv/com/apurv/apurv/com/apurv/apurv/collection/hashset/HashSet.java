package com.apurv.com.apurv.apurv.com.apurv.apurv.collection.hashset;



public class HashSet<T> {

	Node[] buckets ;
	public final int capacity=16 ;
@Override
	public String toString()
	{
		String s = "";
		Node[] n = this.buckets;
		int i =0;
		
		while(i!=15)
		{ 
			
					if(this.buckets[i]!=null)
					{
						
	Node t = this.buckets[i] ; 
	while(t!=null)
	{
		s=s+t.data+",";
		t= t.next;
		
	}

					}
			
			i++;
		}
	return s;}


public boolean contains(T o)
{
	

	for(Node n : buckets)
	{
		while(n!=null) {
		if(n.data.equals(o))
		{
			return true ;
		} 
		n=n.next;
		}
		
		
	}
	return false;
	}

	
	public HashSet ()
	{
		this.buckets=new Node[16];
		
		
	}
	
	public boolean remove(T o)
	{
	
		for(Node n : buckets)
		{
			if(n!=null)
			{
				Node current=n ;
				Node previous =null;
				while(current !=null)
				{
					
					if(current.data.equals(o)) {
						
						previous = current.next;
						break;
					}
					else
					{
						
						previous = current ;
						current = current.next;
						
					}

				}
			}
			
			}
			
			
		
	
	return true ;} 
	
	public boolean add(T o)
	{
		int key = getHashCode(o);
		
	if(buckets[key]!=null)
	{
		for(Node n : buckets)
		{
			while(n!=null) {
			if(n.data.equals(o))
			{
				return false ;
			} 
			n=n.next;
			}
			
			
		}}
		
		if(buckets[key] == null)
		{
			buckets[key] = new Node(o); 
			return true ;
		}
		else
		{
			Node n = buckets[key];
			
			while(n.next!=null)
			{
				n = n.next;
				
				
				
				
				
				
			}
			
			n.next = new Node(o);
			
			
			return true ;
		}
			
		
	
		

			}
	
	public int getHashCode(T o)
	{
		return o.hashCode()%capacity ;
	}
	
	
}
