package assignment3;


public class Sad extends Moody{
	
	public String mood = "Sad";
	
	public Sad() {
		
	}
	//Override
	protected String getMood() {
		return "i feel sad today!";
	}
	
	
	
	public String toString() {
		return ("Subject cries a lot");
	}
	@Override
	protected void expressFeelings() {
		String express = "'wah','weep','boo hoo','sob'";
		System.out.println(express);
	}
	
	
}
