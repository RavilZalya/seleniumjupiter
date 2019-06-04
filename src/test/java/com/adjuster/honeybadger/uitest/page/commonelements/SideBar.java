/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.page.commonelements;

import com.adjuster.honeybadger.uitest.page.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public abstract class SideBar extends Element {

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'sidebar-content')]/i")
    private WebElement collapser;

    public SideBar(WebDriver driver, String containerXpath) {
        super(driver, containerXpath);
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
        return elementContainer.getAttribute("class").contains("collapsed");
    }

}
