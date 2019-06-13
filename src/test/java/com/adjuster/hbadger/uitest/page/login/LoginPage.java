/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.page.login;

import com.adjuster.hbadger.uitest.config.PageConfig;
import com.adjuster.hbadger.uitest.page.Page;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends Page {

    private WebDriverController wdController;
    private String url = "/auth/login";
    private String expectedLoginYourAccountText = "Login to your account";
    private String expectedFooterText1 = "© 2019 Ad-Juster, Inc. All Rights Reserved.";
    private String expectedFooterText2 = "13280 Evening Creek S. Ste 100 | San Diego, California 92128";
    private String expectedEmailRequiredErrorMessage = "Email is required";
    private String expectedEmailMissingCharErrorMessage = "The email address must contain at least the @ character";
    private String expectedPasswordRequiredErrorMessage = "Password is required";
    private String expectedPasswordLengthErrorMessage = "Password must be 4 characters long";

    @FindBy(xpath = "//*[@formcontrolname='username']")
    WebElement usernameTextbox;

    @FindBy(xpath = "//*[@formcontrolname='password']")
    WebElement passwordTextbox;

    @FindBy(xpath = "//*[text()=' Login ']")
    WebElement loginButton;

    @FindBy(xpath = "//*[contains(@class,'login-form-item')][1]//*[contains(@class,'form-control-feedback')]/p")
    WebElement emailErrorMessage;

    @FindBy(xpath = "//*[contains(@class,'login-form-item')][2]//*[contains(@class,'form-control-feedback')]/p")
    WebElement passwordErrorMessage;

    @FindBy(xpath = "//*[@class = 'aj-logo']/img")
    WebElement logo;

    @FindBy(xpath = "//*[contains(@class, 'welcome-back')]/span")
    WebElement welcomeBackText;

    @FindBy(id = "googleSignIn")
    WebElement singWithGoogleButton;

    @FindBy(xpath = "//*[text() = 'Forgot password?']")
    WebElement forgotPasswordLink;

    @FindBy(xpath = "//*[@class='login-text']")
    WebElement loginToYourAccountText;

    @FindBy(xpath = "//*[contains(@class,'login-footer')]")
    WebElement footer;


    public LoginPage(WebDriverController wdController, PageConfig pageConfig) {
        super(wdController, pageConfig);
    }

    //public ReportsPage login(String email, String password) {
    //    wdController.wait(usernameTextbox);
    //    usernameTextbox.sendKeys(email);
    //    passwordTextbox.sendKeys(password);
    //    loginButton.click();
    //    return null;
    //}

    public LoginPage whenUsernameTextboxVisible() {

        wdController.wait(usernameTextbox);
        return this;
    }

    public LoginPage enterUsername(String username) {

        usernameTextbox.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {

        passwordTextbox.sendKeys(password);
        return this;
    }

    ////RZ: 0609
    public void login() {
        loginButton.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        login();
    }

    //public ReportsPage login() {
    //    loginButton.click();
    //    return PageFactory.initElements(wdController.getDriver(), ReportsPage.class);
    //}

    public void loginWithBadCredentials() {
        loginButton.click(); //should return some warning mesage instead?
        //return PageFactory.initElements(wdController.getDriver(), LoginPage.class);
    }

    public boolean verifyEmailRequiredErrorMessage() {

        return expectedEmailRequiredErrorMessage.equals(emailErrorMessage.getText());
    }

    public boolean verifyPasswordRequiredErrorMessage() {

        return expectedPasswordRequiredErrorMessage.equals(passwordErrorMessage.getText());
    }

    public boolean verifyAtSymbolRequiredErrorMessage() {

        return expectedEmailMissingCharErrorMessage.equals(emailErrorMessage.getText());
    }

    public boolean verifyPasswordLengthErrorMessage() {

        return expectedPasswordLengthErrorMessage.equals(passwordErrorMessage.getText());
    }

    public boolean usernameTextboxIsDisplayed() {
        return usernameTextbox.isDisplayed();
    }

    public boolean usernameTextboxIsEnabled() {
        return usernameTextbox.isEnabled();
    }

    public boolean passwordTextboxIsDisplayed() {
        return passwordTextbox.isDisplayed();
    }

    public boolean passwordTextboxIsEnabled() {
        return passwordTextbox.isEnabled();
    }

    public boolean loginButtonIsDisplayed() {
        return loginButton.isDisplayed();
    }

    public boolean loginButtonIsEnabled() {
        return loginButton.isEnabled();
    }

    public boolean singWithGoogleButtonIsDisplayed() {
        return singWithGoogleButton.isDisplayed();
    }

    public boolean singWithGoogleButtonIsEnabled() {
        return singWithGoogleButton.isEnabled();
    }

    public boolean logoIsDisplayed() {
        return logo.isDisplayed();
    }

    public boolean welcomeBackTextIsDisplayed() {
        return welcomeBackText.isDisplayed();
    }

    public boolean forgotPasswordLinkIsDisplayed() {
        return forgotPasswordLink.isDisplayed();
    }

    public boolean forgotPasswordLinkIsEnabled() {
        return forgotPasswordLink.isEnabled();
    }

    public boolean verifyLoginToYourAccountText() {
        return loginToYourAccountText.getText().equals(expectedLoginYourAccountText);
    }

    public boolean verifyFooterText() {

        String footerText = footer.getAttribute("textContent");
        return footerText.contains(expectedFooterText1) && footerText.contains(expectedFooterText2);
    }

    @Override
    public String getPageUrl() {
        return getBaseUrl() + "/auth/login";
    }

}
