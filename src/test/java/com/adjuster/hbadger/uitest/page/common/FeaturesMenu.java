/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.common;

import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class FeaturesMenu extends SideBar {


    @FindBy(how = How.XPATH, using = "././/nav/ul/li/a[contains(@class,'ng-tns-c5-3')]")
    List<WebElement> feature;

    public FeaturesMenu(WebDriverController wdController) {
        super(wdController, "//div[@class='desktop-nav']");
    }

    //public void select(String featureName) {
    //    wdController.selectFromList(feature, featureName);

    public void select(String featureName) {
        feature.get(wdController.getIndex(feature, featureName)).click();
    }

}
