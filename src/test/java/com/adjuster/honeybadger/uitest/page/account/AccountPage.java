/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.page.account;

import com.adjuster.honeybadger.uitest.config.PageConfig;
import com.adjuster.honeybadger.uitest.page.Page;
import org.openqa.selenium.WebDriver;

/**
 * Represents Account page. Consists of three tabs: Uses, Statistics, Settings.
 * Instantiates Tab Selector as a page element allowing to navigate between tabs.
 */
public class AccountPage extends Page {

    public AccountPage(WebDriver driver, PageConfig pageConfig) {
        super(driver, pageConfig);
    }

    @Override
    public String getPageUrl() {
        return getBaseUrl() + "/accounts/[0-9]+"; //in tests use urlMatches for regex, not urlTobe
    }


}