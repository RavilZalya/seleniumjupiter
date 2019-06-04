/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.page.commonelements;

import com.adjuster.honeybadger.uitest.page.Element;
import org.openqa.selenium.WebDriver;

public class NotificationsMenu extends Element {

    public NotificationsMenu(WebDriver driver) {
        super(driver, "//div[contains(@class,'notification-pane-container')]");
    }

}
