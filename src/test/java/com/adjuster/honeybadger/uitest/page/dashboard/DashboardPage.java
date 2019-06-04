/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.page.dashboard;

import com.adjuster.honeybadger.uitest.config.PageConfig;
import com.adjuster.honeybadger.uitest.page.Page;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends Page {

    public DashboardPage(WebDriver driver, PageConfig pageConfig) {
        super(driver, pageConfig);
    }

    @Override
    public String getPageUrl() {
        return getBaseUrl() + "/dashboard/[0-9]+"; //in tests use urlMatches for regex, not urlTobe
    }
}
