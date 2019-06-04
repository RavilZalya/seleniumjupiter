/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.page.commonelements;

import com.adjuster.honeybadger.uitest.page.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Snackbar extends Element {

    private final By message = By.xpath("//app-snack/div/div");
    private String messageText;
    private boolean success;

    /**
     * Represents a snackbar. Snackbar is message displayed at the bottom of the screen. It is briefly displayed as a confirmation of user's failed or successful actionFilledCard.
     */
    public Snackbar(WebDriver driver) {
        super(driver, "//app-snack");
        this.messageText = findVisibleElement(message).getText();
        this.success = findVisibleElement(message).getAttribute("class").contains("success");
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