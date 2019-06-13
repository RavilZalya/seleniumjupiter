package com.adjuster.hbadger.uitest.page.reports.component;


import com.adjuster.hbadger.uitest.page.common.ConfirmationDialog;
import com.adjuster.hbadger.uitest.page.common.Table;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.By;

public class ReportsTable extends Table {

    private final By expandRowToggle = By.xpath(".//div[@class='row-toggle']");
    private final By reportName = By.xpath(".//div[@class='report-name']/div/a");
    private final By runReport = By.xpath(".//i[1]");
    private final By shareReport = By.xpath(".//i[2]");
    private final By deleteReport = By.xpath(".//i[3]");

    public ReportsTable(WebDriverController wdController) {
        super(wdController);
    }


    /**
     * Click to open report.
     */
    public void openReport(String rpName) {
        int index = wdController.getIndex(getColumnCellElements("Name"), rpName);
        getColumnCellElements("Name").get(index).findElement(reportName).click();
    }

    /**
     * Click to run report.
     */
    public void runReport(String rpName) {
        int index = wdController.getIndex(getColumnCellElements("Name"), rpName);
        getColumnCellElements("Actions").get(index).findElement(runReport).click();
    }

    /**
     * Click to share report.
     */
    public ConfirmationDialog deleteReport(String rpName) {
        int index = wdController.getIndex(getColumnCellElements("Name"), rpName);
        getColumnCellElements("Actions").get(index).findElement(deleteReport).click();
        return new ConfirmationDialog(wdController);
    }

    /**
     * Click to share report.
     */
    public ConfirmationDialog shareReport(String rpName) {
        int index = wdController.getIndex(getColumnCellElements("Name"), rpName);
        getColumnCellElements("Actions").get(index).findElement(shareReport).click();
        return new ConfirmationDialog(wdController);
    }

    /**
     * Click to expand report rows.
     */
    public void expandReportRows(String column, String cell) {
        int index = wdController.getIndex(getColumnCellElements(column), cell);
        getColumnCellElements(column).get(index).findElement(expandRowToggle).click();
    }

    /**
     * Represents a By locator for a cells of a given column. This needs to be dynamically modified by adding array index.
     * Returns a locator which is used in getCellsForAColumn(int columnIdx).
     */
    @Override
    protected By column(int columnIdx) {
        return By.xpath("//div[@class='data-table']/cdk-table/cdk-row/cdk-cell[" + (columnIdx + 1) + "][contains(@class,'cdk-column-')][not(contains(@class,'expandedDetail'))]");
    }

}
