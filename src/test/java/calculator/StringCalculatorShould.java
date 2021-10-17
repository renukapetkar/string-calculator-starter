package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {

	
	@Test
	public void returnZeroOnEmptyString()
	{
		StringCalculator stringcalculator = new StringCalculator();
		assertEquals(0, stringcalculator.add(""));
	}
	@Test
	public void returnNumOnSingleArg()
	{
		StringCalculator stringcalculator = new StringCalculator();
		assertEquals(1, stringcalculator.add("1"));
	}
	@Test
	public void returnSumOnTwoArgsDelimitedByComma()
	{
		StringCalculator stringcalculator = new StringCalculator();
		assertEquals(3, stringcalculator.add("1,2"));
	}
	
	@Test
	public void returnSumOnMultipleArgsDelimitedByComma()
	{
		StringCalculator stringcalculator = new StringCalculator();
		assertEquals(6, stringcalculator.add("1,2,3"));
	}

	@Test
	public void acceptNewlineAsValidDelimiter()
	{
		StringCalculator stringcalculator = new StringCalculator();
		assertEquals(6, stringcalculator.add("1\n2,3"));
	}
	
	@Test
	public void customDelimeter()
	{
		StringCalculator stringcalculator = new StringCalculator();
		assertEquals(3, stringcalculator.add("//;\n1;2"));
	}
	
	@Test
	public void raiseExceptionOnNegativeNumbers()
	{
		StringCalculator stringcalculator = new StringCalculator();
		try {
			stringcalculator.add("-1,-2,3");
			fail("Exception expected.");
		}
		
		catch(RuntimeException e)
		{
			assertEquals("Negatives not allowed: [-1, -2]", e.getMessage());
		}
	}
	
	@Test
	public void validateCallCount()
	{
		StringCalculator stringcalculator = new StringCalculator();
		assertEquals(StringCalculator.getCallCount(), StringCalculator.count);
	}


	@Test
	public void ignoreNumsGrtThn1000()
	{
		StringCalculator stringcalculator = new StringCalculator();
		assertEquals(2, stringcalculator.add("2,1001"));
	}
	@Test
	public void validateAnyLengthDelimeter()
	{
		StringCalculator stringcalculator = new StringCalculator();
		assertEquals(6, stringcalculator.add("//[***]\n1***2***3"));
	}
	@Test
	public void multipleDelimeter()
	{
		StringCalculator stringcalculator = new StringCalculator();
		assertEquals(6, stringcalculator.add("//[*][%]\n1*2%3"));
	}
	@Test
	public void mulCustomDelWithAnyLength()
	{
		StringCalculator stringcalculator = new StringCalculator();
		assertEquals(6, stringcalculator.add("//[**][%%]\n1**2%%3"));
	}
	
  
}
