/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.page;

import com.adjuster.honeybadger.uitest.config.PageConfig;
import com.google.common.base.Preconditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.BDDAssertions.then;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

public abstract class Page extends Base {

    private static final Logger LOG = LoggerFactory.getLogger(Page.class);

    private PageConfig pageConfig;
    private static final int timeout = 25;

    public Page(WebDriver driver, PageConfig pageConfig) {
        super(driver, pageConfig.getWaitTimeOut());
        this.pageConfig = pageConfig;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeout), this);
        then(driverWait.until(urlToBe(getPageUrl()))).as("Is on URL: " + getClass().getName()).isTrue();
    }

    public void refreshPage() {
        Preconditions.checkArgument(driver != null, "'Webdriver should not be null");
        driver.navigate().refresh();
    }

    protected String getBaseUrl() {
        return getPageConfig().getBaseUrl();
    }

    public abstract String getPageUrl();

    public PageConfig getPageConfig() {
        return pageConfig;
    }

    public boolean isDisplayed() {
        return driverWait.until(urlToBe(getPageUrl()));
    }

}
