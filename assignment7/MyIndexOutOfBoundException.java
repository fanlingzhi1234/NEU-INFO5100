package assignment7;


public class MyIndexOutOfBoundException extends Exception {
	public static int lowerbound;
	public static int highbound;
	public static int index;
	
	public MyIndexOutOfBoundException(int index, int lowerbound, int highbound) {
		// TODO Auto-generated constructor stub
		toString();
		
		
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return ("Error Message: Index: " + index + ", but Lower bound: " + 
				lowerbound +", Upper bound: "+ highbound );
	}
	
	public static void main(String[] args) throws MyIndexOutOfBoundException {
		// TODO Auto-generated method stub
		lowerbound = 5;
		highbound = 10;
		index = 3;
		
		if(index > highbound || index < lowerbound){
	        throw new MyIndexOutOfBoundException(index, lowerbound, highbound);
	    }

	}
	//Error Message: Index: 10, but Lower bound: 0, Upper bound: 9”
		
		
	
}
