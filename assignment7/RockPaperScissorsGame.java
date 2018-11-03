package assignment7;

public class RockPaperScissorsGame {
	public static void main(String args[]){
        Scissors s = new Scissors(5);
        Paper p = new Paper(7);
        Rock r = new Rock(15);
        System.out.println(s.fight(p) + " , "+ p.fight(s) );
        System.out.println(p.fight(r) + " , "+ r.fight(p) );
        System.out.println(r.fight(s) + " , "+ s.fight(r) );
    }
}

class Tool {

	protected int strength;
	protected char type;
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
}

class Rock extends Tool{
	
	public Rock(int strength) {
		this.strength = strength;
		this.type = 'r';
	}
	
	public boolean fight(Tool other) {
		boolean res = false;
		int compareStrength = this.strength;
		if(other.type == 'p') {
			compareStrength = compareStrength / 2;
		}
		else if(other.type == 's') {
			compareStrength = compareStrength * 2;
		}
		
		if(compareStrength > other.strength) {
			res = true;
		}
		
		return res;
	}
}

class Paper extends Tool{
	
	public Paper(int strength) {
		this.strength = strength;
		this.type = 'p';
	}
	
	public boolean fight(Tool other) {
		boolean res = false;
		int compareStrength = this.strength;
		if(other.type == 's') {
			compareStrength = compareStrength / 2;
		}
		else if(other.type == 'r') {
			compareStrength = compareStrength * 2;
		}
		
		if(compareStrength > other.strength) {
			res = true;
		}
		
		return res;
	}
}

class Scissors extends Tool{
	
	public Scissors(int strength) {
		this.strength = strength;
		this.type = 's';
	}
	
	public boolean fight(Tool other) {
		boolean res = false;
		int compareStrength = this.strength;
		if(other.type == 'r') {
			compareStrength = compareStrength / 2;
		}
		else if(other.type == 'p') {
			compareStrength = compareStrength * 2;
		}
		
		if(compareStrength > other.strength) {
			res = true;
		}
		
		return res;
	}
}
