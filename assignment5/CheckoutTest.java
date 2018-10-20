package assignment5;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckoutTest {
	
	/*
	 * 		Checkout checkout = new Checkout();

	        checkout.enterItem(new Candy("Peanut Butter Fudge", 2.25, 399));
	        checkout.enterItem(new IceCream("Vanilla Ice Cream", 105));
	        checkout.enterItem(new Sundae("Choc. Chip Ice Cream", 145, "Hot Fudge", 50));
	        checkout.enterItem(new Cookie("Oatmeal Raisin Cookies", 4, 399));

	        System.out.println("\nNumber of items: " + checkout.numberOfItems() + "\n");
	        System.out.println("\nTotal cost: " + checkout.totalCost() + "\n");
	        System.out.println("\nTotal tax: " + checkout.totalTax() + "\n");
	        System.out.println("\nCost + Tax: " + (checkout.totalCost() + checkout.totalTax()) + "\n");
	        System.out.println(checkout);

	        checkout.clear();

	        checkout.enterItem(new IceCream("Strawberry Ice Cream", 145));
	        checkout.enterItem(new Sundae("Vanilla Ice Cream", 105, "Caramel", 50));
	        checkout.enterItem(new Candy("Gummy Worms", 1.33, 89));
	        checkout.enterItem(new Cookie("Chocolate Chip Cookies", 4, 399));
	        checkout.enterItem(new Candy("Salt Water Taffy", 1.5, 209));
	        checkout.enterItem(new Candy("Candy Corn", 3.0, 109));

	        System.out.println("\nNumber of items: " + checkout.numberOfItems() + "\n");
	        System.out.println("\nTotal cost: " + checkout.totalCost() + "\n");
	        System.out.println("\nTotal tax: " + checkout.totalTax() + "\n");
	        System.out.println("\nCost + Tax: " + (checkout.totalCost() + checkout.totalTax()) + "\n");
	        System.out.println(checkout);
	      */
	      
	      
	public Checkout ClassUnderTest;

	@BeforeEach
	void setUp() throws Exception {
		
		ClassUnderTest = new Checkout();
		ClassUnderTest.enterItem(new Candy("Peanut Butter Fudge", 2.25, 399));
		ClassUnderTest.enterItem(new IceCream("Vanilla Ice Cream", 105));
		ClassUnderTest.enterItem(new Sundae("Choc. Chip Ice Cream", 145, "Hot Fudge", 50));
		ClassUnderTest.enterItem(new Cookie("Oatmeal Raisin Cookies", 4, 399));
		
	}

	@Test
	void testNumberOfItems() {
		int result = (4);
		assertEquals(result, ClassUnderTest.numberOfItems());
	}


	@Test
	void testTotalCost() {
		int result = (int) Math.round(2.25 *399 + 105 + 145 + 50 + 4*399/12);
		assertEquals(result, ClassUnderTest.totalCost());
	}

	@Test
	void testTotalTax() {
		int result = (int)(0.066f * (2.25 *399 + 105 + 145 + 50 + 4*399/12));
		assertEquals(result, ClassUnderTest.totalTax());
	}

	
}
