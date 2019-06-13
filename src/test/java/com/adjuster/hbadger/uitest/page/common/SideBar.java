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

public abstract class SideBar extends Element {

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'sidebar-content')]/i")
    private WebElement collapser;

    public SideBar(WebDriverController wdController, String containerXpath) {
        super(wdController, containerXpath);
    }

    public void collapse() {
        boolean isCollapsed = isCollapsed();
        if (!isCollapsed) {
            collapser.click();
        }
    }

    public void expand() {
        boolean isCollapsed = isCollapsed();
        if (isCollapsed) {
            collapser.click();
        }
    }

    public boolean isCollapsed() {
        return getElementContainer().getAttribute("class").contains("collapsed");
    }

}
