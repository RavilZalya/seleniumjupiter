/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.test;


import com.adjuster.hbadger.uitest.config.TestParams;
import com.adjuster.hbadger.uitest.page.homepage.HomePage;
import com.adjuster.hbadger.uitest.page.login.LoginPage;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthenticatedTest extends UITest {

    private static final Logger LOG = LoggerFactory.getLogger(AuthenticatedTest.class);

    protected HomePage givenIAmAtHomePage;

    public AuthenticatedTest(TestParams testParams) {
        super(testParams);
    }

    @BeforeAll
    public void login() {
        //TODO find a way to check if already login or create a logintest class for login
        LOG.info("Logging into system using valid credentials: username {}, password {}", testParams.get("username"), testParams.get("password"));
        LoginPage loginPage = new LoginPage(wdController, getConfig());
        loginPage.login(testParams.get("username"), testParams.get("password"));
        givenIAmAtHomePage = new HomePage(wdController, getConfig());
    }

}
