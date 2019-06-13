/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.connections.component;


import com.adjuster.hbadger.uitest.page.common.Dialog;
import com.adjuster.hbadger.uitest.page.common.DialogNavigable;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;

public class NewConnectionReview extends DialogNavigable {

    public NewConnectionReview(WebDriverController wdController) {
        super(wdController, "//div[contains(@class,'add-connection-container')]");
    }

    public boolean buttonNextIsEnabled() {
        return super.rightButtonIsEnabled();
    }

    public Dialog clickButtonNext() {
        submitRightButton();
        return new Dialog(wdController, "//app-connection-created-dialog/div");
    }

    public NewConnectionDetails clickButtonBack() {
        submitLeftButton();
        return new NewConnectionDetails(wdController);
    }



}
