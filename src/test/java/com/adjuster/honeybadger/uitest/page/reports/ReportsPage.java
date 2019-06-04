/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.page.reports;

import com.adjuster.honeybadger.uitest.config.PageConfig;
import com.adjuster.honeybadger.uitest.page.Page;
import org.openqa.selenium.WebDriver;

public class ReportsPage extends Page {

    public ReportsPage(WebDriver driver, PageConfig pageConfig) {
        super(driver, pageConfig);
    }

    @Override
    public String getPageUrl() {
        return getBaseUrl() + "/reports";
    }
}
