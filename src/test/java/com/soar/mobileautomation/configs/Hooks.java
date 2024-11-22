package com.soar.mobileautomation.configs;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	private static AppiumDriver driver;
	private AppiumDriverLocalService appiumService;

	@Before
	public void startAppiumServer() throws MalformedURLException {
        appiumService = new AppiumServiceBuilder().build();
        appiumService.start();
        System.out.println("Appium Server Started: " + appiumService.getUrl());

		
        // Set the desired capabilities using UiAutomator2Options
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setPlatformVersion("15") // Replace with your emulator's Android version
                .setDeviceName("sdk_gphone64_x86_64")   // Replace with your emulator's name
                .setAutomationName("UiAutomator2")
                .setApp("C:/Users/user/Desktop/SOAR/Mobile Automation/MobileAutomation/mobileautomation/src/test/resources/application/WikipediaSample.apk") // Path to the APK file
                .setNoReset(true) // Keeps the app data between sessions
                .setFullReset(false); // Does not uninstall the app between sessions

        // Initialize the Appium driver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        System.out.println(".........................=============="+driver.toString());
        System.out.println("Appium session started. App is launched.");
    }

    @After
    public void stopAppiumServer() {
        
		
        if (driver != null) {
            driver.quit();
            System.out.println("Appium session ended. Driver quit.");
        }

        if (appiumService != null && appiumService.isRunning()) {
            appiumService.stop();
            System.out.println("Appium Server Stopped.");
        }

    }

	
    public static AppiumDriver getDriver() {
        return driver;
    }
}
