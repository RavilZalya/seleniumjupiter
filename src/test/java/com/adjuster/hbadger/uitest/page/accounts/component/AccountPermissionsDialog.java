/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.accounts.component;

import com.adjuster.hbadger.uitest.page.common.Dialog;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;

import java.util.List;

public class AccountPermissionsDialog extends Dialog {

    private WebDriverController wdController;
    private final String headerText = "Creating New Account";
    private final String subHeaderText = "Step 2: Account Permissions";

    @FindAll({ @FindBy(xpath = "//*[contains(@class, 'features')]//span") })
    List<WebElement> featuresLabelList;

    @FindAll({ @FindBy(xpath = "//*[contains(@class, 'select-features')]//input") })
    List<WebElement> featuresInputList;


    public AccountPermissionsDialog(WebDriverController wdController) {
        super(wdController, "//app-add-account/.//div[contains(@class,'aj-dialog-container')]");
    }

    public boolean verifyHeader(WebDriverController wdController) { //RZ: coulnd't understand why we are passing driver in here but not doing similar to below method verifySubheader
        this.wdController = wdController;
        return wdController.waitText(header, headerText);
    }

    public boolean verifySubHeader() {

        return wdController.waitText(subHeader, subHeaderText);
    }

    public AccountDetailsDialog clickBack() {

       backButton.click();
       return new AccountDetailsDialog(wdController);
    }

    public ReviewDialog clickNext() {
        nextButton.click();
        return new ReviewDialog(wdController);
    }

    public boolean isLabelVisible(String expectedLabel) {
        return wdController.isTextVisibleInList(featuresLabelList, expectedLabel);
    }

    public boolean verifyToggleValue(String permission, boolean expectedValue) {

        WebElement feature = wdController
                .findElementFromListByAttribute(featuresInputList, "value", permission);
        return wdController
                .attributeEqualsToValue(feature, "ng-reflect-model", Boolean.toString(expectedValue));
    }

    public boolean verifyToggleAvailability(String permission, boolean expectedValue) {

        WebElement feature = wdController
                .findElementFromListByAttribute(featuresInputList, "value", permission);

        return wdController
                .attributeEqualsToValue(feature, "ng-reflect-is-disabled", Boolean.toString(!expectedValue));
    }

}
