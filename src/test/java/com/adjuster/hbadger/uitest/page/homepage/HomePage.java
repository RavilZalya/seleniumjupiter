/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.homepage;

import com.adjuster.hbadger.uitest.config.PageConfig;
import com.adjuster.hbadger.uitest.page.Page;
import com.adjuster.hbadger.uitest.page.account.AccountPage;
import com.adjuster.hbadger.uitest.page.accounts.AccountsPage;
import com.adjuster.hbadger.uitest.page.common.FeaturesMenu;
import com.adjuster.hbadger.uitest.page.common.Header;
import com.adjuster.hbadger.uitest.page.connections.ConnectionsPage;
import com.adjuster.hbadger.uitest.page.datamanager.DataManagerPage;
import com.adjuster.hbadger.uitest.page.reports.ReportsPage;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;

public class HomePage extends Page {

    private FeaturesMenu featureMenu;
    private Header header;

    public HomePage(WebDriverController wdController, PageConfig config) {
        super(wdController, config);
        this.featureMenu = new FeaturesMenu(wdController);
        this.header = new Header(wdController);
    }

    public FeaturesMenu getFeatureMenu() {
        return featureMenu;
    }

    public Header getHeader() {
        return header;
    }

    public AccountsPage iGoToAccountsPage() {
        getFeatureMenu().select("Accounts");
        return new AccountsPage(wdController, getPageConfig());
    }

    public AccountPage iGoToAccountPage() {
        getFeatureMenu().select("Account");
        return new AccountPage(wdController, getPageConfig());
    }


    public ConnectionsPage iGoToConnectionsPage() {
        getFeatureMenu().select("Connections");
        return new ConnectionsPage(wdController, getPageConfig());
    }

    public DataManagerPage iGoToDataManagerPage() {
        getFeatureMenu().select("Data Manager");
        return new DataManagerPage(wdController, getPageConfig());
    }

    public ReportsPage iGoToReportsPage() {
        getFeatureMenu().select("Connections");
        return new ReportsPage(wdController, getPageConfig());
    }


    @Override
    public String getPageUrl() {
        return getBaseUrl() + "/reports";
    }

}
