package com.adjuster.hbadger.uitest.page.reports.component;

import com.adjuster.hbadger.uitest.page.common.Dialog;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;

public class UnsavedChangesDialog extends Dialog {  //is this the same as confirmation dialog?

    public UnsavedChangesDialog(WebDriverController wdController) {
        super(wdController, "//app-unsaved-changes/div");
    }
}
