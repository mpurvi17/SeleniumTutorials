package com.news360.qa.pages;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.news360.qa.TestBase.TestBase;


public class HomePage extends TestBase {
	HomePage hp;

	@FindBy(xpath = "//p[@class='ap-intro-title'][text()='Welcome to News360!']")
	WebElement titleCheck;

	@FindBy(xpath="//button[@class='ap-button ap-intro-personalize-button']")
	WebElement personalizeBtn;
	
	public HomePage() throws IOException {
		System.out.println("In HomePage Constructor");
		HomePageURL();
		PageFactory.initElements(driver, this);
	}

	public String HomePageURL() {
		return driver.getCurrentUrl();
	}

	public String verifyTitleinBox() {
		return titleCheck.getText();
	}

	public IntroPage navigateToIntroPage() throws IOException, InterruptedException
	{		
		personalizeBtn.click();
		Thread.sleep(5000);
		return new IntroPage();
		
	}
}
