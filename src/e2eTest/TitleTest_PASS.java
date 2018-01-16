package e2eTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Config;

public class TitleTest_PASS extends Config{

	@Test
	public void This_title_Test (){

		String act = driver.getTitle();
		String exp = "Facebook - Log In or Sign Up";
		boolean b = exp.equals(act);

		if (!b) {
			APPLICATION_LOGS.debug("Expected: " + exp + " | Actual: " + act + " = " + b);		
			System.err.println ("Expected: " + exp + " | Actual: " + act + " = " + b);
			Assert.assertEquals(act, exp);
		}
		System.out.println ("Expected: " + exp + " | Actual: " + act + " = " + b);
		APPLICATION_LOGS.debug("Actual is: " + act + " Expected is " + exp +  ". They both Matched");

	};
}
