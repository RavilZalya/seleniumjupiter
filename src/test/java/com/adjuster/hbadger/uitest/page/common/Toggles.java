/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.common;

import com.adjuster.hbadger.uitest.page.Element;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Represents a toggle grid.
 */
public class Toggles extends Element {

    @FindBy(how = How.XPATH, using = ".//label[contains(@class,'toggle-container')]/input")
    private List<WebElement> toggles;

    public Toggles(WebDriverController wdController, String containerXpath) {
        super(wdController, containerXpath);
    }

    public Toggles setToggle(String toggleName, boolean state) {
        if (toggleIsEnabled(toggleName) && (toggleIsSetOn(toggleName) != state)) {
            wdController.getJsExecutor().executeScript("return arguments[0].parentNode.click();"
                    , toggles.get(wdController.getIndex(toggles, "id", toggleName)));
        }
        return this;
    }

    public boolean toggleIsSetOn(String toggleName) {
        return toggles.get(wdController.getIndex(toggles, "id", toggleName)).isSelected();
    }

    public boolean toggleIsEnabled(String toggleName) {
        return toggles.get(wdController.getIndex(toggles, "id", toggleName)).isEnabled();
    }

}

