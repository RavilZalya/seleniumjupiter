/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestPropertySource;


@Component
@PropertySource("classpath:application.properties")
public class PageConfig {

    private String url;
    private int waitTimeOut;
    private String username;
    private String password;

    public PageConfig() {
    }

    @Autowired
    public PageConfig(@Value("${platypus.base.url}") String url,
                      @Value("${driver.wait.timeout.inSeconds}") int waitTimeOut,
                      @Value("${user.name.external}") String username,
                      @Value("${user.password.external}") String password) {

        this.url = url;
        this.waitTimeOut = waitTimeOut;
        this.username = username;
        this.password = password;
    }

    public int getWaitTimeOut() {
        return waitTimeOut;
    }

    public String getBaseUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
