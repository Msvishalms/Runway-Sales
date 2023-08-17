package testNG_Practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionTest {

	@Test
	public void softAssertTest()
	{
		System.out.println("--step1--");
		System.out.println("--step2--");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("a", "b");
		System.out.println("--step3--");
		System.out.println("--step4--");
		//sa.assertAll();
	}
	
	@Test
	public void demo()
	{
		System.out.println("--step5--");
		System.out.println("--step6--");
		int a=10;
		SoftAssert sa = new SoftAssert();
		sa.assertNull(a);
		//sa.assertAll();
	
	}
}
