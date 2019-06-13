package com.adjuster.hbadger.uitest.page.reports.component;

import com.adjuster.hbadger.uitest.page.common.Dropdown;
import com.adjuster.hbadger.uitest.page.common.Searchbar;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ReportsSearchbar extends Searchbar {

    @FindBy(how = How.XPATH, using = "././/div[contains(@class,'mat-form-field')]")
    protected List<WebElement> filters;

    @FindBy(how = How.XPATH, using = "././/mat-form-field")
    protected List<WebElement> filterTags;

    public ReportsSearchbar(WebDriverController wdController) {
        super(wdController);
    }

    public void filterAll() {
        filters.get(0).click();
    }

    public void filterMyReports() {
        filters.get(1).click();
    }

    public void filterSharedWithMe() {
        filters.get(2).click();
    }

    public void filterFavorites() {
        filters.get(3).click();
    }


    public Dropdown filterTags(String tag) {
        filterTags.get(0).click();
        return new Dropdown(wdController);
    }
}
