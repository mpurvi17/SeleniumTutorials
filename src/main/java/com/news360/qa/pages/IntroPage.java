package com.news360.qa.pages;

import java.io.IOException;
import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.news360.qa.TestBase.TestBase;

public class IntroPage extends TestBase {
	HomePage hp;
	IntroPage ip;

	@FindBy(xpath = "//p[@class='recommendation-header-top-description-title']")
	WebElement headerTop;
	
	@FindBy(xpath = "//p[@class='recommendation-header-top-description-subtitle']")
	WebElement subTitle;
	
	@FindBy(xpath = "//div[@class='recommendation-header-social-container']/div")
	WebElement socialBtn[];
	
	
	
	
	
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

	public String headerTopDesc()
	{
		String headerCheck=headerTop.getText();
		return headerCheck;
	}
	
	public String subHeader()
	{
		String subHeader=subTitle.getText();
		return subHeader;
	}
	
	
	public int checkLinks()
	{
		//String x = socialBtn.getSize();
		int x = driver.findElements(By.xpath("//div[@class='recommendation-header-social-container']/div")).size();
		List<WebElement> y = driver.findElements(By.xpath("//div[@class='recommendation-header-social-container']/div"));
		
		for(WebElement element:y)
		{
System.out.println(element.findElement(By.xpath("//div[@class='recommendation-"
		+ "header-social-container']")).getAttribute("innerHTML"));			
		}		
		return x;
		
	
	}
	
	
	
	
	
}
