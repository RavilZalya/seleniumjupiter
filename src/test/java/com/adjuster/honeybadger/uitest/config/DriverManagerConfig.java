/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestPropertySource;


@Component
@PropertySource("classpath:application.properties")
public class DriverManagerConfig {

    private String browser;
    private boolean headless;
    private String chromeVersion;
    private String firefoxVersion;

    @Autowired
    public DriverManagerConfig(@Value("${drivermanager.browser}") String browser,
                               @Value("${drivermanager.headless}") boolean headless,
                               @Value("${drivermanager.chrome.browser.version}") String chromeVersion,
                               @Value("${drivermanager.firefox.browser.version}") String firefoxVersion) {
        this.browser = browser;
        this.headless = headless;
        this.chromeVersion = chromeVersion;
        this.firefoxVersion = firefoxVersion;
    }

    public String getBrowser() {
        return browser;
    }

    public boolean isHeadless() {
        return headless;
    }

    public String getChromeVersion() {
        return chromeVersion;
    }

    public String getFirefoxVersion() {
        return firefoxVersion;
    }
}
