/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.test.cases;


import com.adjuster.hbadger.uitest.config.TestParams;
import com.adjuster.hbadger.uitest.page.connections.ConnectionsPage;
import com.adjuster.hbadger.uitest.test.AuthenticatedTest;
import io.github.bonigarcia.seljup.SingleSession;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


import static org.assertj.core.api.BDDAssertions.then;


@DisplayName("Edit connection")
@Tag("connection")
@Tag("rzz")
@SingleSession
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EditConnectionTests extends AuthenticatedTest {

    private ConnectionsPage connections;

    public EditConnectionTests() {
        super(new TestParams("internalcredsOld.csv"));
    }


    @BeforeAll
    public void setupClass() {
        givenIAmAtHomePage.getFeatureMenu().select("Connections");
        connections = new ConnectionsPage(wdController, getConfig());
    }

    @BeforeEach
    public void refreshBeforeEachTest()  throws InterruptedException {
        connections.getPaginator().openItemsPerPageDropdown().select("30");
    }
    //    wdController.pageRefresh();
    //    connections = new ConnectionsPage(wdController, getConfig());


    @DisplayName("Edit connection name test")
    @Tag("dataset")
    @Tag("rz")
    @Test
    public void editConnectionName() throws InterruptedException {
        //connections.getPaginator().openItemsPerPageDropdown().select("30");
        connections.getTable().open("AmazonTAM_Conn_Acnt50\n1 Data Set"); //testParams.get("cnnToEdit")
        Thread.sleep(5000);
        /*ConfirmationDialog disableConfirmation = new ConfirmationDialog(wdController);
        disableConfirmation.submitRightButton();
        //then connection is successfully created
        then((new Snackbar(wdController)).isSuccess()).isTrue();*/
    }


}