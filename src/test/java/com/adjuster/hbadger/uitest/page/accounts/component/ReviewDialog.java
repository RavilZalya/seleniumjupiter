/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.accounts.component;

import com.adjuster.hbadger.uitest.page.accounts.AccountsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import com.adjuster.hbadger.uitest.page.common.Dialog;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;

import java.util.List;

public class ReviewDialog extends Dialog {

    private WebDriverController wdController;
    private final String headerText = "Creating New Account";
    private final String subHeaderText = "Step 3: Review";

    @FindAll({@FindBy(xpath = "//*[contains(@class, 'review')]/div/div[1]")})
    List<WebElement> reviewItemsLabelList;

    @FindAll({@FindBy(xpath = "//*[contains(@class, 'review')]/div/div[2]")})
    List<WebElement> reviewItemsValueList;

    public ReviewDialog(WebDriverController wdController) {
        super(wdController, "//app-add-account/.//div[contains(@class,'aj-dialog-container')]");
    }

    public boolean verifyHeader(WebDriverController wdController) {

        this.wdController = wdController;
        return wdController.waitText(header, headerText);
    }

    public boolean verifySubHeader() {
        return wdController.waitText(subHeader, subHeaderText);
    }

    public void clickAddAccountButton() {
        submitButton.click();
    }

    public String getAccountLabel() {
        return reviewItemsLabelList.get(0).getText().trim();
    }

    public String getSalesforceAccountLabel() {
        return reviewItemsLabelList.get(1).getText().trim();
    }

    public String getTimezoneLabel() {
        return reviewItemsLabelList.get(2).getText().trim();
    }

    public String getSSOLabel() {
        return reviewItemsLabelList.get(3).getText().trim();
    }

    public String getPermissionsLabel() {
        return reviewItemsLabelList.get(4).getText().trim();
    }

    public String getAccountValue() {
        return reviewItemsValueList.get(0).getText().trim();
    }

    public String getSalesforceAccountValue() {
        return reviewItemsValueList.get(1).getText().trim();
    }

    public String getTimezoneValue() {
        return reviewItemsValueList.get(2).getText().trim();
    }

    public String getSSOValue() {
        return reviewItemsValueList.get(3).getText().trim();
    }

    public String getPermissionsValue() {
        return reviewItemsValueList.get(4).getText().trim();
    }

}
