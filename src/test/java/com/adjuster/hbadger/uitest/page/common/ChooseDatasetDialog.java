package com.adjuster.hbadger.uitest.page.common;

import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class ChooseDatasetDialog extends Dialog {


    @FindBy(how = How.XPATH, using = "//div[@id='datasetName']")
    protected List<WebElement> datasets;

    private final By selectedDatasets = By.xpath("//div[contains(@class,'dataset-info-inner')]");

    public ChooseDatasetDialog(WebDriverController wdController) {
        super(wdController, "//div[@id='datasetSelectorContainer']");

    }

    public ChooseDatasetDialog select(String datasetName) {
        datasets.get(wdController.getIndex(datasets, datasetName)).click();
        then(wdController.findVisibleElement(selectedDatasets).isDisplayed()).isTrue();
        return this;
    }
}
