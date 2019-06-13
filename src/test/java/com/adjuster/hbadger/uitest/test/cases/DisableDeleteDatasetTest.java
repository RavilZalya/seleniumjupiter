/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.test.cases;


import com.adjuster.hbadger.uitest.config.TestParams;
import com.adjuster.hbadger.uitest.page.common.ConfirmationDialog;
import com.adjuster.hbadger.uitest.page.common.Snackbar;
import com.adjuster.hbadger.uitest.page.datamanager.DataManagerPage;
import com.adjuster.hbadger.uitest.test.AuthenticatedTest;
import io.github.bonigarcia.seljup.SingleSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


import static org.assertj.core.api.BDDAssertions.then;


@DisplayName("Disable and delete dataset")
@SingleSession
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DisableDeleteDatasetTest extends AuthenticatedTest {

    private DataManagerPage dataManager;

    public DisableDeleteDatasetTest() {
        super(new TestParams("DisableDeleteDatasetTestOld.csv"));
    }


    @BeforeAll
    public void setupClass() {
        givenIAmAtHomePage.iGoToDataManagerPage();
    }

    @BeforeEach
    public void refreshBeforeEachTest() {
        wdController.pageRefresh();
        dataManager = new DataManagerPage(wdController, getConfig());
        dataManager.getPaginator().openItemsPerPageDropdown().select("100");
    }

    @DisplayName("Disable dataset test")
    @Tag("dataset")
    @Test
    public void disableDataset() {
        //when selecting 'Disable' in action dropdown
        dataManager.getDatasetGrid().action(testParams.get("dtsToDisable")).disable();
        //and selecting Confirm in confirmation dialog
        (new ConfirmationDialog(wdController)).submitRightButton();
        //then a success snackbar is shown
        then((new Snackbar(wdController)).isSuccess()).isTrue();
    }

    @DisplayName("Enable dataset test")
    @Tag("dataset")
    @Test
    public void enableDataset() {
        //when selecting 'Enable' in action dropdown
        dataManager.getDatasetGrid().action(testParams.get("dtsToEnable")).enable();
        //then a success snackbar is shown
        then((new Snackbar(wdController)).isSuccess()).isTrue();
    }

    @DisplayName("Delete dataset test")
    @Tag("dataset")
    @Test
    public void deleteDataset() {
        //when selecting 'Delete' in action dropdown
        dataManager.getDatasetGrid().action(testParams.get("dtsToDelete")).delete();
        //and selecting Confirm in confirmation dialog
        (new ConfirmationDialog(wdController)).submitRightButton();
        //then a success snackbar is shown
        then((new Snackbar(wdController)).isSuccess()).isTrue();
    }

}