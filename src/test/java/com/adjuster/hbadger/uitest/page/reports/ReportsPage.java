package com.adjuster.hbadger.uitest.page.reports;


import com.adjuster.hbadger.uitest.config.PageConfig;
import com.adjuster.hbadger.uitest.page.Page;
import com.adjuster.hbadger.uitest.page.common.ChooseDatasetDialog;
import com.adjuster.hbadger.uitest.page.common.Paginator;
import com.adjuster.hbadger.uitest.page.common.Snackbar;
import com.adjuster.hbadger.uitest.page.reports.component.ReportsSearchbar;
import com.adjuster.hbadger.uitest.page.reports.component.ReportsTable;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;

public class ReportsPage extends Page {

    private ReportsSearchbar searchbar;
    private Paginator paginator;
    private ReportsTable table;

    public ReportsPage(WebDriverController wdController, PageConfig pageConfig) {
        super(wdController, pageConfig);
        this.table = new ReportsTable(wdController);
        this.searchbar = new ReportsSearchbar(wdController);
        this.paginator = new Paginator(wdController);
    }

    public CreateReportPage iStartCreatingNewReportAndChooseDataset(String datasetName) {
        getSearchbar().addNew();
        ChooseDatasetDialog chooseDataset = new ChooseDatasetDialog(wdController);
        chooseDataset.select(datasetName).submitLeftButton();
        return new CreateReportPage(wdController, getPageConfig());
    }

    public CreateReportPage iOpenReportForEditing(String reportName) {
        getTable().openReport(reportName);
        return new CreateReportPage(wdController, getPageConfig());
    }

    public Snackbar iDeleteAReport(String reportName) {
        getTable().deleteReport(reportName).submitRightButton();
        return new Snackbar(wdController);
    }

    public ReportsSearchbar getSearchbar() {
        return searchbar;
    }

    public Paginator getPaginator() {
        return paginator;
    }

    public ReportsTable getTable() {
        return table;
    }

    @Override
    public String getPageUrl() {
        return getBaseUrl() + "/reports";
    }
}
