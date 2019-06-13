/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.common;

import com.adjuster.hbadger.uitest.page.Element;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Base class for dialog menus.  Covers dialog header and footer and common elements such as dialog header, close button, button submitRightButton, button submitLeftButton, etc.
 */
public class Dialog extends Element {

    @FindBy(how = How.XPATH, using = "//*[contains(@class, 'dialog-container')]//h1")
    protected WebElement header;
    @FindBy(how = How.XPATH, using = "//app-dialog/div/i")
    private WebElement close;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'dialog-footer')]/../div[last()]/*[1]")
    private WebElement leftButton;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'dialog-footer')]/../div[last()]/*[2]")
    private WebElement rightButton;

    /////This is migrated from Adem's Dialog class//
    @FindBy(xpath = "//*[contains(@class, 'dialog-container')]//h2")
    protected WebElement subHeader;
    @FindBy(xpath = "//*[contains(@class, 'dialog-container')]//h5")
    protected WebElement subHeader5;
    @FindBy(xpath = "//*[contains(@class, 'dialog-body-content')]/div")
    protected WebElement dialogBody;
    @FindBy(xpath = "//*[contains(@class, 'dialog')]//p[1]")
    protected WebElement dialogBodyParagraph1;
    @FindBy(xpath = "//*[contains(@class, 'dialog')]//p[2]")
    protected WebElement dialogBodyParagraph2;
    @FindBy(xpath = "//i[contains(@class, 'close-dialog')]")
    protected WebElement closeDialogIcon;
    @FindBy(xpath = "//button[contains(text(),'Next')]")
    protected WebElement nextButton;
    @FindBy(xpath = "//button[contains(text(),'Back')]")
    protected WebElement backButton;
    @FindBy(xpath = "//span[contains(text(),'deactivate')]")
    protected WebElement deactivateSpan;
    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    protected WebElement cancelSpan;
    @FindBy(xpath = "//*[@type='submit']")
    protected WebElement submitButton;
    @FindAll({ @FindBy(xpath = "//*[@class='mat-option-text']") })
    protected List<WebElement> dropdownOptions;
    @FindAll({ @FindBy(xpath = "//button[contains(@class, 'stepper-icon')]")})
    protected List<WebElement> stepperIcons;
    /////////////////


    public Dialog(WebDriverController wdController, String containerXpath) {
        super(wdController, containerXpath);
    }

    public String getHeader() {
        return header.getText();
    }


    /**
     * Checks whether submitRightButton button is enabled. Normally button is disabled until any input in the dialog.
     */
    public boolean rightButtonIsEnabled() {
        return rightButton.isEnabled();
    }

    /**
     * Checks whether submitRightButton button is enabled. Normally button is disabled until any input in the dialog.
     */
    public boolean leftButtonIsEnabled() {
        return leftButton.isEnabled();
    }

    /**
     * Navigates to next sheet/tab.  Subclass will impelement a method returning a specific page object.
     */
    public void submitRightButton() {
        if (rightButtonIsEnabled()) {
            rightButton.click();
        }
    }

    /**
     * Navigates to previous sheet/tab.  Subclass will impelement a method returning a specific page object.
     * This is always enabled.
     */
    public void submitLeftButton() {
        if (leftButtonIsEnabled()) {
            leftButton.click();
        }
    }

    public String getHeaderText() {
        return header.getText();
    }

    /**
     * Closes dialog by clicking button close
     */
    public void close() {
        close.click();
    }
}