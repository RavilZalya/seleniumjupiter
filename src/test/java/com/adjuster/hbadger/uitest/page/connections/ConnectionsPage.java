
/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.connections;

import com.adjuster.hbadger.uitest.config.PageConfig;
import com.adjuster.hbadger.uitest.page.Page;
import com.adjuster.hbadger.uitest.page.common.FeaturesMenu;
import com.adjuster.hbadger.uitest.page.common.Header;
import com.adjuster.hbadger.uitest.page.common.Paginator;
import com.adjuster.hbadger.uitest.page.common.Searchbar;
import com.adjuster.hbadger.uitest.page.common.Table;
import com.adjuster.hbadger.uitest.page.common.Toggles;
import com.adjuster.hbadger.uitest.page.connections.component.ConnectionTypes;
import com.adjuster.hbadger.uitest.page.connections.component.ConnectionsTable;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionsPage extends Page {

    private static final Logger LOG = LoggerFactory.getLogger(ConnectionsPage.class);

    private Header header;
    private Paginator paginator;
    private FeaturesMenu featureMenu;
    private ConnectionsTable table;
    private Searchbar searchbar;

    private ConnectionTypes connectionTypes;

    public ConnectionsPage(WebDriverController wdController, PageConfig pageConfig) {
        super(wdController, pageConfig);
    }

    public Paginator getPaginator() {
        return new Paginator(wdController);
    }

    public FeaturesMenu getFeatureMenu() {
        return new FeaturesMenu(wdController);
    }

    public ConnectionsTable getTable() {
        return new ConnectionsTable(wdController);
    }

    public Header getHeader() {
        return new Header(wdController);
    }

    private Toggles getToggle() {
        return new Toggles(wdController, "//div[@class='connections-filter data-table-header']");
    }

    public boolean toggleIsOn() {
        return getToggle().toggleIsSetOn("show-deactivated");
    }

    public Table setDisabledToggle(boolean state) {
        getToggle().setToggle("show-deactivated", state);
        return new Table(wdController);
    }

    public Table searchForConnection(String connectionName) {
        Searchbar searchbar = new Searchbar(wdController);
        searchbar.search(connectionName);
        return new Table(wdController);
    }

    public ConnectionTypes clickAddNewConnectionBtn() {
        Searchbar searchbar = new Searchbar(wdController);
        searchbar.addNew();
        return new ConnectionTypes(wdController);
    }

    @Override
    public String getPageUrl() {
        return getBaseUrl() + "/connections";
    }

}
