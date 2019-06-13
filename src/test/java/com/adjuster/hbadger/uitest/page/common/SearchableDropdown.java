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

public class SearchableDropdown extends Element {

    @FindBy(how = How.XPATH, using = ".//div[contains(@class,'aj-checkbox')]")
    private List<WebElement> options;
    @FindBy(how = How.XPATH, using = "//div[@class='filter-search']/span/input")
    private WebElement search;
    @FindBy(how = How.XPATH, using = "//*[contains(@class,'aj-link')][contains(text(),'Clear')]")
    private WebElement clear;
    @FindBy(how = How.XPATH, using = "//*[contains(@class,'aj-link')][contains(text(),'Apply')]")
    private WebElement apply;


    public SearchableDropdown(WebDriverController wdController) {
        super(wdController, "//app-column-filter/form | //app-field-filter/div");
    }

    public SearchableDropdown search(String text) {
        search.sendKeys(text);
        return this;
    }

    /**
     * Select an option.
     */
    public SearchableDropdown select(String optionLabel, boolean select) {
        if (isEnabled(optionLabel) && (isSelected(optionLabel) != select)) {
            options.get(wdController.getIndex(options, optionLabel)).click();
        }
        return this;
    }

    /**
     * Click button Clear.
     */
    public void clear() {
        clear.click();
    }

    /**
     * Click button Apply.
     */
    public void apply() {
        apply.click();
    }

    private boolean isSelected(String optionLabel) {
        return options.get(wdController.getIndex(options, optionLabel)).isSelected();
    }

    private boolean isEnabled(String optionLabel) {
        return options.get(wdController.getIndex(options, optionLabel)).isEnabled();
    }

}
