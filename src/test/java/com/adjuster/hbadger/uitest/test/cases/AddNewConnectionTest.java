/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.test.cases;


import com.adjuster.hbadger.uitest.config.TestParams;
import com.adjuster.hbadger.uitest.page.common.Dialog;
import com.adjuster.hbadger.uitest.page.common.Snackbar;
import com.adjuster.hbadger.uitest.page.connections.component.ConnectionTypes;
import com.adjuster.hbadger.uitest.page.connections.component.NewConnectionDetails;
import com.adjuster.hbadger.uitest.page.connections.component.NewConnectionPermissions;
import com.adjuster.hbadger.uitest.page.connections.component.NewConnectionReview;
import com.adjuster.hbadger.uitest.test.AuthenticatedTest;
import io.github.bonigarcia.seljup.SingleSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.BDDAssertions.then;


@DisplayName("Adding a new connection")
@Tag("connection")
@Tag("rz")
@SingleSession
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AddNewConnectionTest extends AuthenticatedTest {

    private ConnectionTypes connectionTypes;

    public AddNewConnectionTest() {
        super(new TestParams("AddNewConnectionTestOld.csv"));
    }

    @BeforeAll
    public void proceedToConnectionTypesGrid() {
        connectionTypes = givenIAmAtHomePage
                .iGoToConnectionsPage()
                .clickAddNewConnectionBtn();
    }

    @Test
    public void whenClickingAddNewConnection_thenConnectionTypesGridAppears() {
        then(connectionTypes.isDisplayed()).isTrue();
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    public class Step1ConnectionDetailsWindow {

        private NewConnectionDetails connectionDetails;

        @BeforeAll
        public void proceedToStep1ConnectionDetailsWindow() {
            connectionDetails = connectionTypes.selectConnectionType(testParams.get("connType"));
        }

        @Test
        public void whenClickingAConnectionType_thenStep1ConnectionDetailsWindowAppears() {
            then(connectionDetails.isDisplayed()).isTrue();
        }

        @Test
        public void whenTypingConnectionName_thenNextButtonGetsEnabled() {
            then(connectionDetails.andIGiveNameToConnection(testParams.get("connName")).buttonNextIsEnabled()).isTrue();
        }

        @Nested
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        public class Step2ConnectionPermissionsWindow {

            NewConnectionPermissions connectionPermissions;

            @BeforeAll
            public void proceedToStep2ConnectionPermissionWindow() {
                connectionPermissions = connectionDetails.clickButtonNext();
            }

            @Test
            public void whenClickingNextButton_thenStep2ConnectionPermissionAppears() {
                then(connectionPermissions.isDisplayed()).isTrue();
            }

            @Test
            public void whenEnteringAllNecessaryParams_thenNextButtonGetsEnabled() {
                then(connectionPermissions.andIEnterConnectionParameters(testParams.get("param1"), testParams.get("param2"), testParams.get("param3"), testParams.get("param4")).buttonNextIsEnabled()).isTrue();
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            public class Step3ReviewWindow {

                private NewConnectionReview connectionReview;

                @BeforeAll
                public void proceedToStep3ReviewAppears() {
                    connectionReview = connectionPermissions.clickButtonNext();
                }

                @Test
                public void whenClickingNextButton_Step3ReviewAppears() {
                    then(connectionReview.isDisplayed()).isTrue();
                }

                @Test
                public void whenStep3ReviewAppears_thenAddConnectionButtonIsEnabled() {
                    then(connectionReview.buttonNextIsEnabled()).isTrue();
                }

                @Nested
                @TestInstance(TestInstance.Lifecycle.PER_CLASS)
                public class LastStepConfirmation {

                    private Dialog proceedToCreateNewDatasetDialog;
                    private Snackbar snack;

                    @BeforeAll
                    public void proceedToSubmitionAndConfirmation() {
                        proceedToCreateNewDatasetDialog = connectionReview.clickButtonNext();
                        snack = new Snackbar(wdController);
                    }

                    @Test
                    public void whenClickingAddConnectionButton_thenSuccessSnackbarAppears() {
                        then(snack.isSuccess()).isTrue();
                    }

                    @Test
                    public void whenConnectionCreated_thenCreateNewDatasetConfirmDialogAppears() {
                        then(proceedToCreateNewDatasetDialog.isDisplayed()).isTrue();
                    }

                    @Test
                    public void whenCreateNewDatasetConfirmDialogAppears_thenCreateDatasetButtonIsEnabled() {
                        then(proceedToCreateNewDatasetDialog.rightButtonIsEnabled()).isTrue();
                    }

                    @Test
                    public void whenCreateNewDatasetConfirmDialogAppears_thenNotNowButtonIsEnabled() {
                        then(proceedToCreateNewDatasetDialog.leftButtonIsEnabled()).isTrue();
                    }

                    @Nested
                    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
                    public class CreateNewDatasetConfirmationDialog {

                        @BeforeAll
                        public void proceedToDeclineNewDatasetCreation() {
                            proceedToCreateNewDatasetDialog.submitLeftButton();
                        }

                        @Test
                        public void whenClickingNotNow_thenCreateNewDatasetDialogDisappears() {
                            then(proceedToCreateNewDatasetDialog.isNotDisplayed()).isTrue();
                        }
                    }

                }

            }

        }


    }
}




