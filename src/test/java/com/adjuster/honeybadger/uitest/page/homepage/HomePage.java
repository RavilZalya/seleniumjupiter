/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.page.homepage;

import com.adjuster.honeybadger.uitest.config.PageConfig;
import com.adjuster.honeybadger.uitest.page.Page;
import com.adjuster.honeybadger.uitest.page.account.AccountPage;
import com.adjuster.honeybadger.uitest.page.commonelements.FeaturesMenu;
import com.adjuster.honeybadger.uitest.page.commonelements.Header;
import com.adjuster.honeybadger.uitest.page.connections.ConnectionsPage;
import com.adjuster.honeybadger.uitest.page.dashboard.DashboardPage;
import com.adjuster.honeybadger.uitest.page.datamanager.DataManagerPage;
import com.adjuster.honeybadger.uitest.page.reports.ReportsPage;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

    private FeaturesMenu featureMenu;
    private Header header;

    public HomePage(WebDriver webDriver, PageConfig config) {
        super(webDriver, config);
        this.featureMenu = new FeaturesMenu(driver);
        this.header = new Header(driver);
    }

    public FeaturesMenu getFeatureMenu() {
        return featureMenu;
    }

    public Header getHeader() {
        return header;
    }

    public ReportsPage iGoToReportsPage() {
        getFeatureMenu().select("Reports");
        return new ReportsPage(driver, getPageConfig());
    }

    public AccountPage iGoToAccountPage() {
        getFeatureMenu().select("Account");
        return new AccountPage(driver, getPageConfig());
    }

    public DashboardPage iGoToDashboardsPage() {
        getFeatureMenu().select("Dashboards");
        return new DashboardPage(driver, getPageConfig());
    }

    public DataManagerPage iGoToDataManagerPage() {
        getFeatureMenu().select("Data Manager");
        return new DataManagerPage(driver, getPageConfig());
    }

    public ConnectionsPage iGoToConnectionsPage() {
        getFeatureMenu().select("Connections");
        return new ConnectionsPage(driver, getPageConfig());
    }

    @Override
    public String getPageUrl() {
        return getBaseUrl() + "/reports";
    }

}
