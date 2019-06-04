/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.page.commonelements;

import org.openqa.selenium.WebDriver;

public class DialogNavigable extends Dialog {

    private NavStepper stepper;

    public DialogNavigable(WebDriver driver, String containerXpath) {
        super(driver, containerXpath);
        this.stepper = new NavStepper(driver);
    }

    public NavStepper getStepper() {
        return stepper;
    }


}
