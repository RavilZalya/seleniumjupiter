/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.test;

import com.adjuster.honeybadger.uitest.UITestContext;
import com.adjuster.honeybadger.uitest.config.PageConfig;
import io.github.bonigarcia.seljup.Arguments;
import io.github.bonigarcia.seljup.BrowserType;
import io.github.bonigarcia.seljup.DockerBrowser;
import io.github.bonigarcia.seljup.DriverCapabilities;
import io.github.bonigarcia.seljup.DriverUrl;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith({SeleniumExtension.class})
@Import(UITestContext.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class UITest {

    //@Autowired
    //private PageConfig config;

    private PageConfig config = new PageConfig("http://localhost:4200",25,"ext1001@example.com","P@ssword11");

    private static final Logger LOG = LoggerFactory.getLogger(UITest.class);
    protected WebDriver driver;


    @BeforeAll
    void genericDriverTest(WebDriver webDriver) {
    //void genericDriverTest(@DockerBrowser(type= BrowserType.CHROME, version="72.0") @DriverUrl("http://172.17.0.1:32798/wd/hub") @DriverCapabilities("browserName=chrome") RemoteWebDriver webDriver) {
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
