package com.softserve.edu.oms.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UrlRepository;
import com.softserve.edu.oms.data.UrlRepository.Urls;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.page.AdminHomePage;
import com.softserve.edu.oms.page.AdministrationPage;
import com.softserve.edu.oms.page.AdministrationPage.AdministrationPageConditions;
import com.softserve.edu.oms.page.AdministrationPage.AdministrationPageFields;
import com.softserve.edu.oms.page.CustomerHomePage;
import com.softserve.edu.oms.page.DemoHomePage;
import com.softserve.edu.oms.page.LoginPage;
import com.softserve.edu.oms.page.LoginStartPage;
import com.softserve.edu.tools.BrowserRepository;
import com.softserve.edu.tools.IBrowser;
import com.softserve.edu.tools.WebDriverUtils;

public class LoginTest {

	@AfterClass
	public void tearDownAfterClass() throws Exception {
		WebDriverUtils.get().stop();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		WebDriverUtils.get().getWebDriver()
				.findElement(By.xpath("//a[@href='/dashboard/auth/logout/']")).click();
	}

	@DataProvider
	public Object[][] urlDataProvider() {
		return new Object[][] { { UrlRepository.Urls.SSU_HOST.toString() },
		// { UrlRepository.getClass86Url() },
		// { UrlRepository.getSsuUrl() }
		};
	}

	@Test(dataProvider = "urlDataProvider")
	public void checkDemoLogin(String url) {
		// Steps
		// LoginPage loginpage = new LoginPage(driver);
		// AdminHomePage adminHomePage =
		// loginpage.successAdminLogin(UserRepository.getAdminUser());
		DemoHomePage demoHomePage = LoginStartPage.load(url)
				.successDemoLogin(UserRepository.getDemoUser());
		// Check
	//	Assert.assertEquals(UserRepository.getAdminUser().getFirstName(),
	//			adminHomePage.getFirstName());
	//	Assert.assertEquals(UserRepository.getAdminUser().getLastName(),
	//			adminHomePage.getLastName());
	//	Assert.assertEquals(UserRepository.getAdminUser().getRole(),
	//			adminHomePage.getRole());
	}

	// @Test(dataProvider = "urlDataProvider")

	/*
	 * 
	 * public void checkInvalid(String url) { // Steps LoginPage loginpage =
	 * LoginStartPage.load(url); loginpage =
	 * loginpage.unSuccesfulLogin(UserRepository.getInvalidUser()); // Check
	 * Assert.assertEquals(LoginPage.INVALID_LOGIN_VALIDATOR,
	 * loginpage.getInvalidLoginValidator()); }
	 * 
	 * 
	 * 
	 * 
	 * //@Test(dataProvider = "urlDataProvider") public void
	 * checkAdminLogin(String url) { // Steps // LoginPage loginpage = new
	 * LoginPage(driver); // AdminHomePage adminHomePage = //
	 * loginpage.successAdminLogin(UserRepository.getAdminUser()); AdminHomePage
	 * adminHomePage = LoginStartPage.load(url)
	 * .successAdminLogin(UserRepository.getAdminUser()); // Check
	 * Assert.assertEquals(UserRepository.getAdminUser().getFirstName(),
	 * adminHomePage.getFirstName());
	 * Assert.assertEquals(UserRepository.getAdminUser().getLastName(),
	 * adminHomePage.getLastName());
	 * Assert.assertEquals(UserRepository.getAdminUser().getRole(),
	 * adminHomePage.getRole()); }
	 * 
	 * 
	 * //@Test(dataProvider = "urlDataProvider") public void
	 * checkCustomerLogin(String url) { // Steps // LoginPage loginpage = new
	 * LoginPage(driver); // AdminHomePage adminHomePage = //
	 * loginpage.successAdminLogin(UserRepository.getAdminUser());
	 * CustomerHomePage customerHomePage = LoginStartPage.load(url)
	 * .successCustomerLogin(UserRepository.getCustomerUser()); // Check
	 * Assert.assertEquals(UserRepository.getCustomerUser().getFirstName(),
	 * customerHomePage.getFirstName());
	 * Assert.assertEquals(UserRepository.getCustomerUser().getLastName(),
	 * customerHomePage.getLastName());
	 * Assert.assertEquals(UserRepository.getCustomerUser().getRole(),
	 * customerHomePage.getRole()); }
	 * 
	 * @DataProvider public Object[][] searchProvider() { return new Object[][]
	 * { { BrowserRepository.getFirefoxByTemporaryProfile(),
	 * Urls.SSU_HOST.toString(), UserRepository.getSearchUser() }, {
	 * BrowserRepository.getChromeByTemporaryProfile(),
	 * Urls.SSU_HOST.toString(), UserRepository.getSearchUser() }, // {
	 * BrowserRepository.getChromeByTemporaryProfile() } }; }
	 * 
	 * @Test(dataProvider = "searchProvider") public void
	 * checkSearchByLogin(IBrowser browser, String url, IUser searchUser) throws
	 * InterruptedException { // Preconditions AdministrationPage
	 * administrationPage = LoginStartPage.load(browser, url)
	 * .successAdminLogin(UserRepository.getAdminUser())
	 * .navigateToAdministrationPage(); // Steps
	 * administrationPage.searchByLoginName(AdministrationPageFields.LOGIN_NAME,
	 * AdministrationPageConditions.STARTS_WITH, searchUser); // Check
	 * Assert.assertEquals(administrationPage.getFirstName().getText(),
	 * searchUser.getLastName());
	 * Assert.assertEquals(administrationPage.getFirstName().getText(),
	 * searchUser.getLastName()); // Return to previous state
	 * Thread.sleep(4000); administrationPage.logoutClick(); }
	 */
}