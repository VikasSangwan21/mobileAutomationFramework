package com.soar.mobileautomation.configs;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {

    private AppiumDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        // Set the desired capabilities using UiAutomator2Options
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setPlatformVersion("13.0") // Replace with your emulator's Android version
                .setDeviceName("Pixel_6")   // Replace with your emulator's name
                .setAutomationName("UiAutomator2")
                .setApp("/path/to/your/app.apk") // Path to the APK file
                .setNoReset(true) // Keeps the app data between sessions
                .setFullReset(false); // Does not uninstall the app between sessions

        // Initialize the Appium driver
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/"), options);
        System.out.println("Appium session started. App is launched.");
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Appium session ended. Driver quit.");
        }
    }

    public AppiumDriver getDriver() {
        return driver;
    }
}
