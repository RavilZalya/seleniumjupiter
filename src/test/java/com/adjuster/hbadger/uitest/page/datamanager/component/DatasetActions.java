package com.adjuster.hbadger.uitest.page.datamanager.component;

import com.adjuster.hbadger.uitest.page.Element;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DatasetActions extends Element {

    @FindBy(xpath = ".//button")
    List<WebElement> options;

    public DatasetActions(WebDriverController wdController) {
        super(wdController, "//div[@class='mat-menu-content']");
    }

    public void selectOption(String option) {
        options.get(wdController.getIndex(options, option)).click();
    }

    public void disable() {
        if (isEnabled()) {
            selectOption("Disable");
        }
    }

    public void enable() {
        if (!isEnabled()) {
            selectOption("Enable");
        }
    }

    public void delete() {
        selectOption("Delete");
    }

    public void addView() {
        selectOption("Add New View");
    }

    private boolean isEnabled() {
        return !(wdController.exists(options, "Enable"));
    }

}

