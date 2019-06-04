package com.adjuster.honeybadger.uitest.test.cases;

import com.adjuster.honeybadger.uitest.test.UITest;
import io.github.bonigarcia.seljup.SingleSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@SingleSession
@DisplayName("This is Test2Class")
@Tag("fiz") @Tag("biz")
public class TestClass extends UITest {

    @DisplayName("This is TestClass test21")
    @Test
    public void test21() {
        driver.get("https://fishki.net/");
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

    @DisplayName("This is Test2Class test22")
    @Test
    public void test1() {
        driver.get("https://www.gazeta.ru/");
        System.out.println("======================================");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("======================================");
        driver.get("https://echo.msk.ru/");
        System.out.println("======================================");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("======================================");
        driver.get("https://www.youtube.com/");
        System.out.println("======================================");

    }

}
