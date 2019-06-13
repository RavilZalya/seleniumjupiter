/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.account.component;

import com.adjuster.hbadger.uitest.page.common.DialogNavigable;
import com.adjuster.hbadger.uitest.page.common.Toggles;
import com.adjuster.hbadger.uitest.page.connections.component.NewConnectionDetails;
import com.adjuster.hbadger.uitest.page.connections.component.NewConnectionReview;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class NewUserPermissions extends DialogNavigable {

    @FindBy(how = How.XPATH, using = "//div[@class='add-user-permissions-container']/.//h3")
    private WebElement crud;
    @FindBy(how = How.XPATH, using = "//app-add-user/.//div[@class='product-name label']")
    List<WebElement> productName;
    @FindBy(how = How.XPATH, using = "//app-add-user/.//div[@class='dialog-body-content']")
    List<WebElement> toggles;

    public NewUserPermissions(WebDriverController wdController) {
        super(wdController, "//app-add-user/.//div[contains(@class,'aj-dialog-container')]");
    }

    public boolean buttonNextIsEnabled() {
        return super.rightButtonIsEnabled();
    }

    public NewUserReview clickButtonNext() {
        submitRightButton();
        return new NewUserReview(wdController);
    }

    public NewUserReview clickButtonBack() {
        submitLeftButton();
        return new NewUserReview(wdController);
    }

    //toggle naming pattern ex: user_create, user_read,user_update,user_delete,account_create,account_read,account,update,account_delete, etc...
    public Toggles getToggleGrid() {
        return new Toggles(wdController, "//app-add-user/.//div[@class='dialog-body-content']");
    }
}
