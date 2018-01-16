package e2eTest;

import org.testng.annotations.Test;
import base.Config;
import locators.locators1;


public class PassTheTest extends Config {

	locators1 loc = new locators1();


	@Test
	public void PASS_The_Test (){

		// enter email address
		typeByXpath (loc.emailLoc, LOAD_EXCEL_FILE.getCellData("fb", "email", 2));
		// enter password
		typeByXpath (loc.passLoc, LOAD_EXCEL_FILE.getCellData("fb", "password", 2));
		// enter first name
		typeByXpath (loc.firstNameLocator, LOAD_EXCEL_FILE.getCellData("fb", "firstName", 2));
		// enter last name
		typeByXpath (loc.lastNameLocator, LOAD_EXCEL_FILE.getCellData("fb", "lastName", 2));

	};

}

