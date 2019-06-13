/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.account.component;

import com.adjuster.hbadger.uitest.page.accounts.AccountsPage;
import com.adjuster.hbadger.uitest.page.common.Dialog;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.support.PageFactory;


public class DeactivateUserDialog extends Dialog { //I would create this into ConfirmationDialog extending Dialog and re-use it.

    private WebDriverController wdController;
    private final String expectedHeaderText = "Deactivating User";
    private final String expectedSubheaderText = "Are you sure you want to deactivate %s?";
    private final String expectedDialogBodyText = "This user’s login will be disabled and they will no longer have " +
            "access to %s’s ProgrammaticIQ account.";

    public DeactivateUserDialog(WebDriverController wdController) {
        super(wdController, "//app-confirmation-dialog/.//div[contains(@class,'aj-dialog-container')]");
    }


    public DeactivateUserDialog whenHeaderVisible(WebDriverController wdController) {
        this.wdController = wdController;
        return wdController.waitText(header, expectedHeaderText) ? this : null;
    }

    public boolean isHeaderVisible() { return header.getText().equals(expectedHeaderText); }

    public boolean isSubHeaderVisible(String userFullName) {
        return subHeader.getText().equals(String.format(expectedSubheaderText, userFullName));
    }

    public boolean isBodyTextVisible(String accountName) {
        return dialogBody.getText().equals(String.format(expectedDialogBodyText, accountName));
    }

    public boolean isCancelButtonEnabled() { return wdController.waitElementToBeClickable(cancelSpan); }

    public boolean isDeactivateButtonEnabled() { return wdController.waitElementToBeClickable(deactivateSpan); }

    public void clickOnDeactivateButton() {
        deactivateSpan.click(); //should this return confirmation dialog or snackbar?
        //return PageFactory.initElements(wdController.getDriver(), AccountsPage.class);
    }

}
