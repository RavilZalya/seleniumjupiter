package com.adjuster.honeybadger.uitest.test.cases;

import com.adjuster.honeybadger.uitest.test.UITest;
import io.github.bonigarcia.seljup.SingleSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("This is FizBizOneTest")
@Tag("fiz") @Tag("smoke")
@SingleSession
public class FizBizOneTest extends UITest {

    @DisplayName("This is FizBizOneTest test11")
    @Test
    public void test11() {
        driver.get("https://www.politico.com/");
        System.out.println("======================================");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("======================================");
        driver.get("https://www.cnn.com/");
        System.out.println("======================================");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("======================================");
        driver.get("https://www.yahoo.com/");
        System.out.println("======================================");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("======================================");
        driver.get("http://platypus.staging.k8s.ad-juster.xyz");
        System.out.println("======================================");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("======================================");
        driver.get("https://www.ad-juster.com/");
        System.out.println("======================================");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("======================================");
    }


}
