package com.adjuster.hbadger.uitest.page.account.component;

import com.adjuster.hbadger.uitest.page.common.DialogNavigable;
import com.adjuster.hbadger.uitest.page.common.Snackbar;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;

public class NewUserReview extends DialogNavigable {
    public NewUserReview(WebDriverController wdController) {
        super(wdController, "//app-add-user/.//div[contains(@class,'aj-dialog-container')]");
    }

    public boolean buttonNextIsEnabled() {
        return super.rightButtonIsEnabled();
    }

    public Snackbar clickButtonNext() {
        submitRightButton();
        return new Snackbar(wdController);
    }

    public NewUserPermissions clickButtonBack() {
        submitLeftButton();
        return new NewUserPermissions(wdController);
    }
}
