/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.page.connections;

import com.adjuster.honeybadger.uitest.page.Element;
import com.adjuster.honeybadger.uitest.page.commonelements.Paginator;
import com.adjuster.honeybadger.uitest.page.commonelements.Searchbar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ConnectionTypes extends Element {

    @FindBy(how = How.XPATH, using = ".//cdk-cell")
    protected List<WebElement> connectionTypes;

    private Searchbar searchbar;

    public ConnectionTypes(WebDriver driver) {
        super(driver, "//div[contains(@class,'connection-types-container')]");
    }

    public Searchbar getSearchbar() {
        return new Searchbar(driver);
    }

    public Paginator getPaginator() {
        Paginator paginator = new Paginator(driver);
        return paginator;
    }

    public NewConnectionDetails selectConnectionType(String connectionType) {
        connectionTypes.get(getIndex(connectionTypes, connectionType)).click();
        return new NewConnectionDetails(driver);
    }

}
