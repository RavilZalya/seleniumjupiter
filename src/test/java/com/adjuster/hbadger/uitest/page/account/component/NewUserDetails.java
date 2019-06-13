/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.account.component;


import com.adjuster.hbadger.uitest.page.common.DialogNavigable;
import com.adjuster.hbadger.uitest.page.common.Dropdown;
import com.adjuster.hbadger.uitest.page.common.FormControlFeedback;
import com.adjuster.hbadger.uitest.page.common.Toggles;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewUserDetails extends DialogNavigable {

    @FindBy(how = How.XPATH, using = "//*[@name='firstName']")
    private WebElement firstNameInput;
    @FindBy(how = How.XPATH, using = "//div[@class='first-name label']")
    private WebElement firstNameLabel;
    @FindBy(how = How.XPATH, using = "//*[@name='lastName']")
    private WebElement lastNameInput;
    @FindBy(how = How.XPATH, using = "//div[@class='last-name label']")
    private WebElement lastNameLabel;
    @FindBy(how = How.XPATH, using = "//*[@name='email']")
    private WebElement emailAddressInput;
    @FindBy(how = How.XPATH, using = "//div[@class='email label']")
    private WebElement emailAddressLabel;
    @FindBy(how = How.XPATH, using = "//mat-select[@name='accountype']")
    private WebElement accountTypeDropdownClick;
    @FindBy(how = How.XPATH, using = "//div[@class='salesforce-account label']")
    private WebElement accountTypeLabel;
    @FindBy(how = How.XPATH, using = "//div[@class='send-email label']")
    private WebElement sendEmailLabel;

    public NewUserDetails(WebDriverController wdController) {
        super(wdController, "//app-add-user/.//div[contains(@class,'aj-dialog-container')]");
    }

    /**
     * Input for field 'Connection Name' and proceed.
     */
    public NewUserDetails andIEnterUserDetails(String firstName, String lastName, String accountType) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        selectAccountType(accountType);
        getSendEmailToggle().setToggle("sendEmail", false);
        return this;
    }

    public NewUserDetails selectAccountType(String userType) {
        accountTypeDropdownClick.click();
        Dropdown accountTypeDropdown = new Dropdown(wdController);
        accountTypeDropdown.select(userType);
        return this;
    }

    public NewUserDetails andEnterValidEmailFormat(String validEmailFormat) {
        emailAddressInput.clear();
        emailAddressInput.sendKeys(validEmailFormat);
        return this;
    }

    public FormControlFeedback andEnterInValidEmailFormat(String inValidEmailFormat) {
        emailAddressInput.clear();
        emailAddressInput.sendKeys(inValidEmailFormat);
        return new FormControlFeedback(wdController, "//div[@class='email-input']");
    }

    public Toggles getSendEmailToggle() {
        return new Toggles(wdController, "//div[@class='send-email-input']");
    }

    public boolean buttonNextIsEnabled() {
        return super.leftButtonIsEnabled();
    }

    public NewUserPermissions clickButtonNext() {
        submitLeftButton();
        return new NewUserPermissions(wdController);
    }

}
