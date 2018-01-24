package com.news360.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.news360.qa.TestBase.TestBase;
import com.news360.qa.pages.HomePage;
import com.news360.qa.pages.LandingPage;

public class HomePageTest extends TestBase {
	HomePage hp;
	LandingPage lp;

	public HomePageTest() throws IOException {
		super();		
		System.out.println("From HomePageTest()");
	}

	@BeforeMethod
	public void setUp() throws IOException {
		System.out.println("LandingPageTest: setUp Method calling from LPT");
		initialization();
		lp = new LandingPage();
		System.out.println("Call Navigate to HomePage from HPT");
		hp = lp.navigateToHomePage();
	}

	@Test(priority = 1)
	public void HomePageURLTest() throws IOException {
		String t = hp.HomePageURL();
		Assert.assertEquals(t, "https://news360.com/home");
	}

	@Test(priority = 2)
	public void verifyTitleinBoxTest() {
		String t = hp.verifyTitleinBox();
		Assert.assertEquals(t, "Welcome to News360!");
	}

	@AfterMethod
	public void closeBrowserTest() {
		System.out.println("LandingPageTest: CloseBrowser Test");
		closeBrowser();
	}

}
