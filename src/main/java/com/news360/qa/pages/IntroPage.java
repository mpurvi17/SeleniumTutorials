package com.news360.qa.pages;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import com.news360.qa.TestBase.TestBase;

public class IntroPage extends TestBase {
	HomePage hp;
	IntroPage ip;

	public IntroPage() throws IOException {

		PageFactory.initElements(driver, this);

	}

	public String validateIntroPage() throws IOException, InterruptedException {
		hp = new HomePage();
		ip = new IntroPage();
		ip = hp.navigateToIntroPage();
		String urlIntro = driver.getCurrentUrl();
		return urlIntro;
	}

}
