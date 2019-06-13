package com.adjuster.hbadger.uitest.page.reports.component;

import com.adjuster.hbadger.uitest.page.Element;
import com.adjuster.hbadger.uitest.page.common.Dropdown;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ReportPeriodDropdown extends Element {

    @FindBy(how = How.XPATH, using = "//mat-select[@aria-label='Select reporting period']")
    WebElement selectPeriod;
    @FindBy(how = How.XPATH, using = "//*[contains(@class,'aj-link')][contains(text(),'Clear')]")
    WebElement clear;
    @FindBy(how = How.XPATH, using = "//*[contains(@class,'aj-link')][contains(text(),'Apply')]")
    WebElement apply;

    public ReportPeriodDropdown(WebDriverController wdController) {
        super(wdController, "//app-column-filter/form | //app-field-filter/div");
    }

    public Dropdown selectPeriod() {
        wdController.findClickableElement(selectPeriod).click();
        return new Dropdown(wdController);
    }

    public void clear() {
        wdController.findClickableElement(clear).click();
    }

    public void apply() {
        wdController.findClickableElement(apply).click();
    }
}
