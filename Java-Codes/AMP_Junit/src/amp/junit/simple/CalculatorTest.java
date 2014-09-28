package amp.junit.simple;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	Calculator calc = new Calculator();
	
	@Before
	public void prepareCalc(){
		calc.setI(20);
		calc.setJ(20);
	}
	
	@Test
	public void testAdd() {
		assertEquals("10+5=15", 40, calc.add());
	}
}
