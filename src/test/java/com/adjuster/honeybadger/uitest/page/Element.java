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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Element extends Base {

    protected final WebElement elementContainer;
    private static final int timeout = 25;

    public Element(WebDriver driver, String containerXpath) {
        super(driver, timeout);
        Preconditions.checkArgument(driver != null, "'Webdriver should not be null");
        driverWait = new WebDriverWait(driver, timeout);
        PageFactory.initElements(new AjaxElementLocatorFactory(findVisibleElement(By.xpath(containerXpath)), timeout), this);
        elementContainer = findVisibleElement(By.xpath(containerXpath));
    }

    public boolean isDisplayed() {
        return elementIsVisible(elementContainer);
    }

    public boolean isNotDisplayed() {
        return elementIsNotInvisible(elementContainer);
    }
}
