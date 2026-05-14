package com.automation.pages;

import com.automation.driver.DriverManager;
import com.automation.enums.WaitMode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static final Logger logger = LogManager.getLogger(BasePage.class);
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    /*
     * Wait for element based on strategy
     */

    protected void waitForElement(By locator, WaitMode mode) {
        try {
            switch (mode) {
                case CLICKABLE -> wait.until(ExpectedConditions.elementToBeClickable(locator));
                case VISIBLE -> wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                case PRESENT -> wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                case INVISIBLE -> wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
                case SELECTABLE -> wait.until(ExpectedConditions.elementToBeSelected(locator));
            }
        } catch (Exception e) {
            logger.error("Failed To Wait for Element " + locator + " with mode " + mode, e);
            throw e;
        }
    }

    protected void clickElement(By locator) {
        try {
            waitForElement(locator, WaitMode.CLICKABLE);
            driver.findElement(locator).click();
        } catch (Exception e) {
            logger.error("Failed To Click Element " + locator, e);
            throw e;
        }
    }

    protected void javascriptClick(By locator) {
        try {
            waitForElement(locator, WaitMode.PRESENT);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(locator));
        } catch (Exception e) {
            logger.error("Failed To Click Element " + locator, e);
            throw e;
        }
    }

    //=======Text Input Methods========
    public void sendKeys(By locator, String text) {
        try {
            waitForElement(locator, WaitMode.VISIBLE);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        } catch (Exception e) {
            logger.error("failed to send keys to element " + locator, e);
            throw e;
        }
    }

    public String getText(By locator) {
        try {
            waitForElement(locator, WaitMode.VISIBLE);
            return driver.findElement(locator).getText();
        } catch (Exception e) {
            logger.error("Failed to get Text from element " + locator, e);
            throw e;
        }
    }

    public String getAttribute(By locator, String attribute) {
        try {
            waitForElement(locator, WaitMode.VISIBLE);
            return driver.findElement(locator).getAttribute(attribute);
        } catch (Exception e) {
            logger.error("Failed to get Attribute from element " + locator, e);
            throw e;
        }
    }

    //=====================verification methods==========================

    public boolean isElementDisplayed(By locator) {
        try {
            waitForElement(locator, WaitMode.VISIBLE);
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            logger.warn("Element is not displayed " + locator, e);
            return false;

        }
    }

    public boolean isElementPresent(By locator) {
        try {
            waitForElement(locator, WaitMode.PRESENT);
            return true;
        } catch (Exception e) {
            logger.warn("Element is not present " + locator, e);
            return false;
        }
    }

    public boolean isElementEnabled(By locator) {
        try {
            waitForElement(locator, WaitMode.VISIBLE);
            return driver.findElement(locator).isEnabled();
        } catch (Exception e) {
            logger.warn("Element is not enabled " + locator, e);
            return false;
        }
    }

    //==============================NAVIGATION METHODS====================
    public void navigateTo(String url) {
        try {
            driver.navigate().to(url);
            waitForPageToLoad();
        } catch (Exception e) {
            logger.error("Failed to navigate to url " + url, e);
            throw e;
        }
    }

    public String getCurrentUrl() {
        try {
            logger.info("Getting current url ", driver.getCurrentUrl());
            return driver.getCurrentUrl();
        } catch (Exception e) {
            logger.error("Failed to get current url", e);
            throw e;
        }
    }

    public void refreshPage() {
        try {
            driver.navigate().refresh();
            waitForPageToLoad();
        } catch (Exception e) {
            logger.error("Failed to refresh page", e);
            throw e;
        }
    }

    //Wait for page to load completely
    public void waitForPageToLoad() {
        try {
            this.wait.until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));
        } catch (Exception e) {
            logger.warn("Timeout waiting for page to load ", e);
        }
    }

    /*
     * Scroll to element
     */

    public void scrollToElement(By locator) {
        try {
            waitForElement(locator, WaitMode.VISIBLE);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
        } catch (Exception e) {
            logger.error("Failed to scroll to element " + locator, e);
            throw e;
        }
    }

    public void scrollToTop() {
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0);");
        } catch (Exception e) {
            logger.error("Failed to scroll to top", e);
            throw e;
        }
    }

    public void scrollToBottom() {
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
        } catch (Exception e) {
            logger.error("Failed to scroll to bottom", e);
            throw e;
        }
    }

    /**
     * switch methods
     */
    public void switchToFrameByIndex(int index) {
        driver.switchTo().frame(index);
    }

    public void swicthToFrameByNameOrId(String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    public void switchToFrameByWebElement(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void switchToMainContent() {
        driver.switchTo().defaultContent();
    }
}