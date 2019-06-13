/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.connections.component;

import com.adjuster.hbadger.uitest.page.common.DialogNavigable;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewConnectionDetails extends DialogNavigable {

    @FindBy(how = How.XPATH, using = "//*[@id='name']")
    private WebElement newConnectionName;

    public NewConnectionDetails(WebDriverController wdController) {
        super(wdController, "//div[contains(@class,'add-connection-container')]");
    }

    /**
     * Input for field 'Connection Name' and proceed.
     */
    public NewConnectionDetails andIGiveNameToConnection(String connName) {
        newConnectionName.clear();
        newConnectionName.sendKeys(connName);
        return this;
    }

    public boolean buttonNextIsEnabled() {
        return super.leftButtonIsEnabled();
    }

    public NewConnectionPermissions clickButtonNext() {
        submitLeftButton();
        return new NewConnectionPermissions(wdController);
    }

}
