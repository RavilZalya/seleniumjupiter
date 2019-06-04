/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.page.connections;

import com.adjuster.honeybadger.uitest.page.commonelements.DialogNavigable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewConnectionDetails extends DialogNavigable {

    @FindBy(how = How.XPATH, using = "//*[@id='name']")
    private WebElement newConnectionName;

    public NewConnectionDetails(WebDriver driver) {
        super(driver, "//div[contains(@class,'add-connection-container')]");
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
        return new NewConnectionPermissions(driver);
    }

    @Override
    public boolean isDisplayed() {
        return getHeader().contains("Step 1: Connection Details");
    }

}
