/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.common;

import com.adjuster.hbadger.uitest.page.Element;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.By;

public class Snackbar extends Element {

    private final By message = By.xpath("//app-snack/div/div");
    private String messageText;
    private boolean success;

    /**
     * Represents a snackbar. Snackbar is message displayed at the bottom of the screen. It is briefly displayed as a confirmation of user's failed or successful actionFilledCard.
     */
    public Snackbar(WebDriverController wdController) {
        super(wdController, "//app-snack");
        this.messageText = wdController.findVisibleElement(message).getText();
        this.success = wdController.findVisibleElement(message).getAttribute("class").contains("success");
    }

    /**
     * Gets the text message.
     */
    public String getMessage() {
        return messageText;
    }

    /**
     * Gets the status.  Whether the actionFilledCard was successful or failure.
     */
    public boolean isSuccess() {
        return success;
    }

}