package assignment5;

public class IceCream extends DessertItem{

	public int cost;
	
	public IceCream() {
		// TODO Auto-generated constructor stub
	}
	public IceCream(String name, int cost) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.cost = cost;
	}
	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		//System.out.println("icecream cost :" +cost);
		return cost;
	}

}
