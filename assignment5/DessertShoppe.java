package assignment5;

import java.text.NumberFormat;
import java.util.Locale;

public class DessertShoppe {

	public static final float taxRate = 0.066f;
	public static final String shopName = "M & M Dessert Shoppe";
	public static final int maxSizeOfItemName = 20;
	public static final int maxWidthToDisplay = 30;

	public String cents2dollarsAndCents(int cost) {
		
		NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US); 
		String s = n.format(cost / 100.0);
		return s;
	}
}
