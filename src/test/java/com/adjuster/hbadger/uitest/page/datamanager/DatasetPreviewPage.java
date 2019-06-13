package com.adjuster.hbadger.uitest.page.datamanager;

import com.adjuster.hbadger.uitest.config.PageConfig;
import com.adjuster.hbadger.uitest.page.Page;
import com.adjuster.hbadger.uitest.page.common.TabSelector;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;

public class DatasetPreviewPage extends Page {


    private TabSelector tabSelector;

    public DatasetPreviewPage(WebDriverController wdController, PageConfig pageConfig) {
        super(wdController, pageConfig);
        tabSelector = new TabSelector(wdController);
    }

    @Override
    public String getPageUrl() {
        return null;
    }
}
