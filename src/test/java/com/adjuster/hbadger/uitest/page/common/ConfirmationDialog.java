package com.adjuster.hbadger.uitest.page.common;

import com.adjuster.hbadger.uitest.utilities.WebDriverController;

public class ConfirmationDialog extends Dialog {

    public ConfirmationDialog(WebDriverController wdController) {
        super(wdController, "//app-confirmation-dialog/div");
    }
}
