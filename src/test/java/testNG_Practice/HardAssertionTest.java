package testNG_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertionTest {
	
	@Test
	public void hardAssertTest()
	{
		System.out.println("--step1--");
		System.out.println("--step2--");
		Assert.assertEquals("a","b");
		System.out.println("--step3--");
		System.out.println("--step4--");
	}
	
	@Test
	public void demo()
	{
		System.out.println("--step5--");
		System.out.println("--step6--");
		int a=10;
		Assert.assertNull(a);
		System.out.println("--step7--");
	}
}
