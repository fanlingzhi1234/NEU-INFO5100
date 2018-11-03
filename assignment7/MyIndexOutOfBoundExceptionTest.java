package assignment7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyIndexOutOfBoundExceptionTest {

	public static int lowerbound;
	public static int highbound;
	public static int index;
	public MyIndexOutOfBoundException aBoundException;
	
	@BeforeEach
	void setUp() throws Exception {
		//MyIndexOutOfBoundExceptionTest aBoundExceptionTest = new MyIndexOutOfBoundExceptionTest();
		
	}

	@Test
	void test() {
		lowerbound = 5;
		highbound = 10;
		index = 3;
		aBoundException = new MyIndexOutOfBoundException(index, lowerbound, highbound);
		
		assertEquals("Error Message: Index: 3, but Lower bound: 5, Upper bound: 10", aBoundException.toString());
	}

}
