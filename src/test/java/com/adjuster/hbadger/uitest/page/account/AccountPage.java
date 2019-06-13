/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.account;

import com.adjuster.hbadger.uitest.config.PageConfig;
import com.adjuster.hbadger.uitest.page.Page;
import com.adjuster.hbadger.uitest.page.account.component.NewUserDetails;
import com.adjuster.hbadger.uitest.page.common.Paginator;
import com.adjuster.hbadger.uitest.page.common.Searchbar;
import com.adjuster.hbadger.uitest.page.common.Table;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;


/**
 * Represents Account page. Consists of three tabs: Uses, Statistics, Settings.
 * Instantiates Tab Selector as a page element allowing to navigate between tabs.
 */
public class AccountPage extends Page {

    private Searchbar searchbar;
    private Paginator paginator;
    private Table table;

    public AccountPage(WebDriverController wdController, PageConfig pageConfig) {
        super(wdController, pageConfig);
    }


    public NewUserDetails clickAddNewUserBtn() {
        (new Searchbar(wdController)).addNew();
        return new NewUserDetails(wdController);
    }

    public Searchbar getSearchbar() {
        return new Searchbar(wdController);
    }

    public Paginator getPaginator() {
        return new Paginator (wdController);
    }

    public Table getTable() {
        return new Table(wdController);
    }

    @Override
    public String getPageUrl() {
        return getBaseUrl() + "/accounts/[0-9]+"; //in tests use urlMatches for regex, not urlTobe
    }


}