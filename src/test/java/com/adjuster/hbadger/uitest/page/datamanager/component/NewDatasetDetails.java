package com.adjuster.hbadger.uitest.page.datamanager.component;

import com.adjuster.hbadger.uitest.page.common.DialogNavigable;
import com.adjuster.hbadger.uitest.page.common.Dropdown;
import com.adjuster.hbadger.uitest.page.connections.component.NewConnectionPermissions;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class NewDatasetDetails extends DialogNavigable {

    @FindBy(how = How.XPATH, using = "//input[@name='dsName']")
    WebElement datasetName;
    @FindBy(how = How.XPATH, using = "//mat-select[@name='dataSetType']")
    WebElement dataSetType;

    public NewDatasetDetails(WebDriverController wdController) {
        super(wdController, "//div[contains(@class,'add-data-set-container')]");
    }

    /**
     * New dataset name.
     */
    public NewDatasetDetails setDatasetName(String acntName) {
        wdController.findClickableElement(datasetName).clear();
        wdController.findClickableElement(datasetName).sendKeys(acntName);
        return this;
    }

    /**
     * Open data type dropdown.
     */
    public NewDatasetDetails selectDatatype(String datasetType) {
        wdController.findClickableElement(dataSetType).click();
        (new Dropdown(wdController)).select(datasetType);
        return this;
    }

    public boolean buttonNextIsEnabled() {
        return super.leftButtonIsEnabled();
    }

    public NewDatasetConnection clickButtonNext() {
        submitLeftButton();
        return new NewDatasetConnection(wdController);
    }

}
