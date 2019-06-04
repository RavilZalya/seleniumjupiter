/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.page.commonelements;

import com.adjuster.honeybadger.uitest.page.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Base class for dialog menus.  Covers dialog header and footer and common elements such as dialog header, close button, button submitRightButton, button submitLeftButton, etc.
 */
public class Dialog extends Element {

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'dialog-header')]")
    private WebElement header;
    @FindBy(how = How.XPATH, using = "//app-dialog/div/i")
    private WebElement close;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'dialog-footer')]/../div[last()]/*[1]")
    private WebElement leftButton;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'dialog-footer')]/../div[last()]/*[2]")
    private WebElement rightButton;

    public Dialog(WebDriver driver, String containerXpath) {
        super(driver, containerXpath);
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

    /**
     * Closes dialog by clicking button close
     */
    public void close() {
        close.click();
    }
}