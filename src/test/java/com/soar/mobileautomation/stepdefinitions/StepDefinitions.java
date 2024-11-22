package com.soar.mobileautomation.stepdefinitions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.appium.java_client.AppiumBy;


import org.openqa.selenium.By;

import com.soar.mobileautomation.configs.Hooks;
import com.soar.mobileautomation.pages.HomePage;

public class StepDefinitions {

    private AppiumDriver driver;
    private HomePage homePage;

    public StepDefinitions() {
        // Assume the driver is initialized in a Hooks or base class
        this.driver = Hooks.getDriver();
    }

    @Given("the app is launched")
    public void the_app_is_launched() {
        System.out.println("The app is launched.");
    }

    @When("I scroll down to the end of the page")
    public void i_scroll_down_to_the_end_of_the_page() {
        driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector()).scrollToEnd(10)"
        ));
        System.out.println("Scrolled to the end of the page.");
    }

    @Then("I click on the {string} icon")
    public void i_click_on_the_icon(String iconName) {
        homePage = new HomePage();
        switch (iconName.toLowerCase()) {
            case "my lists":
                homePage.clickmyList();
                break;
            case "history":
                homePage.clickmyHistory();
                break;
            case "nearby":
                homePage.clickmyNearby();
                break;
            case "browse":
                homePage.clickBrowse();
                break;
            default:
                throw new IllegalArgumentException("Invalid icon name: " + iconName);
        }
        System.out.println("Clicked on the " + iconName + " icon.");
    }

    @Then("I return to the home page by clicking the {string} icon")
    public void returnToHomePage(String iconName) {
        homePage.clickBrowse();
        System.out.println("Clicked on the " + iconName + " icon to return to the home page.");
    }

    @And("I wait for {int} seconds")
    public void i_wait_for_seconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000L);
        System.out.println("Waited for " + seconds + " seconds.");
    }

    @And("I scroll up to the first topic of the app")
    public void i_scroll_up_to_the_first_topic_of_the_app() {
        driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector()).scrollToBeginning(10)"
        ));
        System.out.println("Scrolled to the first topic of the app.");
    }
}
