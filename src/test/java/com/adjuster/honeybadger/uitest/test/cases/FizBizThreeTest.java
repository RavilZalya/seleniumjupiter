/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.test.cases;

import com.adjuster.honeybadger.uitest.test.UITest;
import io.github.bonigarcia.seljup.SingleSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@SingleSession
@DisplayName("This is FizBizOneTest")
@Tag("fiz") @Tag("biz")
public class FizBizThreeTest extends UITest {

    @DisplayName("This is FizBizThreeTest test21")
    @Test
    public void test21() {
        driver.get("https://www.facebook.com/");
        System.out.println("======================================");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("======================================");
        driver.get("https://www.cnn.com/");
        System.out.println("======================================");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("======================================");
        driver.get("https://www.wikipedia.org/");
        System.out.println("======================================");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("======================================");

    }

    @DisplayName("This is FizBizOneTest test22")
    @Test
    public void test1() {
        driver.get("https://www.amazon.com/");
        System.out.println("======================================");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("======================================");
        driver.get("https://echo.msk.ru/");
        System.out.println("======================================");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("======================================");
        driver.get("https://www.netflix.com/");
        System.out.println("======================================");

    }

}
