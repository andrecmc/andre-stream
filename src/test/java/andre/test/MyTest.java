package andre.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import andre.StreamUtil;
import andre.StringStream;

public class MyTest {

	@Test
	public void testCase1() {
		StringStream testStream=new StringStream("aAbBABacafe");
		int charFound=StreamUtil.findFirstVowel(testStream);
		//assert(charFound=='e');
		assertEquals(new Character('e'), new Character((char)(charFound)));
	}

	@Test
	public void testCase2() {
		StringStream testStream=new StringStream("abacdadagggifoagoduihe");
		int charFound=StreamUtil.findFirstVowel(testStream);
		assertEquals(new Character('u'), new Character((char)(charFound)));
	}
	
	@Test
	public void testCase3() {
		StringStream testStream=new StringStream("abo");
		int charFound=StreamUtil.findFirstVowel(testStream);
		assertEquals(new Character('o'), new Character((char)(charFound)));
	}
	
	@Test
	public void testCase4() {
		StringStream testStream=new StringStream("abobbe");
		int charFound=StreamUtil.findFirstVowel(testStream);
		assertEquals(new Character('o'), new Character((char)(charFound)));
	}
	
	@Test
	public void testCase5() {
		StringStream testStream=new StringStream("abaaba");
		int charFound=StreamUtil.findFirstVowel(testStream);
		assertEquals(new Character((char)0), new Character((char)(charFound)));
	}
	
	@Test
	public void testCase6() {
		StringStream testStream=new StringStream("abbe");
		int charFound=StreamUtil.findFirstVowel(testStream);
		assertEquals(new Character((char)0), new Character((char)(charFound)));
	}
	
	@Test
	public void testCase7() {
		StringStream testStream=new StringStream("abbebakk");
		int charFound=StreamUtil.findFirstVowel(testStream);
		assertEquals(new Character((char)'a'), new Character((char)(charFound)));
	}
	
	@Test
	public void testCase8() {
		StringStream testStream=new StringStream("abbebakkido");
		int charFound=StreamUtil.findFirstVowel(testStream);
		assertEquals(new Character((char)'a'), new Character((char)(charFound)));
	}
	
	@Test
	public void testCase9() {
		StringStream testStream=new StringStream("abbebakkaido");
		int charFound=StreamUtil.findFirstVowel(testStream);
		assertEquals(new Character((char)'o'), new Character((char)(charFound)));
	}
}
