package com.soar.mobileautomation.stepdefinitions;

import com.soar.mobileautomation.configs.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StepDefinitions {
    private final Hooks hooks;

    public StepDefinitions(Hooks hooks) {
        this.hooks = hooks;
    }

    @Given("the Android emulator is started")
    public void the_android_emulator_is_started() {
        System.out.println("Android emulator is running...");
        // Optionally verify the emulator status using ADB commands
    }

    @When("the app is launched from the APK file")
    public void the_app_is_launched_from_the_apk_file() {
        System.out.println("App launched from APK file.");
        // The app launch is handled by the Appium server in the @Before hook of Hooks.java
    }

    @Then("the app should open successfully")
    public void the_app_should_open_successfully() {
        WebElement element = hooks.getDriver().findElement(By.id("com.example:id/some_element_id"));
        if (element.isDisplayed()) {
            System.out.println("App opened successfully!");
        } else {
            throw new AssertionError("Failed to open the app.");
        }
    }

    @Then("I verify the app title is {string}")
    public void i_verify_the_app_title_is(String expectedTitle) {
        // Assuming the app title is part of a TextView element
        WebElement titleElement = hooks.getDriver().findElement(By.id("com.example:id/title"));
        String actualTitle = titleElement.getText();
        if (!actualTitle.equals(expectedTitle)) {
            throw new AssertionError("Expected title: " + expectedTitle + ", but found: " + actualTitle);
        }
        System.out.println("App title verified successfully!");
    }
}