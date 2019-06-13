package com.adjuster.hbadger.uitest.page.common;

import com.adjuster.hbadger.uitest.page.Element;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Base class for a tab selector. .
 */
public class TabSelector extends Element {

    @FindBy(how = How.XPATH, using = ".//div")
    protected List<WebElement> tabs;

    public TabSelector(WebDriverController wdController) {
        super(wdController, "//mat-tab-labels");
    }

    /**
     * Select and naviagte to tab.
     */
    public void select(String tab) {
        if (isEnabled(tab) && !isSelected(tab)) {
            tabs.get(wdController.getIndex(tabs, tab)).click();
        }
    }

    /**
     * Checks if tab is selected.
     */
    private boolean isSelected(String tab) {
        return tabs.get(wdController.getIndex(tabs, tab)).getAttribute("aria-selected").equals("false");
    }

    /**
     * Checks if tab is enabled.
     */
    private boolean isEnabled(String tab) {
        return tabs.get(wdController.getIndex(tabs, tab)).getAttribute("aria-disabled").equals("false");
    }

}