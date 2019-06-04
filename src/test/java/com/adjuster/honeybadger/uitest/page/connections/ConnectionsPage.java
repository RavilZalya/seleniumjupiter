
/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.page.connections;

import com.adjuster.honeybadger.uitest.config.PageConfig;
import com.adjuster.honeybadger.uitest.page.Page;
import com.adjuster.honeybadger.uitest.page.commonelements.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionsPage extends Page {

    private static final Logger LOG = LoggerFactory.getLogger(ConnectionsPage.class);

    private Header header;
    private Paginator paginator;
    private FeaturesMenu featureMenu;
    private Table table;
    private Searchbar searchbar;

    private ConnectionTypes connectionTypes;

    public ConnectionsPage(WebDriver driver, PageConfig pageConfig) {
        super(driver, pageConfig);
    }

    public Paginator getPaginator() {
        return new Paginator(driver);
    }

    public FeaturesMenu getFeatureMenu() {
        return new FeaturesMenu(driver);
    }

    public Table getTable() {
        return new Table(driver);
    }

    public Header getHeader() {
        return new Header(driver);
    }

    private Toggles getToggle() {
        return new Toggles(driver, "//div[@class='connections-filter data-table-header']");
    }

    public boolean toggleIsOn() {
        return getToggle().toggleIsSetOn("show-deactivated");
    }

    public Table setDisabledToggle(boolean state) {
        getToggle().setToggle("show-deactivated", state);
        return new Table(driver);
    }

    public Table searchForConnection(String connectionName) {
        Searchbar searchbar = new Searchbar(driver);
        searchbar.search(connectionName);
        return new Table(driver);
    }

    public ConnectionTypes clickAddNewConnectionBtn() {
        Searchbar searchbar = new Searchbar(driver);
        searchbar.addNew();
        return new ConnectionTypes(driver);
    }

    @Override
    public String getPageUrl() {
        return getBaseUrl() + "/connections";
    }

}
