/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest;

import com.adjuster.honeybadger.uitest.config.DriverManagerConfig;
import com.adjuster.honeybadger.uitest.config.PageConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@ComponentScan(basePackageClasses = UITestContext.class)
@Import({PageConfig.class, DriverManagerConfig.class})
public class UITestContext {

}
