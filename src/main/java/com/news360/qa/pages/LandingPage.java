package com.news360.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.news360.qa.TestBase.TestBase;
import com.news360.qa.util.UtilClass;

public class LandingPage extends TestBase {

	String x;
	@FindBy(tagName = "h1")
	WebElement h1;

	@FindBy(xpath = "//img[@class='news_image news_image_01 loaded']")
	WebElement imgCheck;
	
	@FindBy(xpath = "//a[contains(text(), 'Read News360 in your browser')]")
	WebElement buttonCheck;

	public LandingPage() throws IOException {
		System.out.println("Landing Page Constructor");
		
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHeader() {
		System.out.println("LandingPage: verifyHeader method");
		x = h1.getText();

		if (x.substring(0, 44).equals("News360 is an app that learns what you enjoy")
				&& x.substring(45, 89).equals("and finds stories you’ll like around the web")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyImage() {
		System.out.println("LandingPage: verifyImage method");

		if (imgCheck.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public HomePage navigateToHomePage() throws IOException {
		System.out.println("LandingPage: navigateToHomePage method");
		buttonCheck.click();
		driver.manage().timeouts().pageLoadTimeout(UtilClass.pageLoad, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(UtilClass.waitTime, TimeUnit.SECONDS);
		return new HomePage();
				
	}

}
