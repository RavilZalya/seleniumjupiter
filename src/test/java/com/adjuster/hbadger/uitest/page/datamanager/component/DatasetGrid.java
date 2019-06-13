package com.adjuster.hbadger.uitest.page.datamanager.component;

import com.adjuster.hbadger.uitest.page.Element;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

public class DatasetGrid extends Element {


    @FindBy(how = How.XPATH, using = "//div[@class='data-set-item']")
    protected List<WebElement> childContainers;

    private final By datasetName = By.xpath("././/div[contains(@class,'data-set-name')]");
    private final By datasetType = By.xpath("././/div[contains(@class,'data-set-type')]");
    private final By datasetStatus = By.xpath("././/div[contains(@class,'data-set-controls')]/div/span");
    private final By datasetActions = By.xpath("././/div[contains(@class,'data-set-controls')]/i");
    private String attribute = "ng-reflect-message";

    private DatasetFilters datasetFilters;


    public DatasetGrid(WebDriverController wdController) {
        super(wdController, "//cdk-table[contains(@class,'cdk-grid')]");
        datasetFilters = new DatasetFilters(wdController);
    }

    public DatasetFilters getDatasetFilters() {
        return datasetFilters;
    }

    public void open(String dataset) {
        wdController.findNestedElements(getDataset(dataset), datasetName).get(0).click();
    }

    public DatasetActions action(String dataset) {
        wdController.findNestedElements(getDataset(dataset), datasetActions).get(0).click();
        return new DatasetActions(wdController);
    }

    public String getType(String dataset) {
        return wdController.findNestedElements(getDataset(dataset), datasetType).get(0).getText();
    }

    public String getStatus(String dataset) {
        return wdController.findNestedElements(getDataset(dataset), datasetStatus).get(0).getText();
    }

    private WebElement getDataset(String dataset) {
        return childContainers.get(wdController.getIndex(childContainers, attribute, dataset));
    }

}
