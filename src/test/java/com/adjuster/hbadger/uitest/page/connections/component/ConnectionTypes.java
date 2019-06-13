/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.connections.component;

import com.adjuster.hbadger.uitest.page.Element;
import com.adjuster.hbadger.uitest.page.common.Paginator;
import com.adjuster.hbadger.uitest.page.common.Searchbar;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ConnectionTypes extends Element {

    @FindBy(how = How.XPATH, using = ".//cdk-cell")
    List<WebElement> connectionTypes;

    private Searchbar searchbar;

    public ConnectionTypes(WebDriverController wdController) {
        super(wdController, "//div[contains(@class,'connection-types-container')]");
    }

    public Searchbar getSearchbar() {
        return new Searchbar(wdController);
    }

    public Paginator getPaginator() {
        Paginator paginator = new Paginator(wdController);
        return paginator;
    }

    public NewConnectionDetails selectConnectionType(String connectionType) {
        connectionTypes.get(wdController.getIndex(connectionTypes, connectionType)).click();
        return new NewConnectionDetails(wdController);
    }

}
