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

/**
 * Represents standard searchbar.
 */
public class Searchbar extends Element {

    @FindBy(how = How.XPATH, using = "//input[contains(@class,'icon search')]")
    private WebElement search;
    @FindBy(how = How.XPATH, using = "//span[contains(@class,'add-new')]")
    private WebElement addNew;

    public Searchbar(WebDriverController wdController) {
        super(wdController, "//div[contains(@class,'-filter data-table-header')]");
    }

    /**
     * Sends string parameter to a searchbar. Subclass will impelemnt method that will return a new table object table object.
     */
    public void search(String text) {
        search.sendKeys(text);
    }

    /**
     * Opens a dialog to create new entity. Subclass will impelemnt method that will return a dialog.
     */
    public void addNew() {
        addNew.click();
    }

}

