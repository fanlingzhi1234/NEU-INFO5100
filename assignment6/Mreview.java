package assignment6;

import java.util.*;


public class Mreview extends java.lang.Object implements java.lang.Comparable<Mreview>{
	
	private String title;
	private ArrayList<Integer> ratings;
	
	//Constructor
	
	public Mreview() {
		this.title = "";
		this.ratings = new ArrayList<>();
	}
	
	public Mreview(java.lang.String ttl) {
		this.title = ttl;
		this.ratings = new ArrayList<>();
	}
	
	public Mreview(java.lang.String ttl, int firstRating) {
		this.title = ttl;
		this.ratings = new ArrayList<>(firstRating);
	}
	
	public static void main(String args[]) {
		Mreview a = new Mreview("Kill Bill");
		Mreview b = new Mreview("Venmo", 4);
		Mreview c = new Mreview("KingKong", 5);
		
		a.addRating(1);
		a.addRating(3);
		a.addRating(5);
		a.addRating(4);
		a.addRating(4);
		
		b.addRating(5);
		b.addRating(3);
		
		c.addRating(5);
		c.addRating(4);
		c.addRating(3);
		
		a.toString();
		b.toString();
		c.toString();
		
		a.aveRating();
		b.aveRating();
		c.aveRating();
		
		a.compareTo(b);
		a.equals(b);
		a.compareTo(c);
	}
	
	//Method
	
	public java.lang.String getTitle() {
		return title;
	}
	
	public void addRating(int r) {
		ratings.add(r);
	}
	
	public double aveRating() {
		double result=0;
		for(int a: ratings) {
			result += a;
		}
		result = result / ratings.size();
		return result;
	}
	
	public int numRatings() {
		return ratings.size();
	}
	
	@Override
	public int compareTo(Mreview obj) {
		if(this == obj) {
			return 0;
		}
		
		int len1 = title.length();
	    int len2 = obj.title.length();
	    int lim = Math.min(len1, len2);
	    char[] v1 = title.toCharArray();
	    char[] v2 = obj.title.toCharArray();
	 
	    int k = 0;
	    while (k < lim) {
	        char c1 = v1[k];
	        char c2 = v2[k];
	        if (c1 != c2) {
	            return c1 - c2;
	        }
	        k++;
	    }
	    return len1 - len2;
	}
	
	@Override
	public boolean equals(java.lang.Object obj) {
		
		if (this == obj) {  
	          return true;  
	    }  
		return false;
	}
	
	@Override
	public java.lang.String toString(){
		return (this.getTitle() + ", average " + this.aveRating() + " out of " + this.numRatings() + " ratings!");
	}
}
