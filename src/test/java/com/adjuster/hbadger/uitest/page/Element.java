/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page;

import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public abstract class Element {

    protected WebDriverController wdController;

    private WebElement elementContainer;

    public Element(WebDriverController wdController, String containerXpath) {
        this.wdController = wdController;
        PageFactory.initElements(new AjaxElementLocatorFactory(wdController.findVisibleElement(By.xpath(containerXpath)), wdController.getDefaultWaitTime()), this);
        elementContainer = wdController.findVisibleElement(By.xpath(containerXpath));
    }

    public WebElement getElementContainer() {
        return elementContainer;
    }

    public boolean isDisplayed() {
        return wdController.elementIsVisible(elementContainer);
    }

    public boolean isNotDisplayed() {
        return wdController.elementIsNotInvisible(elementContainer);
    }

}
