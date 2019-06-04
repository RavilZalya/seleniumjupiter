/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.honeybadger.uitest.test.cases;

import com.adjuster.honeybadger.uitest.page.commonelements.Dialog;
import com.adjuster.honeybadger.uitest.page.commonelements.Snackbar;
import com.adjuster.honeybadger.uitest.page.connections.ConnectionTypes;
import com.adjuster.honeybadger.uitest.page.connections.NewConnectionDetails;
import com.adjuster.honeybadger.uitest.page.connections.NewConnectionPermissions;
import com.adjuster.honeybadger.uitest.page.connections.NewConnectionReview;
import com.adjuster.honeybadger.uitest.test.AuthenticatedTest;
import io.github.bonigarcia.seljup.SingleSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.BDDAssertions.then;


@DisplayName("Adding a new connection")
@Tag("nested")
@SingleSession
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AddNewConnectionTest extends AuthenticatedTest {

    private ConnectionTypes connectionTypes;

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
            connectionDetails = connectionTypes.selectConnectionType("AppNexus");
        }

        @Test
        public void whenClickingAConnectionType_thenStep1ConnectionDetailsWindowAppears() {
            then(connectionDetails.isDisplayed()).isTrue();
        }

        @ParameterizedTest()
        @CsvFileSource(resources = "/data/newConnectionName.csv", numLinesToSkip = 1)
        public void whenTypingConnectionName_thenNextButtonGetsEnabled(String newConectionName) {
            then(connectionDetails.andIGiveNameToConnection(newConectionName).buttonNextIsEnabled()).isTrue();
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

            @ParameterizedTest()
            @CsvFileSource(resources = "/data/newConnectionParams.csv", numLinesToSkip = 1)
            public void whenEnteringAllNecessaryParams_thenNextButtonGetsEnabled(String param1, String param2, String param3, String param4) {
                then(connectionPermissions.andIEnterConnectionParameters(param1, param2, param3, param4).buttonNextIsEnabled()).isTrue();
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
                        snack = new Snackbar(driver);
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




