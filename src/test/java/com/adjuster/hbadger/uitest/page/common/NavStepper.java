/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.common;

import com.adjuster.hbadger.uitest.page.Element;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import com.google.common.base.Preconditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Base class for a navigator bar. Navigator is present in dialogs with multiple sheets. Enables steping through the sheets.
 */
public class NavStepper extends Element {

    @FindBy(how = How.XPATH, using = "./div[2]/button")
    protected List<WebElement> nodes;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'stepper-heading')]")
    protected WebElement sheetTitle;


    public NavStepper(WebDriverController wdController) {
        super(wdController, "//div[contains(@class,'stepper-heading')]/..");
    }

    /**
     * Returns a sheet title.
     */
    public String getStepTitle() {
        return sheetTitle.getText();
    }

    /**
     * Selects a node based on index.
     */
    public void selectNode(int nodeIndex) {
        Preconditions.checkArgument(nodeIndex >= 0, "node index must be >=0");
        Preconditions.checkArgument(nodeIndex < size(), "node index must be < " + size());
        select(nodeIndex, true);
    }

    private void select(int index, boolean select) {
        if (isEnabled(index) && (isActive(index) != select)) {
            nodes.get(index).click();
        }
    }

    private boolean isActive(int nodeIdx) {
        return nodes.get(nodeIdx).getAttribute("class").contains("active");
    }

    private boolean isEnabled(int nodeIdx) {
        return nodes.get(nodeIdx).isEnabled();
    }

    private int size() {
        return nodes.size();
    }

}
