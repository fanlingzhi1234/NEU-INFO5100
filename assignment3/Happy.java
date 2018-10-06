package assignment3;


public class Happy extends Moody{
	
	public String mood = "Happy";
	
	public Happy() {
		
	}
	//Override
	protected  String getMood() {
		return "i fell happy today!";
	}
	
	protected  void expressFeelings() {
		String express = "HEHEHEHE.....HAHAHHAHAHA......HAHAHAHAHAHH!!!!";
		System.out.println(express);
	}
	
	public String toString() {
		return ("Subject laughs a lot");
	}
}
