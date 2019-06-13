/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.common;

import com.adjuster.hbadger.uitest.page.Element;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Represents a dropdown
 */
public class Dropdown extends Element {

    @FindBy(how = How.XPATH, using = "././/mat-option[@role='option']")
    private List<WebElement> optionList;

    public Dropdown(WebDriverController Dropdown) {
        super(Dropdown, "//div[contains(@class,'mat-select-panel-done-animating')]");
    }

    /**
     * Selects an option.
     */
    public void select(String optionLabel) {
        if (isEnabled(optionLabel) && !isSelected(optionLabel)) {
            optionList.get(wdController.getIndex(optionList, optionLabel)).click();
        }
    }

    /**
     * Checks if option is selected.
     */
    private boolean isSelected(String optionLabel) {
        return !optionList.get(wdController.getIndex(optionList, optionLabel)).getAttribute("aria-selected").equals("false");
    }

    /**
     * Checks if option is enabled.
     */
    private boolean isEnabled(String optionLabel) {
        return optionList.get(wdController.getIndex(optionList, optionLabel)).getAttribute("aria-disabled").equals("false");
    }

}