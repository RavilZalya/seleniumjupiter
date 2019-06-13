/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


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
    public PageConfig(@Value("${platypus.base.url}") String url) {
        this.url = url;
    }

    public String getBaseUrl() {
        return url;
    }
}
