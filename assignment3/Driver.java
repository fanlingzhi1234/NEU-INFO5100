package assignment3;

public class Driver {
	public static void main(String args[]) {
		Psychiatrist psychiatrist = new Psychiatrist("bob");
		Moody sad = new Sad();
		Happy happy = new Happy();
		
		
		psychiatrist.examine(sad);
		psychiatrist.observe(sad);
		
		psychiatrist.examine(happy);
		psychiatrist.observe(happy);
		
	}
}
