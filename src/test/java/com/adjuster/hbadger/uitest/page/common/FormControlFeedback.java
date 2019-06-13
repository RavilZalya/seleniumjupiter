package com.adjuster.hbadger.uitest.page.common;

import com.adjuster.hbadger.uitest.page.Element;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FormControlFeedback extends Element {

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'form-control-feedback')]")
    private WebElement message;

    public FormControlFeedback(WebDriverController wdController, String containerXpath) {
        super(wdController, containerXpath);
    }

    /**
     * Gets the text message.
     */
    public String getMessage() {
        return message.getText();
    }

}
