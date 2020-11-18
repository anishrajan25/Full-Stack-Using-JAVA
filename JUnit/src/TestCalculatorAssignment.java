import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCalculatorAssignment {
	
	Calculator ob;
	
	@Before
	public void beforeCheck() {
		ob = new Calculator();
		System.out.println("Before");
	}

	@Test
	public void mintest() {
		int ans = ob.min(new int[] {-3, 0, 5});
		assertEquals(-3, ans);
		System.out.println("Min Test");
	}
	
	@Test
	public void maxtest() {
		int ans = ob.max(new int[] {-3, 0, 5});
		assertEquals(5, ans);
		System.out.println("Max Test");
	}
	
	@Test
	public void avgtest() {
		double ans = ob.avg(new int[] {-3, 0, 5});
		assertEquals((double)0.666666, ans, 0.0001);
		System.out.println("Sub Test");
	}

}
