package assignment5;



public abstract class DessertItem extends java.lang.Object{

	
	
	protected java.lang.String name;
	public DessertItem() {
		
	}
	
	public DessertItem(java.lang.String name) {
		this.name = name;
	}
	
	public final java.lang.String getName(){
		return name;
	}
	
	public abstract int getCost();
	
}
