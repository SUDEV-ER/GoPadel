package goPadelTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import goPadelBase.TestBase;
import goPadelPages.GoPadelCourt;
import goPadelPages.GoPadelHome;
import goPadelPages.GoPadelLogin;

public class GoPadelTest extends TestBase {

	GoPadelLogin loginPage;
	GoPadelHome homePage;
	GoPadelCourt courtPage;
	private static final Logger log = LogManager.getLogger(GoPadelLogin.class);

	@Test(priority = 0)
	public void loginAndHomePageTest() {

		log.info("Verifying successful login.");
		loginPage = new GoPadelLogin(driver);
		homePage = loginPage.login("admin", "Admin@12345");
		homePage.clickOnPadelCourt();
	}
	
	@Test(priority = 1)
	public void PadelCourt_TC_01() {
		log.info("Verifying the details in Padel Court page");
		courtPage.Title();
		courtPage.AddCourtButton();
		courtPage.TableTitle();
		courtPage.SearchText();
		courtPage.SearchBox();
		courtPage.PreviousButton();
		courtPage.NextButton();
	}
}
