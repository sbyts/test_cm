package com.serhiy.edu.oms.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.serhiy.edu.oms.data.IUser;
import com.serhiy.edu.tools.ContextVisible;

public class LoginPage {
	public static final String INVALID_LOGIN_VALIDATOR = "Incorrect username or password.";
	private WebElement loginName;
	private WebElement password;

	public LoginPage() {
		loginName = ContextVisible.get().getVisibleWebElement(By.name("j_username"));
		password = ContextVisible.get().getVisibleWebElement(By.name("j_password"));
	}

	public String getInvalidLoginValidator() {
		return ContextVisible.get().getVisibleWebElement(By.xpath("//div[@class='LoginContainer']//div[text()='Incorrect username or password.']"))
				.getText().trim().substring(0, 49);
	}

	private void setLoginData(IUser user) {
		this.loginName.click();
		this.loginName.sendKeys(user.getLoginName());
		this.password.click();
		this.password.sendKeys(user.getPassword());
		this.password.submit();
	}

	public AdminHomePage successAdminLogin(IUser user) {
		setLoginData(user);
		// Return a new page object representing the destination.
		return new AdminHomePage();
	}

	public CustomerHomePage successCustomerLogin(IUser user) {
		setLoginData(user);
		// Return a new page object representing the destination.
		return new CustomerHomePage();
	}

	public LoginPage unSuccesfulLogin(IUser user) {
		setLoginData(user);
		return new LoginPage();
		// loginName = driver.findElement(By.name("j_username"));
		// password = driver.findElement(By.name("j_password"));
		// return this;
	}
}
