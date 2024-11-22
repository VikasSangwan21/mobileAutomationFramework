package com.soar.mobileautomation.configs;

import java.net.MalformedURLException;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import mobileautomation.utils.AppiumUtils;

public class Hooks {

	private static AppiumDriver driver;
	//private AppiumDriverLocalService appiumService;

	@Before
	public void setup() throws MalformedURLException {
        AppiumUtils.startAppiumServer();
        driver = AppiumUtils.setupDriver();
        System.out.println(".........................=============="+driver.toString());
        System.out.println("Appium session started. App is launched.");
    }

    @After
    public void tearDown() {
        
		
        if (driver != null) {
            driver.quit();
            System.out.println("Appium session ended. Driver quit.");
        }

        AppiumUtils.stopAppiumServer();
    }

	
    public static AppiumDriver getDriver() {
        return driver;
    }
}
