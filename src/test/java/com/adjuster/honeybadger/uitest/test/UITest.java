/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.test;

import com.adjuster.honeybadger.uitest.UITestContext;
import com.adjuster.honeybadger.uitest.config.PageConfig;
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

    private static final Logger LOG = LoggerFactory.getLogger(UITest.class);
    protected WebDriver driver;

    @BeforeAll
    void genericDriverTest(@Arguments("--start-maximized") WebDriver webDriver) {
        driver = webDriver;
        driver.get(config.getBaseUrl());
    }

    @AfterAll
    protected void tearDownClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    public PageConfig getConfig() {
        return config;
    }

}
