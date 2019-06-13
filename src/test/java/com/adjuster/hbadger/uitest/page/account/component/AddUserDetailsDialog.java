/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.account.component;


import com.adjuster.hbadger.uitest.page.common.Dialog;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserDetailsDialog extends Dialog {

    private WebDriverController wdController;
    private final String expectedHeaderText = "Adding Users in ";
    private final String expectedSubheaderText = "Step 1: User Details";
    private final String expectedFirstNameLabel = "First Name";
    private final String expectedLastNameLabel = "Last Name";
    private final String expectedAccountTypeLabel = "Account Type";
    private final String expectedEmailAddressLabel = "Email Address";
    private final String expectedSendEmailLabel = "Send Email";

    @FindBy(xpath = "//*[contains(@class, 'first-name label')]/span")
    WebElement firstNameLabel;

    @FindBy(xpath = "//*[contains(@class, 'last-name label')]/span")
    WebElement lastNameLabel;

    @FindBy(xpath = "//*[contains(@class, 'account label')]/span")
    WebElement accountTypeLabel;

    @FindBy(xpath = "//*[@class='email label']/span")
    WebElement emailAddressLabel;

    @FindBy(xpath = "//*[contains(@class, 'send-email label')]/span")
    WebElement sendEmailLabel;

    @FindBy(xpath = "//*[@placeholder= 'Enter user first name']")
    WebElement firstNameTextbox;

    @FindBy(xpath = "//*[@placeholder= 'Enter user last name']")
    WebElement lastNameTextbox;

    @FindBy(xpath = "//*[contains(@ng-reflect-name, 'accountype')]")
    WebElement accountTypeDropdown;

    @FindBy(xpath = "//*[@placeholder= 'Enter user email address']")
    WebElement emailAddressTextbox;

    @FindBy(xpath = "//*[text()= 'Send email to user upon creation of account ']")
    WebElement sendEmilInfoText;

    @FindBy(xpath = "//*[@class='send-email-input']/label")
    WebElement sendEmailToggle;
    
    @FindBy(xpath = "//*[@class='send-email-input']/label/input")
    WebElement sendEmailToggleInput;

    public AddUserDetailsDialog(WebDriverController wdController) {
        super(wdController, "//app-add-user/.//div[contains(@class,'aj-dialog-container')]");
    }


    public AddUserDetailsDialog whenPageHeaderIsVisible(WebDriverController wdController, String accountName) {
		this.wdController = wdController;
		return wdController.waitText(header, expectedHeaderText + accountName) ? this : null;
	}

    public boolean isSubHeaderVisible() { return wdController.waitText(subHeader, expectedSubheaderText); }

    public boolean isFirstNameLabelVisible() { return wdController.waitText(firstNameLabel, expectedFirstNameLabel); }

    public boolean isLastNameLabelVisible() { return wdController.waitText(lastNameLabel, expectedLastNameLabel); }

    public boolean isAccountTypeLabelVisible() { return wdController.waitText(accountTypeLabel, expectedAccountTypeLabel); }

    public boolean isEmailLabelVisible() { return wdController.waitText(emailAddressLabel, expectedEmailAddressLabel); }

    public boolean isSendEmailLabelVisible() { return wdController.waitText(sendEmailLabel, expectedSendEmailLabel); }

    public boolean isFirstNameTextboxVisible() { return wdController.waitElementToBeVisible(firstNameTextbox); }

    public boolean isLastNameTextboxVisible() { return wdController.waitElementToBeVisible(lastNameTextbox); }

    public boolean isAccountTypeDropdownVisible() { return wdController.waitElementToBeVisible(accountTypeDropdown); }

    public boolean isEmailTextboxVisible() { return wdController.waitElementToBeVisible(emailAddressTextbox); }

    public boolean isSendEmailToggleVisible() { return wdController.waitElementToBeVisible(sendEmailToggle); }

    public boolean isSendEmailToggleOn() {
       return wdController.attributeEqualsToValue(sendEmailToggleInput, "value", "true");
    }

    public boolean isSendEmailInfoTextVisible() { return sendEmilInfoText.isDisplayed();}

    public AddUserDetailsDialog enterFirstName(String firstName) {
        firstNameTextbox.sendKeys(firstName);
        return this;
    }

    public AddUserDetailsDialog enterLastName(String lastName) {
        lastNameTextbox.sendKeys(lastName);
        return this;
    }

    public AddUserDetailsDialog selectAccountType(boolean isExternalUser) {

        if (isExternalUser)
            accountTypeDropdown.sendKeys("External");
        else
            accountTypeDropdown.sendKeys("Internal");

        return this;
    }


    public AddUserDetailsDialog enterEmail(String email) {
        emailAddressTextbox.sendKeys(email);
        return this;
    }

    public AddUserDetailsDialog setSendEmail(boolean isSendEmail) {
        if (isSendEmail)
            sendEmailToggle.click();
        return this;
    }

    //RZ: commented out as not needed for poc
    //public AddUserPermissionsDialog clickOnNextButton() {
    //    wdController.waitElementToBeClickable(nextButton);
    //    nextButton.click();
    //}

}
