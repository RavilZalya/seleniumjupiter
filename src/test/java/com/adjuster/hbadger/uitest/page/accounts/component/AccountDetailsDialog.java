/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.accounts.component;

import com.adjuster.hbadger.uitest.page.common.Dialog;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class AccountDetailsDialog extends Dialog {

    private WebDriverController wdController;
    private final String headerText = "Creating New Account";
    private final String subHeaderText = "Step 1: Account Details";
    private final String expectedAccountNameLabel = "Account Name";
    private final String expectedSalesforceAccountLabel = "Salesforce Account";
    private final String expectedTimezoneLabel = "Timezone";
    private final String expectedEnableSsoSupportLabel = "Enable SSO Support";
    private final String expectedmaxUsersLabel = "Max Users";
    private final String expectedmaxUsersNumber = "3";

    @FindBy(xpath = "//*[contains(@class, 'email label')]/span")
    WebElement accountNameLabel;

    @FindBy(name = "accountName")
    WebElement accountNameTextbox;

    @FindBy(xpath = "//*[contains(@class, 'salesforce-account label')]/span")
    WebElement salesforceAccountLabel;

    @FindBy(xpath = "//*[contains(@class, 'timezone label')]/span")
    WebElement timezoneLabel;

    @FindBy(id = "timezone")
    WebElement timezoneElement;

    @FindAll({ @FindBy(xpath = "//*[@class='mat-option-text']") })
    List<WebElement> timezoneOptions;

    @FindBy(xpath = "//*[contains(text(), 'Enable SSO Support')]")
    WebElement enableSsoSupportLabel;

    @FindBy(xpath = "//*[contains(text(), 'Max Users')]")
    WebElement maxUsersLabel;

    @FindBy(name = "maxUsers")
    WebElement maxUsersInput;

    public AccountDetailsDialog(WebDriverController wdController) {
        super(wdController, "//app-add-account/.//div[contains(@class,'aj-dialog-container')]");
    }

    public boolean verifyHeader(WebDriverController wdController) {
        this.wdController = wdController;
        return wdController.waitText(header, headerText);
    }

    public boolean verifySubHeader() {
        return wdController.waitText(subHeader, subHeaderText);
    }

    public boolean verifyAccountNameLabel() { return expectedAccountNameLabel.equals(accountNameLabel.getText()); }

    public boolean verifySalesforceLabel() {

        return expectedSalesforceAccountLabel.equals(salesforceAccountLabel.getText());
    }

    public boolean verifyTimezoneLabel() { return expectedTimezoneLabel.equals(timezoneLabel.getText()); }

    public boolean verifySsoLabel() { return expectedEnableSsoSupportLabel.equals(enableSsoSupportLabel.getText()); }

    public boolean verifyMaxUserLabel() { return expectedmaxUsersLabel.equals(maxUsersLabel.getText()); }

    public boolean verifyDefaultNumberOfMaxUsers() {

        return expectedmaxUsersNumber.equals(maxUsersInput.getAttribute("ng-reflect-model"));
    }

    // actions
    public AccountDetailsDialog enterAccountName (String accountName) {
        accountNameTextbox.sendKeys(accountName);
        return this;
    }

    public AccountDetailsDialog selectTimeZone (String timezone) {
        timezoneElement.click();
        wdController.sleep(1000); // TODO this should be dynamic
        wdController.selectFromList(timezoneOptions, timezone);
        return this;
    }

    public AccountPermissionsDialog clickNext () {
        nextButton.click();
        return new AccountPermissionsDialog(wdController);
    }


}
