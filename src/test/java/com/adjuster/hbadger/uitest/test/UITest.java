/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.test;

import com.adjuster.hbadger.uitest.UITestContext;
import com.adjuster.hbadger.uitest.config.PageConfig;
import com.adjuster.hbadger.uitest.config.TestParams;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import io.github.bonigarcia.seljup.Arguments;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith({SpringExtension.class, SeleniumExtension.class})
@Import(UITestContext.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class UITest {

    @Autowired
    private PageConfig config;
    protected WebDriverController wdController;
    protected TestParams testParams;

    private static final Logger LOG = LoggerFactory.getLogger(UITest.class);

    public UITest(TestParams testParams) {
        this.testParams = testParams;
    }


    @BeforeAll
    void genericDriverTest(@Arguments("--start-maximized") WebDriver webDriver) {
        wdController = new WebDriverController(webDriver);
        wdController.navigate(config.getBaseUrl());
    }

    @AfterAll
    protected void tearDownClass() {
        wdController.quitDriver();
    }

    public PageConfig getConfig() {
        return config;
    }

}
