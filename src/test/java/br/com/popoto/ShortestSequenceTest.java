package br.com.popoto;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ShortestSequenceTest {

	private ShortestSequence shortestSequence = new ShortestSequence();
	
	private List<Integer> validResult01 = new ArrayList<Integer>();
	private List<String> tags01 = new ArrayList<String>();
	private List<String> availableTags01 = new ArrayList<String>();
	
	private List<Integer> validResult02 = new ArrayList<Integer>();
	private List<String> tags02 = new ArrayList<String>();
	private List<String> availableTags02 = new ArrayList<String>();
	
	private List<Integer> validResult03 = new ArrayList<Integer>();
	private List<String> tags03 = new ArrayList<String>();
	private List<String> availableTags03 = new ArrayList<String>();	
	
	private List<Integer> validResult04 = new ArrayList<Integer>();
	private List<String> tags04 = new ArrayList<String>();
	private List<String> availableTags04 = new ArrayList<String>();	
	
	@Before
	public void doBefore() {
		
		//case01
		validResult01.add(5);
		validResult01.add(8);
		
		tags01.add("made");
		tags01.add("in");
		tags01.add("spain");
		
		availableTags01.add("made");
		availableTags01.add("weather");
		availableTags01.add("forecast");
		availableTags01.add("says");
		availableTags01.add("that");
		availableTags01.add("made");
		availableTags01.add("rain");
		availableTags01.add("in");
		availableTags01.add("spain");
		availableTags01.add("stays");
		
		//case02
		validResult02.add(1);
		validResult02.add(3);

		tags02.add("2abc");
		tags02.add("bcd");
		tags02.add("cab");
		
		availableTags02.add("dbc");
		availableTags02.add("2abc");
		availableTags02.add("cab");
		availableTags02.add("bcd");
		availableTags02.add("bcb");		
		
		//case03
		validResult03.add(3);
		validResult03.add(6);
		
		tags03.add("in");
		tags03.add("the");
		tags03.add("spain");
		
		availableTags03.add("the");
		availableTags03.add("spain");
		availableTags03.add("that");
		availableTags03.add("the");
		availableTags03.add("rain");
		availableTags03.add("in");
		availableTags03.add("spain");
		availableTags03.add("stays");
		availableTags03.add("forecast");
		availableTags03.add("in");
		availableTags03.add("the");	
		
		//case04
		tags04.add("no");
		tags04.add("result");
		
		availableTags04.add("empty");
		availableTags04.add("invalid");
		
	}
	
	@Test
	public void testCase01() {
		List<Integer> result = new ArrayList<Integer>();
		result = shortestSequence.calculate(tags01, availableTags01);
		assertEquals(validResult01, result);
	}
	
	@Test
	public void testCase02() {
		List<Integer> result = new ArrayList<Integer>();
		result = shortestSequence.calculate(tags02, availableTags02);
		assertEquals(validResult02, result);
	}	

	@Test
	public void testCase03() {
		List<Integer> result = new ArrayList<Integer>();
		result = shortestSequence.calculate(tags03, availableTags03);
		assertEquals(validResult03, result);
	}	
	
	@Test
	public void testCase04() {
		List<Integer> result = new ArrayList<Integer>();
		result = shortestSequence.calculate(tags04, availableTags04);
		assertEquals(validResult04, result);
	}	
	
}
