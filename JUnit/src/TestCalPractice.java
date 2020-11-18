import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCalPractice {
	
	Calculator ob;
	
	@Before
	public void beforeCheck() {
		ob = new Calculator();
		System.out.println("Before");
	}
	
	@BeforeClass
	public static void beforeClassCheck() {
		int n = 4;
		assertTrue(n > 0);
		System.out.println("Before Class");
	}

	@Test
	public void addtest() {
//		fail("Not yet implemented");
		int ans = ob.add(4, 5);
		assertEquals(9, ans);
		assertEquals(10, ans);
		System.out.println("Add Test");
	}
	
	@Test
	public void subtest() {
		int ans = ob.sub(10, 5);
		assertEquals(5, ans);
		assertEquals(10, ans);
		System.out.println("Sub Test");
	}
	
	@AfterClass
	public static void AfterClassCheck() {
		int n = 4;
		assertFalse(n < 0);
		System.out.println("After Class");
	}
}
