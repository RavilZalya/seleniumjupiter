/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.page.commonelements;

import com.adjuster.honeybadger.uitest.page.Element;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Represents a toggle grid.
 */
public class Toggles extends Element {

    @FindBy(how = How.XPATH, using = ".//label[contains(@class,'toggle-container')]/input")
    protected List<WebElement> toggles;

    public Toggles(WebDriver driver, String containerXpath) {
        super(driver, containerXpath);
    }

    public void setToggle(String toggleName, boolean state) {
        if (toggleIsEnabled(toggleName) && (toggleIsSetOn(toggleName) != state)) {
            ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].parentNode.click();"
                            , toggles.get(getIndex(toggles, "id", toggleName)));
        }
    }

    public boolean toggleIsSetOn(String toggleName) {
        return toggles.get(getIndex(toggles, "id", toggleName)).isSelected();
    }

    public boolean toggleIsEnabled(String toggleName) {
        return toggles.get(getIndex(toggles, "id", toggleName)).isEnabled();
    }

}

