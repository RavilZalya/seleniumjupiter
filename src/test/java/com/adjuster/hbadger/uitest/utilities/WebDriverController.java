/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.utilities;

import com.google.common.base.Preconditions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfNestedElementsLocatedBy;

public class WebDriverController {


    private WebDriver driver;
    private WebDriverWait driverWait;
    private JavascriptExecutor javascriptexec;
    private int defaultWaitTime = 15;
    private Actions action;


    // (un)border element
    private WebElement lastElem = null;
    private String lastBorder = null;
    private static final String addRedBorder = "arguments[0].style.border='3px solid red'";
    private static final String removeBorder = "arguments[0].style.border='0px'";


    public WebDriverController(WebDriver driver) {
        driverWait = new WebDriverWait(driver, defaultWaitTime);
        javascriptexec = (JavascriptExecutor) driver;
        action = new Actions(driver);
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public WebDriverWait getDriverWait() {
        return this.driverWait;
    }

    public JavascriptExecutor getJsExecutor() {
        return this.javascriptexec;
    }

    public Actions getAction() {return this.action;}

    public int getDefaultWaitTime() {
        return defaultWaitTime;
    }

    public void quitDriver() {
        this.driver.quit();
    }

    public void closeDriver() {
        this.driver.close();
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public void pageRefresh() {
        this.driver.navigate().refresh();
    }

    public void wait(List<WebElement> elements, int duration) {

        new WebDriverWait(this.driver, duration).until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void wait(List<WebElement> elements) {
        wait(elements, defaultWaitTime);
    }

    public void wait(WebElement element, int duration) {

        new WebDriverWait(this.driver, duration).until(ExpectedConditions.visibilityOf(element));
    }

    public void wait(WebElement element) {

        wait(element, defaultWaitTime);
    }

    public void sleep(int duration) {

        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean selectFromList(List<WebElement> list, String text) {

        boolean textFound = false;
        for (WebElement element : list) {

            if (element.getText().contains(text)) {
                element.click();
                textFound = true;
                break;
            }
        }
        return textFound;
    }

    public boolean isTextVisibleInList(List<WebElement> list, String expectedText) {

        boolean textFound = false;
        for (WebElement item : list) {

            if (item.getText().trim().equals(expectedText)) {
                textFound = true;
                break;
            }
        }
        return textFound;
    }

    public void doubleClickFromList(List<WebElement> webElements, List<?> texts) {

        for (int i = 0; i < texts.size(); i++) {

            for (WebElement webElement : webElements) {

                if (webElement.getText().equals(texts.get(i).toString())) {

                    doubleClick(webElement);
                    break;
                }
            }
        }
    }

    public boolean waitText(WebElement element, String expectedText, int duration) {

        try {
            new WebDriverWait(this.driver, duration)
                    .until(ExpectedConditions.textToBePresentInElement(element, expectedText));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean waitText(WebElement element, String expectedText) {

        return waitText(element, expectedText, defaultWaitTime);
    }

    public void doubleClick(WebElement element) {
        action.doubleClick(element).perform();
    }

    // NEW METHODS
    public boolean waitElementToBeVisible(WebElement element, int duration) {

        try {
            new WebDriverWait(this.driver, duration).until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean waitElementToBeVisible(WebElement element) {
        return waitElementToBeVisible(element, defaultWaitTime);
    }

    public boolean waitElementsVisibility(List<WebElement> elements) {

        try {
            new WebDriverWait(this.driver, defaultWaitTime).until(ExpectedConditions.visibilityOfAllElements(elements));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int waitElementsVisibleReturnSize(List<WebElement> elements) {

        return waitElementsVisibility(elements) ? elements.size() : 0;
    }

    public WebElement findElementFromListByAttribute(List<WebElement> list, String attribute, String expectedValue) {

        for (WebElement element : list) {
            if (attributeEqualsToValue(element, attribute, expectedValue))
                return element;
        }
        return null;
    }

    public boolean attributeEqualsToValue(WebElement element, String attribute, String expectedValue) {

        return element.getAttribute(attribute).equalsIgnoreCase(expectedValue);
    }

    public boolean waitElementToBeClickable(WebElement element, int duration) {

        try {
            new WebDriverWait(this.driver, duration).until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean waitElementToBeClickable(WebElement element) {

        return waitElementToBeClickable(element, defaultWaitTime);
    }

    public boolean waitElementToBeInvisible(WebElement element, int duration) {

        try {
            new WebDriverWait(this.driver, defaultWaitTime).until(ExpectedConditions.visibilityOf(element));
            return false;
        } catch (NoSuchElementException e) {
            return true;
        } catch (TimeoutException e) {
            return true;
        }
    }

    public boolean waitElementToBeInvisible(WebElement element) {

        return waitElementToBeInvisible(element, defaultWaitTime);
    }

    public boolean waitListSize(List<WebElement> list, int size) {

        int numberOfTries = 5;
        do {
            sleep(1000);
            new WebDriverWait(this.driver, defaultWaitTime).until(ExpectedConditions.visibilityOfAllElements(list));
            numberOfTries--;
        } while (size != list.size() && numberOfTries > 0);

        return size == list.size();
    }

    public String waitAndGetAttribute(WebElement element, String attribute) {

        return waitElementToBeVisible(element) ? element.getAttribute(attribute) : null;
    }

    // highlight web element
    public void highlightElement(WebElement element) {

        unhighlightLast();
        lastElem = element;
        lastBorder = (String) javascriptexec.executeScript(addRedBorder, element);
    }

    // unhighlight highlighted element
    void unhighlightLast() {
        if (lastElem != null) {
            try {
                javascriptexec.executeScript(removeBorder, lastElem, lastBorder);
            } catch (StaleElementReferenceException ignored) {
            } finally {
                lastElem = null;
            }
        }
    }


    // BELOW PART IS PLANTED FROM NEEDED FOR RAVIL'S TESTS TO RUN. WILL NEED TO COMBINE METHODS AND REORGANIZE WD CONTROLLER CLASS
    protected WebElement findClickableElement(By locator) {
        return driverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement findClickableElement(WebElement element) {
        return driverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement findVisibleElement(By locator) {
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> findVisibleElements(By locator) {
        return driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public List<WebElement> findVisibleElements(WebElement element) {
        return driverWait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public List<WebElement> findNestedElements(WebElement parent, By child) {
        return driverWait.until(visibilityOfNestedElementsLocatedBy(parent, child));
    }

    public List<WebElement> findNestedElements(By parent, By child) {
        return driverWait.until(visibilityOfNestedElementsLocatedBy(parent, child));
    }

    public int getIndex(List<WebElement> listElements, String string) {
        Preconditions.checkArgument(exists(listElements, string), "check argument string");
        return elementToStringList(listElements).indexOf(string);
    }

    public int getIndex(List<WebElement> listElements, String attribute, String string) {
        Preconditions.checkArgument(exists(listElements, attribute, string), "check argument string");
        return elementToStringList(listElements, attribute).indexOf(string);
    }

    public boolean exists(List<WebElement> listElements, String string) {
        return elementToStringList(listElements).stream().anyMatch(str -> str.trim().equals(string));
    }

    public boolean exists(List<WebElement> listElements, String attribute, String string) {
        Preconditions.checkArgument(!elementToStringList(listElements, attribute).isEmpty(), "attribute does not exist");
        return elementToStringList(listElements, attribute).stream().anyMatch(str -> str.trim().equals(string));
    }

    public List<String> elementToStringList(List<WebElement> listElements) {
        return listElements.stream().map(w -> w.getText())
                .collect(Collectors.toList());
    }

    private List<String> elementToStringList(List<WebElement> listElements, String attribute) {
        return listElements.stream().map(w -> w.getAttribute(attribute))
                .collect(Collectors.toList());
    }

    public boolean elementIsVisible(WebElement element) {
        return driverWait
                .until(ExpectedConditions.visibilityOf(element))
                .isDisplayed();
    }

    public boolean elementIsNotInvisible(WebElement element) {
        return driverWait
                .until(ExpectedConditions.invisibilityOf(element));
    }
////////////////////
}
