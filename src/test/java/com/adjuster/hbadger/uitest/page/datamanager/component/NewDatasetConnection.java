package com.adjuster.hbadger.uitest.page.datamanager.component;

import com.adjuster.hbadger.uitest.page.common.DialogNavigable;
import com.adjuster.hbadger.uitest.page.common.Dropdown;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewDatasetConnection extends DialogNavigable {

    @FindBy(how = How.XPATH, using = "//mat-select[@*='connectionId']/../..")
    WebElement connectionName;
    @FindBy(how = How.XPATH, using = "//mat-select[@*='publisherId']/../..")
    WebElement publisherId;
    @FindBy(how = How.XPATH, using = "//mat-select[@*='networkCode']/../..")
    WebElement networkCode;
    @FindBy(how = How.XPATH, using = "//mat-select[@*='accountId']/../..")
    WebElement accountId;
    @FindBy(how = How.XPATH, using = "//mat-select[@*='reportType']/../..")
    WebElement reportType;
    @FindBy(how = How.XPATH, using = "//input[@*='orgId']/.")
    WebElement organizationId;


    public NewDatasetConnection(WebDriverController wdController) {
        super(wdController, "//div[contains(@class,'add-data-set-container')]"); //there seem to be a bug, compelte xpath is:"//div[contains(@class,'addNew-account-stepper-heading')]/h2[contains(text(),'Step 2: Connection Source')]"
    }

    public boolean buttonNextIsEnabled() {
        return super.rightButtonIsEnabled();
    }

    public NewDatasetConfig clickButtonNext() {
        submitRightButton();
        return new NewDatasetConfig(wdController);
    }

    public NewDatasetConnection iInsertDatasetParameters(String dsParam1, String dsParam1Value, String dsParam2, String dsParam2Value,
                                                         String dsParam3, String dsParam3Value, String dsParam4, String dsParam4Value) {
        insertParam(dsParam1, dsParam1Value)
                .insertParam(dsParam2, dsParam2Value)
                .insertParam(dsParam3, dsParam3Value)
                .insertParam(dsParam4, dsParam4Value);
        return this;

    }

    /**
     * Open connection dropdown.
     */
    private NewDatasetConnection selectConnection(String connection) {
        wdController.findClickableElement(connectionName).click();
        (new Dropdown(wdController)).select(connection);
        return this;
    }

    /**
     * Open publisher ID dropdown.
     */
    private NewDatasetConnection selectPublisherId(String publisher) {
        wdController.findClickableElement(publisherId).click();
        (new Dropdown(wdController)).select(publisher);
        return this;
    }

    /**
     * Open network Code dropdown.
     */
    private NewDatasetConnection selectNetworkCode(String network) {
        wdController.findClickableElement(networkCode).click();
        (new Dropdown(wdController)).select(network);
        return this;
    }

    /**
     * Open account ID dropdown.
     */
    private NewDatasetConnection selectAccountId(String account) {
        wdController.findClickableElement(accountId).click();
        (new Dropdown(wdController)).select(account);
        return this;
    }

    /**
     * Open report ID dropdown.
     */
    private NewDatasetConnection selectReportId(String report) {
        wdController.findClickableElement(reportType).click();
        (new Dropdown(wdController)).select(report);
        return this;
    }

    /**
     * New organization Id.
     */
    private NewDatasetConnection setOrganizationId(String organization) {
        wdController.findClickableElement(organizationId).clear();
        wdController.findClickableElement(organizationId).sendKeys(organization);
        return this;
    }

    private NewDatasetConnection insertParam(String param, String value) {
        if (value.equals("null") || value.equals("")) {
            return this;
        } else {
            switch (param) {
                case "connection":
                    selectConnection(value);
                    break;
                case "publisher":
                    selectPublisherId(value);
                    break;
                case "network":
                    selectNetworkCode(value);
                    break;
                case "account":
                    selectAccountId(value);
                    break;
                case "report":
                    selectReportId(value);
                    break;
                case "organization":
                    setOrganizationId(value);
                    break;
            }
            return this;
        }
    }

}
