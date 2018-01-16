package e2eTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Config;
import locators.locators1;

public class FailTheTest extends Config {

	locators1 loc = new locators1();

	@Test
	public void FAIL_The_Test (){
		

		// invalid locator should fail it
		typeByXpath (loc.firstNameLoc, "firstNameLocatorShouldBeInvalid");
		APPLICATION_LOGS.debug("Could not type firstName. Could be locator issue. Please check log or report");
		String act = driver.getTitle();
		String exp = "facebook";
		boolean b = exp.equals(act);

		if (!b) {
			// Take Screenshot
			captureScreenshot("FAIL_The_Test" +timestamp());
			APPLICATION_LOGS.debug("Expected: " + exp + " | Actual: " + act + " = " + b );		
			System.err.println ("Expected: " + exp + " | Actual: " + act + " = " + b);
			Assert.assertEquals(act, exp);
		}
		APPLICATION_LOGS.debug("Actual is: " + act + " Expected is " + exp +  ". They both Matched");

	};

}

