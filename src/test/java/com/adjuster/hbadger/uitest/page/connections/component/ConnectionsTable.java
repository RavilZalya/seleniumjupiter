package com.adjuster.hbadger.uitest.page.connections.component;


import com.adjuster.hbadger.uitest.page.common.Table;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.By;

public class ConnectionsTable extends Table {

    private final By expandRowToggle = By.xpath(".//div[@class='row-toggle']");
    private final By connectionName = By.xpath(".//div[@class='connection-name']/.//a");

    public ConnectionsTable(WebDriverController wdController) {
        super(wdController);
    }


    public void open(String rpName) {
        int index = wdController.getIndex(getColumnCellElements("Name"), rpName);
        getColumnCellElements("Name").get(index).findElement(connectionName).click();
    }

    /**
     * Click to expand connection rows.
     */
    public void expandConnection(String column, String cell) {
        int index = wdController.getIndex(getColumnCellElements(column), cell);
        getColumnCellElements(column).get(index).findElement(expandRowToggle).click();
    }


}
