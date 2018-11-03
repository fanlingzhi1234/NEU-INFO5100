package assignment7;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.validator.ValidateWith;

class MergeIntervalTest {

	
	
	@Test
	void test() {
		MergeInterval mer = new MergeInterval();
		
		Interval a = new Interval(1,4);
		Interval b = new Interval(4,5);
		Interval c = new Interval(4,10);
		Interval d = new Interval(12,19);
		
		List<Interval> list = new ArrayList<Interval>() ;
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		
		List<Interval> blist = new ArrayList<Interval>() ;
		Interval e = new Interval(1,10);
		Interval f = new Interval(12,19);
		blist.add(e);
		blist.add(f);
		
		
		assertEquals(blist, mer.merge(list));
	}

}
