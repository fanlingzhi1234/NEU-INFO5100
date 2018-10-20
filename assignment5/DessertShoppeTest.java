package assignment5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DessertShoppeTest {
	public DessertShoppe dessertShoppeUnderTest;
	@BeforeEach
	void setUp() throws Exception {
		dessertShoppeUnderTest = new DessertShoppe();
	}

	@Test
	void testCents2dollarsAndCents() {
		String result = "$1.89";
		assertEquals(result, dessertShoppeUnderTest.cents2dollarsAndCents(189));
	}

}
