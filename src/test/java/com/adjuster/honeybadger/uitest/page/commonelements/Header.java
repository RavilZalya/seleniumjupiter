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

public class Header extends Element {

    @FindBy(how = How.XPATH, using = ".//div/app-user-widget/div[1]/div/div[2]/div[1]")
    private WebElement userProfileEmail;
    @FindBy(how = How.XPATH, using = ".//div/app-user-widget/div[1]/div/div[2]/div[2]")
    private WebElement userProfileName;
    @FindBy(how = How.XPATH, using = ".//div/app-user-widget/div[1]/div/div[1]/i")
    private WebElement notificationsBell;
    @FindBy(how = How.XPATH, using = ".//div[contains(@class,'user-widget')]/div/div[3]")
    private WebElement userMenuToggle;
    @FindBy(how = How.CSS, using = "div.header-content")
    private WebElement userMode;
    @FindBy(how = How.XPATH, using = "//div[@class='header-content impersonating']/div[1]/button")
    private WebElement exitImpersonation;

    public Header(WebDriver driver) {
        super(driver, "//div[@class='header-container']");
    }

    public String getEmail() {
        return userProfileEmail.getText();
    }

    public String getName() {
        return userProfileName.getText();
    }

    public NotificationsMenu expandNotifications() {
        notificationsBell.click();
        return new NotificationsMenu(driver);
    }

    public void getUserMenu() {
        userMenuToggle.click(); //TODO: to return UserMenuDropdown
    }

    public boolean isImpersonating() {
        return userMode.getAttribute("class").contains("impersonating");
    }

    public void exitImpersonation() {
        exitImpersonation.click();//TODO: consider combining with validating isInRegularMode
    }

}
