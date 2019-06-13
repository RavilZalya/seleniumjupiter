package com.adjuster.hbadger.uitest.page.datamanager.component;

import com.adjuster.hbadger.uitest.page.common.DialogNavigable;
import com.adjuster.hbadger.uitest.page.common.Snackbar;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;

public class NewDatasetConfig extends DialogNavigable {

    public NewDatasetConfig(WebDriverController wdController) {
        super(wdController, "//div[contains(@class,'add-data-set-container')]");
    }

    public boolean buttonNextIsEnabled() {
        return super.rightButtonIsEnabled();
    }

    public Snackbar clickButtonNext() {
        submitRightButton();
        return new Snackbar(wdController);
    }

}
