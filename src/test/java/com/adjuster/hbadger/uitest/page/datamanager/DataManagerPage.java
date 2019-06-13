
package com.adjuster.hbadger.uitest.page.datamanager;

import com.adjuster.hbadger.uitest.config.PageConfig;
import com.adjuster.hbadger.uitest.page.Page;
import com.adjuster.hbadger.uitest.page.common.FeaturesMenu;
import com.adjuster.hbadger.uitest.page.common.Paginator;
import com.adjuster.hbadger.uitest.page.common.Searchbar;
import com.adjuster.hbadger.uitest.page.datamanager.component.DatasetGrid;
import com.adjuster.hbadger.uitest.page.datamanager.component.NewDatasetDetails;
import com.adjuster.hbadger.uitest.utilities.WebDriverController;


public class DataManagerPage extends Page {

    private Searchbar searchbar;
    private Paginator paginator;
    private FeaturesMenu featureMenu;

    public DataManagerPage(WebDriverController wdController, PageConfig pageConfig) {
        super(wdController, pageConfig);
        this.searchbar = new Searchbar(wdController);
        this.featureMenu = new FeaturesMenu(wdController);
    }

    public Searchbar getSearchbar() {
        return searchbar;
    }

    public Paginator getPaginator() {
        return new Paginator(wdController);
    }

    public FeaturesMenu getFeatureMenu() {
        return featureMenu;
    }

    public DatasetGrid getDatasetGrid() {
        return new DatasetGrid(wdController);
    }

    public NewDatasetDetails andIStartCreatingNewDataset() {
        getSearchbar().addNew();
        return new NewDatasetDetails(wdController);
    }

    @Override
    public String getPageUrl() {
        return getBaseUrl() + "/data-manager";
    }

}
