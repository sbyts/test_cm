package com.serhiy.edu.oms.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.serhiy.edu.oms.data.IUser;
import com.serhiy.edu.oms.data.ListUtils;
import com.serhiy.edu.oms.data.UrlRepository;
import com.serhiy.edu.oms.data.UserRepository;
import com.serhiy.edu.oms.data.UrlRepository.Urls;
import com.serhiy.edu.oms.page.AdminHomePage;
import com.serhiy.edu.oms.page.AdministrationPage;
import com.serhiy.edu.oms.page.CustomerHomePage;
import com.serhiy.edu.oms.page.LoginPage;
import com.serhiy.edu.oms.page.LoginStartPage;
import com.serhiy.edu.oms.page.AdministrationPage.AdministrationPageConditions;
import com.serhiy.edu.oms.page.AdministrationPage.AdministrationPageFields;
import com.serhiy.edu.tools.AssertWrapper;
import com.serhiy.edu.tools.BrowserRepository;
import com.serhiy.edu.tools.IBrowser;
import com.serhiy.edu.tools.WebDriverUtils;

public class LoginTest {

	@AfterClass
	public void tearDownAfterClass() throws Exception {
		WebDriverUtils.get().stop();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		WebDriverUtils.get().getWebDriver()
				.findElement(By.xpath("//a[@href='/cmf/logout']")).click();
	}

	@DataProvider
	public Object[][] userDataProvider() {
		return ListUtils.toMultiArray(UserRepository
				.getAllValidAdminUsersFormCSV());
	}

	@DataProvider
	public Object[][] userDataProperties() {
		return new Object[][] { { UserRepository.getValidUserFormProperties() }	};
	}

	//@Test(dataProvider = "userDataProvider")
	@Test(dataProvider = "userDataProperties")
	public void checkLogin(IUser user) {
		// Read Properties from Commandline
		  System.out.println("\n+++++Property: "
				    +System.getProperty("selenium-version"));
		// Steps
		AdminHomePage adminHomePage = LoginStartPage.load(
				UrlRepository.Urls.SSU_HOST.toString()).successAdminLogin(user);
		// Check
		// Assert.assertEquals(user.getFirstName(),
		// adminHomePage.getFirstName());
		// Assert.assertEquals(user.getLastName(),
		// adminHomePage.getLastName());
		// Assert.assertEquals(user.getRole(),
		// adminHomePage.getRole());
/*serhiy*		AssertWrapper.get()
			.forTextElement(adminHomePage.getFirstName())
				.isEqualText(user.getFirstName())
				.next()
			.forTextElement(adminHomePage.getLastName())
				.isEqualText(user.getLastName())
				.next()
			.forTextElement(adminHomePage.getRole())
				.isEqualText(user.getRole());

*serhiy*/			
			// Return to previous state
		adminHomePage.logout();
		AssertWrapper.get().check();
	}
/*serhiy*
	@DataProvider
	public Object[][] urlDataProvider() {
		return new Object[][] { { UrlRepository.Urls.SSU_HOST.toString() },
		// { UrlRepository.getClass86Url() },
		// { UrlRepository.getSsuUrl() }
		};
	}

	 @Test(dataProvider = "urlDataProvider")
	public void checkInvalid(String url) {
		// Steps
		LoginPage loginpage = LoginStartPage.load(url);
		loginpage = loginpage.unSuccesfulLogin(UserRepository.getInvalidUser());
		// Check
		Assert.assertEquals(LoginPage.INVALID_LOGIN_VALIDATOR,
				loginpage.getInvalidLoginValidator());
	}

	// @Test(dataProvider = "urlDataProvider")
	public void checkAdminLogin(String url) {
		// Steps
		// LoginPage loginpage = new LoginPage(driver);
		// AdminHomePage adminHomePage =
		// loginpage.successAdminLogin(UserRepository.getAdminUser());
		AdminHomePage adminHomePage = LoginStartPage.load(url)
				.successAdminLogin(UserRepository.getAdminUser());
		// Check
		Assert.assertEquals(UserRepository.getAdminUser().getFirstName(),
				adminHomePage.getFirstName());
		Assert.assertEquals(UserRepository.getAdminUser().getLastName(),
				adminHomePage.getLastName());
		Assert.assertEquals(UserRepository.getAdminUser().getRole(),
				adminHomePage.getRole());
	}

	// @Test(dataProvider = "urlDataProvider")
	public void checkCustomerLogin(String url) {
		// Steps
		// LoginPage loginpage = new LoginPage(driver);
		// AdminHomePage adminHomePage =
		// loginpage.successAdminLogin(UserRepository.getAdminUser());
		CustomerHomePage customerHomePage = LoginStartPage.load(url)
				.successCustomerLogin(UserRepository.getCustomerUser());
		// Check
		Assert.assertEquals(UserRepository.getCustomerUser().getFirstName(),
				customerHomePage.getFirstName());
		Assert.assertEquals(UserRepository.getCustomerUser().getLastName(),
				customerHomePage.getLastName());
		Assert.assertEquals(UserRepository.getCustomerUser().getRole(),
				customerHomePage.getRole());
	}

	@DataProvider
	public Object[][] searchProvider() {
		return new Object[][] {
				{ BrowserRepository.getFirefoxByTemporaryProfile(),
						Urls.SSU_HOST.toString(),
						UserRepository.getSearchUser() },
				{ BrowserRepository.getChromeByTemporaryProfile(),
						Urls.SSU_HOST.toString(),
						UserRepository.getSearchUser() },
		// { BrowserRepository.getChromeByTemporaryProfile() }
		};
	}

	// @Test(dataProvider = "searchProvider")
	public void checkSearchByLogin(IBrowser browser, String url,
			IUser searchUser) throws InterruptedException {
		// Preconditions
		AdministrationPage administrationPage = LoginStartPage
				.load(browser, url)
				.successAdminLogin(UserRepository.getAdminUser())
				.navigateToAdministrationPage();
		// Steps
		administrationPage.searchByLoginName(
				AdministrationPageFields.LOGIN_NAME,
				AdministrationPageConditions.STARTS_WITH, searchUser);
		// Check
		AssertWrapper.get().forLabelElement(administrationPage.getFirstName())
				.isVisible().isEqualText(searchUser.getFirstName())
				.isExistText(searchUser.getFirstName()).next()
				.forLabelElement(administrationPage.getLastName()).isVisible()
				.isEqualText(searchUser.getLastName())
				.isExistText(searchUser.getLastName());
		// Assert.assertEquals(administrationPage.getFirstName().getText(),
		// searchUser.getFirstName());
		// Assert.assertEquals(administrationPage.getLastName().getText(),
		// searchUser.getLastName());
		// Return to previous state
		Thread.sleep(4000);
		administrationPage.logoutClick();
		AssertWrapper.get().check();
	}
/*serhiy*/
}
