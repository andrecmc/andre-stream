package andre.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import andre.TestStream;

public class MyTest {

	@Test
	public void testCase1() {
		TestStream testStream=new TestStream("aAbBABacafe");
		int charFound=TestStream.findFirstVowel(testStream);
		//assert(charFound=='e');
		assertEquals(new Character('e'), new Character((char)(charFound)));
	}

	@Test
	public void testCase2() {
		TestStream testStream=new TestStream("abacdadagggifoagoduihe");
		int charFound=TestStream.findFirstVowel(testStream);
		assertEquals(new Character('u'), new Character((char)(charFound)));
	}
	
	@Test
	public void testCase3() {
		TestStream testStream=new TestStream("abo");
		int charFound=TestStream.findFirstVowel(testStream);
		assertEquals(new Character('o'), new Character((char)(charFound)));
	}
	
	@Test
	public void testCase4() {
		TestStream testStream=new TestStream("abobbe");
		int charFound=TestStream.findFirstVowel(testStream);
		assertEquals(new Character('o'), new Character((char)(charFound)));
	}
	
	@Test
	public void testCase5() {
		TestStream testStream=new TestStream("abaaba");
		int charFound=TestStream.findFirstVowel(testStream);
		assertEquals(new Character((char)0), new Character((char)(charFound)));
	}
	
	@Test
	public void testCase6() {
		TestStream testStream=new TestStream("abbe");
		int charFound=TestStream.findFirstVowel(testStream);
		assertEquals(new Character((char)0), new Character((char)(charFound)));
	}
	
	@Test
	public void testCase7() {
		TestStream testStream=new TestStream("abbebakk");
		int charFound=TestStream.findFirstVowel(testStream);
		assertEquals(new Character((char)'a'), new Character((char)(charFound)));
	}
	
	@Test
	public void testCase8() {
		TestStream testStream=new TestStream("abbebakkido");
		int charFound=TestStream.findFirstVowel(testStream);
		assertEquals(new Character((char)'a'), new Character((char)(charFound)));
	}
	
	@Test
	public void testCase9() {
		TestStream testStream=new TestStream("abbebakkaido");
		int charFound=TestStream.findFirstVowel(testStream);
		assertEquals(new Character((char)'o'), new Character((char)(charFound)));
	}
}
