/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.common;

import com.adjuster.hbadger.uitest.page.Element;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Represents a paginator present on some pages. Provides information about total and currently displayed items.
 * Enables to change setting for a number of items to be displayed. Enables to page through the pages.
 */
public class Paginator extends Element {

    @FindBy(how = How.XPATH, using = "//div[@class='mat-paginator-container']/div[1]/mat-form-field/div")
    private WebElement itemsToggle;
    @FindBy(how = How.XPATH, using = "//div[@class='mat-select-value']/span")
    private WebElement itemsValue;
    @FindBy(how = How.XPATH, using = "//div[@class='mat-paginator-range-label']")
    private WebElement pageRange;
    @FindBy(how = How.XPATH, using = "//div[@class='mat-paginator-range-actions']/button[1]")
    private WebElement previous;
    @FindBy(how = How.XPATH, using = "//div[@class='mat-paginator-range-actions']/button[2]")
    private WebElement next;


    public Paginator(WebDriverController wdController) {
        super(wdController, "//div[@class='mat-paginator-container']");
    }

    /**
     * Opens 'Items per page' dropdown.
     */
    public Dropdown openItemsPerPageDropdown() {
        itemsToggle.click();
        return new Dropdown(wdController);
    }

    /**
     * Click next page element.
     */
    public void next() {
        if (nextIsEnabled()) {
            next.click();
        }
    }

    /**
     * Click previsou page element.
     */
    public void previous() {
        if (prevIsEnabled()) {
            previous.click();
        }
    }

    /**
     * Gets value for 'Items per page' dropdown.
     */
    public int itemsPerPage() {
        return Integer.parseInt((itemsValue.getText()));
    }

    /**
     * Checks Next button is enabled.
     */
    private boolean nextIsEnabled() {
        return next.isEnabled();
    }

    /**
     * Checks Previous button is enabled.
     */
    private boolean prevIsEnabled() {
        return previous.isEnabled();
    }


}
