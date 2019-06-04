/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.page.commonelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class FeaturesMenu extends SideBar {

    @FindBy(how = How.XPATH, using = "././/nav/ul/li/a[contains(@class,'ng-tns-c5-3')]")
    List<WebElement> feature;

    public FeaturesMenu(WebDriver driver) {
        super(driver, "//div[@class='desktop-nav']");
    }

    public void select(String featureName) {
        feature.get(getIndex(feature, featureName)).click();

    }

}