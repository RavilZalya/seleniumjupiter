package com.adjuster.honeybadger.uitest.test.cases;

import com.adjuster.honeybadger.uitest.test.UITest;
import io.github.bonigarcia.seljup.SingleSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@SingleSession
@DisplayName("This is Test2Class")
@Tag("fiz") @Tag("biz") @Tag("smoke")
public class Test3Class extends UITest {


    @DisplayName("This is Test2Class test11")
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
        driver.get("http://localhost:4200/");
        System.out.println("======================================");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("======================================");
        driver.get("http://172.17.0.1:32799/wd/hub");
        System.out.println("======================================");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("======================================");
        driver.get("http://172.17.0.1:32799");
        System.out.println("======================================");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("======================================");
        driver.get("http://172.17.0.1:4200");
        System.out.println("======================================");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("======================================");
        driver.get("http://172.17.0.1");
        System.out.println("======================================");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("======================================");
    }

    @DisplayName("This is Test2Class test12")
    @Test
    public void test1() {
        driver.get("https://www.yandex.ru/");
        System.out.println("======================================");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("======================================");
        driver.get("https://www.rambler.ru/");
        System.out.println("======================================");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("======================================");
        driver.get("https://www.yahoo.com/");
        System.out.println("======================================");

    }

}
