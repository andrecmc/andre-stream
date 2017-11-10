package andre.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import andre.TestStream;

public class MyTest {

	@Test
	public void testCase1() {
		TestStream testStream=new TestStream("aAbBABacafe");
		int charFound=TestStream.firstChar(testStream);
		//assert(charFound=='e');
		assertEquals(""+(char)(charFound),""+'e');
	}

	@Test
	public void testCase2() {
		/*
		TestStream testStream=new TestStream("abaacaaceifiogouhu");
		int charFound=TestStream.firstChar(testStream);
		assert(charFound=='e');
		*/
	}
}
