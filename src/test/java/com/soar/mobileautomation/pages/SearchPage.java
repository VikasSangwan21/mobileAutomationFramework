package com.soar.mobileautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.soar.mobileautomation.configs.Hooks;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public class SearchPage extends BasePage {
	@SuppressWarnings("rawtypes")
	public AppiumDriver driver;
	/*
	 *    Constructor initializes screen elements
	 */
	@SuppressWarnings("static-access")
	public SearchPage()

	{
		this.driver = new Hooks().getDriver();
		PageFactory.initElements(new AppiumFieldDecorator(this.driver),this);
	}




    By searchBar = By.id("org.wikipedia.alpha:id/fragment_feed_header");
	By searchBarocused = By.xpath("//android.widget.AutoCompleteTextView[@resource-id='org.wikipedia.alpha:id/search_src_text']");
	By searchResults = By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='org.wikipedia.alpha:id/fragment_feed_feed']/android.widget.FrameLayout");
	By clearQuery = By.xpath("//android.widget.ImageView[@content-desc='Clear query']");
	
	public void enterSearchQuery(String query) {
        clickButton(searchBar, driver);
		inputText(query, searchBarocused, driver);
    }

	public void verifySearchResults() {
        areMultipleSearchResultsDisplayed(searchResults, driver);
    }

	public void clickClearQuery() {
        clickButton(clearQuery, driver);
    }
	
	
}
