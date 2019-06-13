package com.adjuster.hbadger.uitest.page.reports;


import com.adjuster.hbadger.uitest.config.PageConfig;
import com.adjuster.hbadger.uitest.page.Page;
import com.adjuster.hbadger.uitest.page.common.FeaturesMenu;
import com.adjuster.hbadger.uitest.page.common.Header;
import com.adjuster.hbadger.uitest.page.common.Paginator;
import com.adjuster.hbadger.uitest.page.common.Snackbar;
import com.adjuster.hbadger.uitest.page.reports.component.EditReport;
import com.adjuster.hbadger.uitest.page.reports.component.ReportPeriodDropdown;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;

public class CreateReportPage extends Page {

    private Header header;
    private FeaturesMenu featureMenu;
    private EditReport editReport;
    private Paginator paginator;

    public CreateReportPage(WebDriverController wdController, PageConfig pageConfig) {
        super(wdController, pageConfig);
        this.header = new Header(wdController);
        this.featureMenu = new FeaturesMenu(wdController);
        this.editReport = new EditReport(wdController);
    }

    public CreateReportPage andIEditTitleOfTheReport(String reportName) {
        getEditReport().editTitle(reportName);
        return this;
    }

    public CreateReportPage andISelectReportingPeriod(String timePeriod) {
        ReportPeriodDropdown reportingPeriod = getEditReport().reportingPeriod();
        reportingPeriod.selectPeriod().select(timePeriod);
        reportingPeriod.apply();
        return this;
    }

    public CreateReportPage andIMakeReportShared() {
        getEditReport().sharingYes();
        return this;
    }

    public CreateReportPage andIMakeReportPrivate() {
        getEditReport().sharingNo();
        return this;
    }

    public CreateReportPage andISelectReportingBreakout(String breakout) {
        getEditReport().reportingBreakout().select(breakout);
        return this;
    }

    public CreateReportPage andISelectDimensions(String dimension1, String dimension2) {
        getEditReport().selectDimension(dimension1).selectDimension(dimension2);
        return this;
    }

    public CreateReportPage andISelectMetrics(String metrics1, String metrics2) {
        getEditReport().selectMetrics(metrics1).selectMetrics(metrics2);
        return this;
    }

    public CreateReportPage andISetDeliveryMethodNone() {
        getEditReport().delivMethodNone();
        return this;
    }


    public Snackbar andISaveReport() {
        return getEditReport().save();
    }

    public Header getHeader() {
        return header;
    }

    public FeaturesMenu getFeatureMenu() {
        return featureMenu;
    }

    public EditReport getEditReport() {
        return editReport;
    }

    @Override
    public String getPageUrl() {
        return getBaseUrl() + "/reports/create";
    }
}
