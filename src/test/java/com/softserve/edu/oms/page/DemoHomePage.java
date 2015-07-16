package com.softserve.edu.oms.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.tools.WebDriverUtils;

public class DemoHomePage extends HomePage {
	private WebElement administration;

	public DemoHomePage() {
		super();
		administration = WebDriverUtils.get().getWebDriver().findElement(By.xpath("//div[@id='profile_editor_switcher']//div[text()='demo']"));
	}

	//public AdministrationPage navigateToAdministrationPage() {
	public void navigateToAdministrationPage() {
		administration.click();
		//return new AdministrationPage();
	}
	
}