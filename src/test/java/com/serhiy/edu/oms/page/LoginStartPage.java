package com.serhiy.edu.oms.page;

import com.serhiy.edu.tools.IBrowser;
import com.serhiy.edu.tools.WebDriverUtils;

public class LoginStartPage extends LoginPage {

	private LoginStartPage() {
		super();
	}

	public static LoginStartPage load(String url) {
		WebDriverUtils.get().load(url);
		return new LoginStartPage();
	}

	public static LoginStartPage load(IBrowser browser, String url) {
		WebDriverUtils.get(browser).load(url);
		return new LoginStartPage();
	}

}
