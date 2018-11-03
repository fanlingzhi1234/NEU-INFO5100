package assignment7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRSPgame {

	public Scissors s;
	public Paper p;
	public Rock r;
	@BeforeEach
	void setUp() throws Exception {
		s = new Scissors(3);
        p = new Paper(8);
        r = new Rock(10);
	}

	@Test
	void test() {
		assertEquals(false, s.fight(p));
		assertEquals(true, p.fight(s));
		
		assertEquals(true, p.fight(r));
		assertEquals(false, r.fight(p));
		
		
		assertEquals(true, r.fight(s));
		assertEquals(false, s.fight(r));
		
		
		assertEquals(false, r.fight(r));
		assertEquals(false, s.fight(s));
		assertEquals(false, p.fight(p));
	}

}
