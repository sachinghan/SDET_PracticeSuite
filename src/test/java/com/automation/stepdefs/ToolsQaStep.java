package com.automation.stepdefs;

import com.automation.pages.ToolsQAPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class ToolsQaStep {
    ToolsQAPage toolsQAPage;

    @Given("Open the ToolsQA website")
    public void openTheToolsQaWebsite(){
        toolsQAPage = new ToolsQAPage(); // Initialize here, after driver is ready
        toolsQAPage.openUrl();
    }

    @Then("validate the options available to explore should be equal to {int}")
    public void validateTheOptionsAvailableToExploreShouldBeEqualTo(int optionCount) {
       int actualCount = toolsQAPage.getCategoryCount();
       Assert.assertEquals(actualCount, optionCount, "The number of practice modules does not match!");
    }

    @Then("navigate to form section of the homepage")
    public void navigateToFormSectionOfTheHomepage() {
        toolsQAPage.clickFormsCategory();
    }
}
