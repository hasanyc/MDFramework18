package e2eTest;

import org.testng.SkipException;
import org.testng.annotations.Test;

import base.Config;

public class SkipTheTest extends Config {


	@Test (enabled=true)
	public void SKIP_This_Test (){

		
		System.out.println("This test has been skipped");
		APPLICATION_LOGS.debug("Skipped this test since no longer needed!!");
		throw new SkipException ("Skipping because this test is no longer needed!!");

	}

}

