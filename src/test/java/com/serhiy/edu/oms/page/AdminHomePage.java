package com.serhiy.edu.oms.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.serhiy.edu.tools.ContextVisible;

public class AdminHomePage extends HomePage {
	private WebElement administration;

	public AdminHomePage() {
		super();
		administration = ContextVisible.get().getVisibleWebElement(By.partialLinkText("Administration"));
	}

	public AdministrationPage navigateToAdministrationPage() {
		administration.click();
		return new AdministrationPage();
	}
	
}
