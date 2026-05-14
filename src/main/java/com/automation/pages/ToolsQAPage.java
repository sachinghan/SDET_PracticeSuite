package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ToolsQAPage extends BasePage {
    //Locators
    private final By formsCard = By.xpath("//div[@class='card-body']//h5[text()='Forms']");
    private final By countOfModulesToPractice = By.xpath("//div[@class='category-cards']//div[@class='card-body']");

    public void openUrl() {
        driver.get("https://demoqa.com/");
    }

    public int getCategoryCount() {
        waitForElement(countOfModulesToPractice, com.automation.enums.WaitMode.VISIBLE);
        return driver.findElements(countOfModulesToPractice).size();
    }

    public void clickFormsCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(formsCard));
        javascriptClick(formsCard);
    }

}
