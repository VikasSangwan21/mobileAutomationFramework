package com.soar.mobileautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.soar.mobileautomation.configs.Hooks;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public class HomePage extends BasePage {
	@SuppressWarnings("rawtypes")
	public AppiumDriver driver;
	/*
	 *    Constructor initializes screen elements
	 */
	@SuppressWarnings("static-access")
	public HomePage()

	{
		this.driver = new Hooks().getDriver();
		PageFactory.initElements(new AppiumFieldDecorator(this.driver),this);
	}

    By myList = By.xpath("//android.widget.FrameLayout[@content-desc='My lists']");
	By history = By.xpath("//android.widget.FrameLayout[@content-desc='History']");
	By nearby = By.xpath("//android.widget.FrameLayout[@content-desc='Nearby']");
	By browse = By.xpath("//android.widget.FrameLayout[@content-desc='Explore']");
	By overflowOptions = By.id("org.wikipedia.alpha:id/menu_overflow_button");
	By settingsButton = By.id("org.wikipedia.alpha:id/explore_overflow_settings");
	
	

	
	public void clickmyList() {
		clickButton(myList, driver);
	}

	public void clickmyHistory() {
		clickButton(history, driver);
	}

	public void clickmyNearby() {
		clickButton(nearby, driver);
	}

	public void clickBrowse() {
		clickButton(browse, driver);
	}
	

	public void verifyHomePage() {
		isElementDisplayed(myList, driver);
	}

	public void goToSettings(){
		clickButton(overflowOptions, driver);
		clickButton(settingsButton, driver);
        System.out.println("Settings icon clicked!");
	}
	
	
}
