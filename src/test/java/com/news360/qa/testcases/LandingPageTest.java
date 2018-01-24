package com.news360.qa.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.news360.qa.TestBase.TestBase;
import com.news360.qa.pages.HomePage;
import com.news360.qa.pages.LandingPage;

public class LandingPageTest extends TestBase {
	LandingPage lp;
	HomePage hp;

	public LandingPageTest() throws IOException {
		super();
		System.out.println("LandingPageTest Constructor");
	}

	@BeforeMethod
	public void setUp() throws IOException {
		System.out.println("LandingPageTest: setUp Method calling from LPT");
		initialization();
		lp = new LandingPage();
	}

	@Test(priority = 1)
	public void verifyHeaderTest() throws IOException {
		System.out.println("LandingPageTest: Verify Header Test");
		Assert.assertEquals(lp.verifyHeader(), true);
	}

	@Test(priority = 2)
	public void verifyImageTest() {

		System.out.println("LandingPageTest: Verify Image Test");
		Assert.assertEquals(lp.verifyImage(), true);
	}

	@Test(priority = 3)
	public void navigateToHomePageTest() throws IOException {

		System.out.println("LandingPageTest: navigateToHomePageTest()");
		hp = lp.navigateToHomePage();
		System.out.println(hp);
	}

	@AfterMethod
	public void closeBrowserTest() {
		System.out.println("LandingPageTest: CloseBrowser Test");
		closeBrowser();
	}

}
