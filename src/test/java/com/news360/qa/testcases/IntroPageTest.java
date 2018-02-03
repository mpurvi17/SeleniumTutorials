package com.news360.qa.testcases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.news360.qa.TestBase.TestBase;
import com.news360.qa.pages.HomePage;
import com.news360.qa.pages.IntroPage;
import com.news360.qa.pages.LandingPage;


public class IntroPageTest extends TestBase {
	IntroPage ip;
	HomePage hp;
	LandingPage lp;

	public IntroPageTest() throws IOException {
		super();
		System.out.println("super from From IntroPageTest()");
	}

	@BeforeMethod
	public void setUp() throws IOException {
		System.out.println("IntroPageTest: setUp Method calling from IntroPage Test");
		initialization();
		lp = new LandingPage();
		hp = new HomePage();
		System.out.println("from IntrpPageTest");
		hp = lp.navigateToHomePage();
		ip = new IntroPage();
	}

	@Test(priority=1)
	public void validateIntroPageTest() throws IOException, InterruptedException {
		String t = ip.validateIntroPage();
		Assert.assertEquals(t, "https://news360.com/intro");
	}

	
	@Test(priority=2)
	public void validateHeaderTopDesc() throws IOException, InterruptedException
	{	
		ip = hp.navigateToIntroPage();
		String t=ip.headerTopDesc();
		Assert.assertEquals(t, "First, choose how you want to log in to your News360 account");
	}
	
	@Test(priority=3)
	public void validatesubHeader() throws IOException, InterruptedException
	{
		ip = hp.navigateToIntroPage();
		String t=ip.subHeader();
		Assert.assertEquals(t, "(Don't worry, we will never post anything)");
	}
	
	
	@Test(priority=4)
	public void validateCheckLinks() throws IOException, InterruptedException
	{
		ip = hp.navigateToIntroPage();
		int x = ip.checkLinks();
		Assert.assertEquals(x, 3);
	}
	
	
	
	
	@AfterMethod
	public void closeBrowserTest() {
		System.out.println("LandingPageTest: CloseBrowser Test");
		closeBrowser();
	}

}
