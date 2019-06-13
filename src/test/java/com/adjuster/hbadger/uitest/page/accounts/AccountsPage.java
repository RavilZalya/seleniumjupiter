/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.accounts;

import com.adjuster.hbadger.uitest.config.PageConfig;
import com.adjuster.hbadger.uitest.page.Page;
import com.adjuster.hbadger.uitest.page.account.AccountPage;
import com.adjuster.hbadger.uitest.page.accounts.component.AccountDetailsDialog;
import com.adjuster.hbadger.uitest.page.common.DataTable;
import com.adjuster.hbadger.uitest.page.common.Header;
import com.adjuster.hbadger.uitest.page.account.component.AddUserDetailsDialog;
import com.adjuster.hbadger.uitest.page.account.component.DeactivateUserDialog;
import com.adjuster.hbadger.uitest.page.common.SnackBarr;
import com.adjuster.hbadger.uitest.page.common.Table;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountsPage extends Page {

    private final String expectedHeaderText = "Accounts";//TODO:this will not be hardcoded but passed in data provider as expected value

    @FindAll({@FindBy(xpath = "//cdk-row//a")})
    List<WebElement> foundAccountNames;

    @FindBy(xpath = "//*[starts-with(text(),'Add users to')]")
    WebElement noUserAddUserText;

    @FindBy(xpath = "//span[contains(text(), 'Users')]")
    WebElement usersTab;

    @FindBy(xpath = "//span[contains(text(), 'Settings')]")
    WebElement settingsTab;

    @FindBy(xpath = "//cdk-cell[contains(@class, 'cdk-column-active')]/i")
    WebElement accountStatus;

    @FindBy(xpath = "//i[@ng-reflect-message='Deactivate User']")
    WebElement deactivateUserIcon;

    @FindBy(xpath = "//i[@ng-reflect-message='Activate User']")
    WebElement activateUserIcon;

    @FindBy(xpath = "//div[contains(@class, 'snackbar')]//div[contains(@class, 'message')]")
    WebElement snackBarMessage;

    @FindBy(xpath = "//div[contains(@class, 'snackbar')]//div[contains(@class, 'message')]/i")
    WebElement snackBarMessageIcon;

    private DataTable dataTable;

    public AccountsPage(WebDriverController wdController, PageConfig pageConfig) {
        super(wdController, pageConfig);
        dataTable = new DataTable(wdController);
    }

    public Header getHeader() {
        return new Header(wdController);
    }

    //Adem's old Page seem to have element PageTitle. need to discuss to define Page
    //public boolean verifyPageHeader() {
    //    return wdController.waitText(pageTitle, expectedHeaderText);
    // }

    //public boolean verifyPageHeader(String expectedHeader) {
    //    return wdController.waitText(pageTitle, expectedHeader);
    //}

    public boolean isNoUserTextVisible(String accountName) {
        return noUserAddUserText.getText().contains(accountName);
    }

    public boolean isAddUserButtonClickable() {
        return wdController.waitElementToBeClickable(dataTable.addNewButton);
    }

    public boolean isAddUserIconClickable() {
        return wdController.waitElementToBeClickable(dataTable.addNewButton);
    }

    public boolean isAddAccountButtonClickable() {
        return wdController.waitElementToBeClickable(dataTable.addNewButton);
    }

    public boolean isDeactivateUserClickable() {
        return wdController.waitElementToBeClickable(deactivateUserIcon);
    }

    public boolean isActivateUserClickable() {
        return wdController.waitElementToBeClickable(activateUserIcon);
    }

    public AccountDetailsDialog clickOnAddNewAccount() {
        dataTable.addNewButton.click();
        return new AccountDetailsDialog(wdController);
    }

    public AddUserDetailsDialog clickOnAddNewUsersButton() {
        dataTable.addNewButton.click();
        return new AddUserDetailsDialog(wdController);
    }

    public AccountsPage whenAddUserButtonVisible() {
        return wdController.waitElementToBeVisible(dataTable.addNewButton) ? this : null;
    }

    public AccountsPage whenSearchBarVisible() {
        return wdController.waitElementToBeVisible(dataTable.searchBar) ? this : null;
    }

    public AccountsPage whenUserDeactivateIconIsClickable() {
        return wdController.waitElementToBeClickable(deactivateUserIcon) ? this : null;
    }

    public AccountsPage whenUserActivateIconIsClickable() {
        return wdController.waitElementToBeClickable(activateUserIcon) ? this : null;
    }

    public DeactivateUserDialog clickOnUserDeactivateIcon() {
        deactivateUserIcon.click();
        return PageFactory.initElements(wdController.getDriver(), DeactivateUserDialog.class);
    }

    public DeactivateUserDialog clickOnUserActivateIcon() {
        activateUserIcon.click();
        return PageFactory.initElements(wdController.getDriver(), DeactivateUserDialog.class);
    }

    // see comment above: pageTitle
    //public AccountsPage whenPageHeaderIs(String expectedHeader) {
    //    return wdController.waitText(pageTitle, expectedHeader) ? this : null;
    // }

    public AccountsPage enterAccountNameToSearchBar(String accountName) {
        dataTable.searchBar.sendKeys(accountName);
        return this;
    }

    public AccountsPage waitNumberOfFoundAccountsToBe(int expectedNumberOfFoundAccount) {
        wdController.waitListSize(foundAccountNames, expectedNumberOfFoundAccount);
        return this;
    }

    public AccountsPage enterUserEmailToSearchBar(String email) {
        dataTable.searchBar.sendKeys(email);
        return this;
    }

    public AccountsPage clearSearchBar() {
        dataTable.searchBar.clear();
        return this;
    }

    public int numberOfFoundAccounts() {
        return wdController.waitElementsVisibleReturnSize(foundAccountNames);
    }

    public AccountsPage clickOnFoundAccountName() {
        foundAccountNames.get(0).click();
        return this;
    }

    public boolean isUsersTabVisible() {
        return wdController.waitElementToBeVisible(usersTab);
    }

    public boolean isSettingsTabVisible() {
        return wdController.waitElementToBeVisible(settingsTab);
    }

    public void clickOnSettingsTab() {
        settingsTab.click();
    }

    public boolean isAccountActive() {
        return accountStatus.getAttribute("title").equals("Active");
    }

    public boolean verifySuccessMessage(String message) {
        return wdController.waitText(snackBarMessage, message);
    }

    public boolean isMessageStatusOK() {
        return wdController.waitAndGetAttribute(snackBarMessageIcon, "class").contains("fa-check-circle");
    }

    public boolean isSuccessMessageVisible() {
        return new SnackBarr(wdController).getMessage().equals("User Created");
    }

    /////

    public AccountPage goToAccountPage(String accountName) {
        new Table(wdController).open("Account", accountName);
        return new AccountPage(wdController, getPageConfig());
    }


    /////
    @Override
    public String getPageUrl() {
        return getBaseUrl() + "/accounts";
    }

}
