package assignment3;

import java.util.jar.Attributes.Name;

public class Psychiatrist {

	public String name;
	public Psychiatrist(String name) {
		this.name = name;
	}
	
	public void examine(Moody moody) {
		System.out.println("How are you feeling today?");
		System.out.println(moody.getMood());
		System.out.println();
	}
	
	public void observe(Moody moody) {
		moody.expressFeelings();
		System.out.println("Observation: " + moody.toString());
		System.out.println();
	}
}
