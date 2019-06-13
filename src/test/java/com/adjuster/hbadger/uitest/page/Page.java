/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page;

import com.adjuster.hbadger.uitest.config.PageConfig;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.BDDAssertions.then;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

public abstract class Page {

    private static final Logger LOG = LoggerFactory.getLogger(Page.class);

    protected WebDriverController wdController;
    private PageConfig pageConfig;
    private static final int timeout = 25;

    public Page(WebDriverController wdController, PageConfig pageConfig) {
        this.wdController = wdController;
        this.pageConfig = pageConfig;
        PageFactory.initElements(new AjaxElementLocatorFactory(wdController.getDriver(), timeout), this);
        then(wdController.getDriverWait().until(ExpectedConditions.urlMatches(getPageUrl()))).as("Is on URL: " + getClass().getName()).isTrue();
    }


    protected String getBaseUrl() {
        return getPageConfig().getBaseUrl();
    }

    public abstract String getPageUrl();

    public PageConfig getPageConfig() {
        return pageConfig;
    }


}
