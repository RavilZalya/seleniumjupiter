package com.adjuster.hbadger.uitest.page.datamanager.component;

import com.adjuster.hbadger.uitest.page.Element;
import com.adjuster.hbadger.uitest.page.common.SearchableDropdown;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DatasetFilters extends Element {

    @FindBy(xpath = "//div[contains(@class,'data-set-connection-filter')]")
    WebElement filterConnection;
    @FindBy(xpath = "//div[contains(@class,'data-set-status-filter')]") //TODO: Marat to fix class name to 'data-set-status-filter;
    WebElement filterStatus;
    @FindBy(xpath = "//div[contains(@class,'data-type-filter')]/.//i[contains(@class,'fa-file-text')]")
    WebElement filterFlatfile;
    @FindBy(xpath = "//div[contains(@class,'data-type-filter')]/.//i[contains(@class,'icon-aggregate-ds')]")
    WebElement filterAggregate;
    @FindBy(xpath = "//div[contains(@class,'data-type-filter')]/.//i[contains(@class,'icon-singlesource-ds')]")
    WebElement filterSinglesource;

    public DatasetFilters(WebDriverController wdController) {
        super(wdController, "//div[contains(@class,'data-sets-filters')]");
    }

    public SearchableDropdown filterConnection() {
        wdController.findClickableElement(filterConnection).click();
        return new SearchableDropdown(wdController);
    }

    public SearchableDropdown filterStatus() {
        wdController.findClickableElement(filterStatus).click();
        return new SearchableDropdown(wdController);
    }

    public void filterFlatfile() {
        wdController.findClickableElement(filterFlatfile).click();
    }

    public void filterAggregate() {
        wdController.findClickableElement(filterAggregate).click();
    }

    public void filterSinglesource() {
        wdController.findClickableElement(filterSinglesource).click();
    }

}