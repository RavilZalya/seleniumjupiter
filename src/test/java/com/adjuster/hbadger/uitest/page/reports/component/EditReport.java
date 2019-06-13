package com.adjuster.hbadger.uitest.page.reports.component;


import com.adjuster.hbadger.uitest.page.Element;
import com.adjuster.hbadger.uitest.page.common.ConfirmationDialog;
import com.adjuster.hbadger.uitest.page.common.Dropdown;
import com.adjuster.hbadger.uitest.page.common.Snackbar;
import com.adjuster.hbadger.uitest.page.common.Toggles;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class EditReport extends Element {

    private final By reportTitle = By.xpath("//div[@class='col page-title']");
    //private final By editingTitleToggle = By.xpath("//div[@class='report-title']/h1/i");

    @FindBy(how = How.XPATH, using = "//div[@class='report-title']/h1/i")
    private WebElement editingTitleToggle;

    /*private final By inputReportName = By.xpath("//div[@class='report-title']/.//input[@name='name']/.");*/
    @FindBy(how = How.XPATH, using = "//div[1]/div[1]/div/span/input")
    private WebElement inputReportName;
    @FindBy(how = How.XPATH, using = "//div[@class='report-settings']/div/div[1]/div/div")
    private WebElement reportingPeriod;
    @FindBy(how = How.XPATH, using = "//mat-select[@name='breakout']")
    private WebElement reportingBreakout;
    @FindBy(how = How.XPATH, using = "//div[@class='report-settings']/div/div[3]/div/div[1]")
    private WebElement headerYes;
    @FindBy(how = How.XPATH, using = "//div[@class='report-settings']/div/div[3]/div/div[2]")
    private WebElement headerNo;
    @FindBy(how = How.XPATH, using = "//div[@class='report-settings']/div/div[4]/div/div[1]")
    private WebElement sharingYes;
    @FindBy(how = How.XPATH, using = "//div[@class='report-settings']/div/div[4]/div/div[2]")
    private WebElement sharingNo;

    @FindBy(how = How.XPATH, using = "//div[@id='dataSetSummaryDimensions']")
    private WebElement dimensionsContainer; //div  ng-reflect-message
    @FindBy(how = How.XPATH, using = "//div[@id='dataSetSummaryMetrics']")
    private WebElement metricsContainer; //div ng-reflect-message

    @FindBy(how = How.XPATH, using = "//div[@class='report-scheduling']/div[1]/div/div[1]")
    private WebElement delivFormatXls;
    @FindBy(how = How.XPATH, using = "//div[@class='report-scheduling']/div[1]/div/div[2]")
    private WebElement delivFormatCsv;
    @FindBy(how = How.XPATH, using = "//div[@class='report-scheduling']/div[1]/div/div[3]/input/.")
    private WebElement delivFormatSeparator;

    @FindBy(how = How.XPATH, using = "//div[@class='report-scheduling']/div[2]/div/div[1]")
    private WebElement delivMethodNone;
    @FindBy(how = How.XPATH, using = "//div[@class='report-scheduling']/div[2]/div/div[2]")
    private WebElement delivMethodEmail;
    @FindBy(how = How.XPATH, using = "//div[@class='report-scheduling']/.//input[@id='emailReportList']/.")
    private WebElement delivMethodEmailInput;
    @FindBy(how = How.XPATH, using = "//div[@class='report-scheduling']/div[2]/div/div[3]")
    private WebElement delivMethodS3;
    @FindBy(how = How.XPATH, using = "//div[@class='report-scheduling']/div[4]/div/div[1]/input/.")
    private WebElement delivMethodS3Input1;
    @FindBy(how = How.XPATH, using = "//div[@class='report-scheduling']/div[4]/div/div[2]/input/.")
    private WebElement delivMethodS3Input2;

    @FindBy(how = How.XPATH, using = "//div[@class='report-scheduling']/.//div[@class='cron-scheduler-container']/mat-form-field")
    private WebElement frequency;

    @FindBy(how = How.XPATH, using = "//div[@class='report-footer']/span/.")
    private WebElement undo;
    @FindBy(how = How.XPATH, using = "//div[@class='report-footer']/button/*")
    private WebElement save;
    @FindBy(how = How.XPATH, using = "//div[@class='col page-title']/h1/a")
    private WebElement goBack;

    public EditReport(WebDriverController wdController) {
        super(wdController, "//div[@id='reportContainer']");
    }

    public String getReportTitle() {
        return wdController.findVisibleElement(reportTitle).getText();
    }

    public EditReport editTitle(String reportName) {
        editingTitleToggle.click();
        inputReportName.sendKeys(Keys.CONTROL, "a");
        inputReportName.sendKeys(Keys.DELETE);
        inputReportName.sendKeys(reportName);
        return this;
    }

    public ReportPeriodDropdown reportingPeriod() {
        wdController.findClickableElement(reportingPeriod).click();
        return new ReportPeriodDropdown(wdController);
    }

    public Dropdown reportingBreakout() {
        wdController.findClickableElement(reportingBreakout).click();
        return new Dropdown(wdController);
    }

    public EditReport headerYes() {
        wdController.findClickableElement(headerYes).click();
        return this;
    }

    public EditReport headerNo() {
        wdController.findClickableElement(headerNo).click();
        return this;
    }

    public EditReport sharingYes() {
        wdController.findClickableElement(sharingYes).click();
        return this;
    }

    public EditReport sharingNo() {
        wdController.findClickableElement(sharingNo).click();
        return this;
    }

    public EditReport selectDimension(String dimension) {
        List<WebElement> list = wdController.findNestedElements(dimensionsContainer, By.xpath("./div"));
        wdController.getAction().doubleClick(list.get(wdController.getIndex(list, dimension))).perform();
        return this;
    }

    public EditReport selectMetrics(String metrics) {
        List<WebElement> list = wdController.findNestedElements(metricsContainer, By.xpath("./div"));
        wdController.getAction().doubleClick(list.get(wdController.getIndex(list, metrics))).perform();
        return this;
    }

    public EditReport delivFormatXls() {
        wdController.findClickableElement(delivFormatXls).click();
        return this;
    }

    public EditReport delivFormatCsv() {
        wdController.findClickableElement(delivFormatCsv).click();
        return this;
    }

    public EditReport delivFormatSeparator(String reportName) {
        wdController.findClickableElement(delivFormatSeparator).clear();
        wdController.findClickableElement(delivFormatSeparator).sendKeys(reportName);
        return this;
    }

    public EditReport delivMethodNone() {
        wdController.findClickableElement(delivMethodNone).click();
        return this;
    }

    public EditReport delivMethodEmail() {
        wdController.findClickableElement(delivMethodEmail).click();
        return this;
    }

    public EditReport delivMethodEmailInput(String reportName) {
        wdController.findClickableElement(delivMethodEmailInput).clear();
        wdController.findClickableElement(delivMethodEmailInput).sendKeys(reportName);
        return this;
    }


    public EditReport delivMethodS3() {
        wdController.findClickableElement(delivMethodS3).click();
        return this;
    }

    public EditReport delivMethodS3Input1(String reportName) {
        wdController.findClickableElement(delivMethodS3Input1).clear();
        wdController.findClickableElement(delivMethodS3Input1).sendKeys(reportName);
        return this;
    }

    public EditReport delivMethodS3Input2(String reportName) {
        wdController.findClickableElement(delivMethodS3Input2).clear();
        wdController.findClickableElement(delivMethodS3Input2).sendKeys(reportName);
        return this;
    }

    public EditReport scheduleToggle(boolean state) {
        Toggles toggle = new Toggles(wdController, "//div[@class='report-scheduling']/h3[2]");
        toggle.setToggle("enableScheduleReport", state);
        return this;
    }

    public Dropdown frequency() {
        wdController.findClickableElement(frequency).click();
        return new Dropdown(wdController);
    }

    public EditReport undo() {
        wdController.findClickableElement(undo).click();
        return this;
    }

    public Snackbar save() {
        wdController.findClickableElement(save).click();
        return new Snackbar(wdController);
    }

    public ConfirmationDialog goBack() {
        wdController.findClickableElement(goBack).click();
        return new ConfirmationDialog(wdController);
    }


}
