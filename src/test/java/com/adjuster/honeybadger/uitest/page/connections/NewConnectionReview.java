/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.page.connections;

import com.adjuster.honeybadger.uitest.page.commonelements.Dialog;
import com.adjuster.honeybadger.uitest.page.commonelements.DialogNavigable;
import org.openqa.selenium.WebDriver;

public class NewConnectionReview extends DialogNavigable {

    public NewConnectionReview(WebDriver driver) {
        super(driver, "//div[contains(@class,'add-connection-container')]");
    }

    public boolean buttonNextIsEnabled() {
        return super.rightButtonIsEnabled();
    }

    public Dialog clickButtonNext() {
        submitRightButton();
        return new Dialog(driver, "//app-connection-created-dialog/div");
    }

    public NewConnectionDetails clickButtonBack() {
        submitLeftButton();
        return new NewConnectionDetails(driver);
    }

    @Override
    public boolean isDisplayed() {
        return getHeader().contains("Step 3: Review");
    }

}
