/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.page.accounts;

import com.adjuster.honeybadger.uitest.config.PageConfig;
import com.adjuster.honeybadger.uitest.page.Page;
import com.adjuster.honeybadger.uitest.page.commonelements.Paginator;
import com.adjuster.honeybadger.uitest.page.commonelements.Searchbar;
import com.adjuster.honeybadger.uitest.page.commonelements.Table;
import org.openqa.selenium.WebDriver;

/**
 * Represents Admin accounts page.
 */
public class AccountsPage extends Page {

    private Searchbar searchbar;
    private Paginator paginator;
    private Table table;

    public AccountsPage(WebDriver driver, PageConfig pageConfig) {
        super(driver, pageConfig);
        this.table = new Table(driver);
        this.searchbar = new Searchbar(driver);
        this.paginator = new Paginator(driver);
    }

    public Searchbar getSearchbar() {
        return searchbar;
    }

    public Paginator getPaginator() {
        return paginator;
    }

    public Table getTable() {
        return table;
    }

    @Override
    public String getPageUrl() {
        return getBaseUrl() + "/accounts";
    }

}