/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.page.authentication;

import com.adjuster.honeybadger.uitest.config.PageConfig;
import com.adjuster.honeybadger.uitest.page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends Page {

    @FindBy(how = How.CSS, using = "input[formcontrolname='username']")
    private WebElement username;
    @FindBy(how = How.CSS, using = "input[formcontrolname='password']")
    private WebElement password;
    @FindBy(how = How.CSS, using = "button.fwb")
    private WebElement submit;
    @FindBy(how = How.XPATH, using = "//div[@id='googleSignIn']")
    private WebElement googleSSO;
    @FindBy(how = How.CSS, using = ".forgot-password-link")
    private WebElement forgotPassword;

    public LoginPage(WebDriver driver, PageConfig pageConfig) {
        super(driver, pageConfig);
    }

    public LoginPage setUsername(String user) {
        username.sendKeys(user);
        return this;
    }

    public LoginPage setPassword(String pswd) {
        password.sendKeys(pswd);
        return this;
    }

    public void login() {
        submit.click();
    }

    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        login();
    }

    public Page loginGoogle() {
        googleSSO.click();
        return this;
    }

    @Override
    public String getPageUrl() {
        return getBaseUrl() + "/auth/login";
    }

}
