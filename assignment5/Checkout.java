package assignment5;

import java.util.ArrayList;
import java.util.List;
import assignment5.Candy;

public class Checkout extends java.lang.Object{
	
	List<DessertItem> list;
	public float taxRate = DessertShoppe.taxRate;
	
	public Checkout() {
		 this.list = new ArrayList<DessertItem>();
	}
	
	public int numberOfItems() {
		return this.list.size();
	}
	
	public void enterItem(DessertItem item) {
		this.list.add(item);
	}
	
	public void clear() {
		this.list.clear();
	}
	
	public int totalCost() {
		int i=0;
		int totalcost=0;
		
		while(i < this.list.size()) {
			DessertItem a = this.list.get(i);
			totalcost += a.getCost();
			i++;
		}
		return totalcost;
	}
	
	public int totalTax() {
		float totaltax = 0;
		if(totalCost() != 0) {
			totaltax = taxRate * totalCost();
			return (int)totaltax;
		}
		else 
			throw new RuntimeException ("There is no goods!");
		
		
	}
	@Override
	public java.lang.String toString(){
		StringBuilder sb = new StringBuilder();		
		DessertShoppe shoppe = new DessertShoppe();
		
		sb.append("\tM & M Dessert Shoppe\n");
		sb.append("\t--------------------\n");
		sb.append("\n");
		
		int i=0;
		
		while(i <list.size()) {
			if(list.get(i) instanceof Candy) {
				sb.append("\t" + ((Candy) list.get(i)).weight + " lbs. @ " + 
						shoppe.cents2dollarsAndCents(((Candy) list.get(i)).pricePerPount) +
						" /lb."+"\n");
			}
			else if(list.get(i) instanceof Cookie) {
				sb.append("\t" + ((Cookie) list.get(i)).number + " @ " + 
						shoppe.cents2dollarsAndCents(((Cookie) list.get(i)).pricePerDozen) +
						" /dz."+"\n");
			}
			else if(list.get(i) instanceof Sundae) {
				sb.append("\t" + ((Sundae) list.get(i)).topping + " Sundae with" + "\n");
			}
			sb.append("\t"+list.get(i).name );
			sb.append("\t\t"+shoppe.cents2dollarsAndCents(list.get(i).getCost()) + "\n");
			i++;
		}
		sb.append("\n");
		sb.append("\t"+"Tax \t\t" + shoppe.cents2dollarsAndCents(totalTax()) +"\n");
		sb.append("\t"+"Total Cost \t" + shoppe.cents2dollarsAndCents(totalCost()+totalTax())+"\n");
		return sb.toString();
	}
}
