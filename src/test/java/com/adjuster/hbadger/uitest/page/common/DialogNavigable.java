/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.common;

import com.adjuster.hbadger.uitest.utilities.WebDriverController;

public class DialogNavigable extends Dialog {

    private NavStepper stepper;

    public DialogNavigable(WebDriverController wdController, String containerXpath) {
        super(wdController, containerXpath);
        this.stepper = new NavStepper(wdController);
    }

    public NavStepper getStepper() {
        return stepper;
    }


}
