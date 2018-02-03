package com.news360.qa.util;

import com.news360.qa.TestBase.TestBase;

public class UtilClass {

	public static long pageLoad = 20;
	public static long waitTime = 20;
	public static String handle = null;

	public static void getHandle() {
		handle = TestBase.driver.getWindowHandle();
		System.out.println(handle);

		for (String winHandle : TestBase.driver.getWindowHandles()) {
			TestBase.driver.switchTo().window(winHandle);// switch focus of
															// WebDriver to the
															// next found window
															// handle (that's
															// your newly opened
															// window)
			if (!(winHandle.equals(handle))) {
				handle = winHandle;
			}
		}

	}

}
