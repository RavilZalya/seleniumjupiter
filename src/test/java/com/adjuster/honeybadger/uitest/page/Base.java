/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.page;

import com.google.common.base.Preconditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfNestedElementsLocatedBy;

public abstract class Base {

    protected WebDriver driver;
    protected WebDriverWait driverWait;

    public Base(WebDriver driver, int timeout) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, timeout);
    }

    protected WebElement findClickableElement(By locator) {
        return driverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement findClickableElement(WebElement element) {
        return driverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement findVisibleElement(By locator) {
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected List<WebElement> findVisibleElements(By locator) {
        return driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected List<WebElement> findNestedElements(WebElement parent, By child) {
        return driverWait.until(visibilityOfNestedElementsLocatedBy(parent, child));
    }

    protected List<WebElement> findNestedElements(By parent, By child) {
        return driverWait.until(visibilityOfNestedElementsLocatedBy(parent, child));
    }

    protected int getIndex(List<WebElement> listElements, String string) {
        Preconditions.checkArgument(exists(listElements, string), "check argument string");
        return elementToStringList(listElements).indexOf(string);
    }

    protected int getIndex(List<WebElement> listElements, String attribute, String string) {
        Preconditions.checkArgument(exists(listElements, attribute, string), "check argument string");
        return elementToStringList(listElements, attribute).indexOf(string);
    }

    protected boolean exists(List<WebElement> listElements, String string) {
        return elementToStringList(listElements).stream().anyMatch(str -> str.trim().equals(string));
    }

    protected boolean exists(List<WebElement> listElements, String attribute, String string) {
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

}
