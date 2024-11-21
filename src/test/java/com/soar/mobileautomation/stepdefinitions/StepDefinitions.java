package com.soar.mobileautomation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;

public class StepDefinitions {

    private int number1;
    private int number2;
    private int result;


    @Given("I have two numbers {int} and {int}")
    public void i_have_two_numbers_and(int num1, int num2) {
        this.number1 = num1;
        this.number2 = num2;
    }

    @When("I add them")
    public void i_add_them() {
        this.result = number1 + number2;
    }

    @Then("the result should be {int}")
    public void the_result_should_be(int expected) {
        assertEquals(result, expected, "Result does not match!");
    }
}
