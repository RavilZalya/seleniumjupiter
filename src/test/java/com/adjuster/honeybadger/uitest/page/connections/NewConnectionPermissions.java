/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.page.connections;

import com.adjuster.honeybadger.uitest.page.commonelements.DialogNavigable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewConnectionPermissions extends DialogNavigable {

    @FindBy(how = How.XPATH, using = "(//input)[3]")
    private WebElement input1;
    @FindBy(how = How.XPATH, using = "(//input)[4]")
    private WebElement input2;
    @FindBy(how = How.XPATH, using = "(//input)[5]")
    private WebElement input3;
    @FindBy(how = How.XPATH, using = "(//input)[6]")
    private WebElement input4;

    public NewConnectionPermissions(WebDriver driver) {
        super(driver, "//div[contains(@class,'add-connection-container')]");
    }

    public NewConnectionPermissions andIEnterConnectionParameters(String param1, String param2, String param3, String param4) {
        setInput1(param1)
                .setInput2(param2)
                .setInput3(param3)
                .setInput4(param4);
        return this;
    }

    public boolean buttonNextIsEnabled() {
        return super.rightButtonIsEnabled();
    }

    public NewConnectionReview clickButtonNext() {
        submitRightButton();
        return new NewConnectionReview(driver);
    }

    public NewConnectionDetails clickButtonBack() {
        submitLeftButton();
        return new NewConnectionDetails(driver);
    }

    /**
     * Input for field 'Connection Name'.
     */
    public NewConnectionPermissions setInput1(String input_1) {
        if (input_1 == null) {
            return this;
        } else {
            input1.clear();
            input1.sendKeys(input_1);
            return this;
        }
    }

    public NewConnectionPermissions setInput2(String input_2) {
        if (input_2 == null) {
            return this;
        } else {
            input2.clear();
            input2.sendKeys(input_2);
            return this;
        }
    }

    public NewConnectionPermissions setInput3(String input_3) {
        if (input_3 == null) {
            return this;
        } else {
            input3.clear();
            input3.sendKeys(input_3);
            return this;
        }
    }

    public NewConnectionPermissions setInput4(String input_4) {
        if (input_4 == null) {
            return this;
        } else {
            input4.clear();
            input4.sendKeys(input_4);
            return this;
        }
    }

    @Override
    public boolean isDisplayed() {
        return getHeader().contains("Step 2: Connection Permissions");
    }

}
