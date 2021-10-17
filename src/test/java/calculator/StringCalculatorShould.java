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
	
  
}
