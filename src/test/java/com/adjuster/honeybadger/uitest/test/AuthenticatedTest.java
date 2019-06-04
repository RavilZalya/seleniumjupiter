package com.adjuster.honeybadger.uitest.test;

import com.adjuster.honeybadger.uitest.page.authentication.LoginPage;
import com.adjuster.honeybadger.uitest.page.homepage.HomePage;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthenticatedTest extends UITest {

    private static final Logger LOG = LoggerFactory.getLogger(AuthenticatedTest.class);

    protected HomePage givenIAmAtHomePage;

    @BeforeAll
    public void login() {
        //TODO find a way to check if already login or create a logintest class for login
        LOG.info("Logging into system using valid credentials: username {}, password {}", getConfig().getUsername(), getConfig().getPassword());
        LoginPage loginPage = new LoginPage(driver, getConfig());
        loginPage.login(getConfig().getUsername(), getConfig().getPassword());  //login using valid creds
        givenIAmAtHomePage = new HomePage(driver, getConfig());
    }

}
