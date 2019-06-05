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
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.BDDAssertions.then;


@DisplayName("Adding a new connection")
@Tag("ordered")
@SingleSession
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AddNewConnectionOrderedTest extends AuthenticatedTest {
/*
    private ConnectionTypes connectionTypes;
    private NewConnectionDetails connectionDetails;
    private NewConnectionPermissions connectionPermissions;
    private NewConnectionReview connectionReview;
    private Dialog proceedToCreateNewDatasetDialog;
    private Snackbar snack;

    @BeforeAll
    public void proceedToConnectionTypesGrid() {
        connectionTypes = givenIAmAtHomePage
                .iGoToConnectionsPage()
                .clickAddNewConnectionBtn();
    }

    @DisplayName("Test 1")
    @Test
    @Order(1)
    public void whenClickingAddNewConnection_thenConnectionTypesGridAppears() {
        then(connectionTypes.isDisplayed()).isTrue();
    }

    @DisplayName("Test 2")
    @Test
    @Order(2)
    public void proceedToStep1ConnectionDetailsWindow() {
        connectionDetails = connectionTypes.selectConnectionType("AppNexus");
    }

    @DisplayName("Test 3")
    @Test
    @Order(3)
    public void whenClickingAConnectionType_thenStep1ConnectionDetailsWindowAppears() {
        then(connectionDetails.isDisplayed()).isTrue();
    }

    @Order(4)
    @DisplayName("Test 4")
    @ParameterizedTest()
    @CsvFileSource(resources = "/data/newConnectionParams.csv", numLinesToSkip = 1)
    public void whenTypingConnectionName_thenNextButtonGetsEnabled(String newConectionName) {
        then(connectionDetails.andIGiveNameToConnection(newConectionName).buttonNextIsEnabled()).isTrue();
    }

    @DisplayName("Test 5")
    @Test
    @Order(5)
    public void proceedToStep2ConnectionPermissionWindow() {
        connectionPermissions = connectionDetails.clickButtonNext();
    }

    @DisplayName("Test 6")
    @Test
    @Order(6)
    public void whenClickingNextButton_thenStep2ConnectionPermissionAppears() {
        then(connectionPermissions.isDisplayed()).isTrue();
    }

    @Order(7)
    @DisplayName("Test 7")
    @ParameterizedTest()
    @CsvFileSource(resources = "/data/newConnectionParams.csv", numLinesToSkip = 1)
    public void whenEnteringAllNecessaryParams_thenNextButtonGetsEnabled(String param1, String param2, String param3, String param4) {
        then(connectionPermissions.andIEnterConnectionParameters(param1, param2, param3, param4).buttonNextIsEnabled()).isTrue();
    }

    @DisplayName("Test 8")
    @Test
    @Order(8)
    public void proceedToStep3ReviewAppears() {
        connectionReview = connectionPermissions.clickButtonNext();
    }

    @DisplayName("Test 9")
    @Test
    @Order(9)
    public void whenClickingNextButton_Step3ReviewAppears() {
        then(connectionReview.isDisplayed()).isTrue();
    }

    @DisplayName("Test 10")
    @Test
    @Order(10)
    public void whenStep3ReviewAppears_thenAddConnectionButtonIsEnabled() {
        then(connectionReview.buttonNextIsEnabled()).isTrue();
    }

    @DisplayName("Test 11")
    @Test
    @Order(11)
    public void proceedToSubmitionAndConfirmation() {
        proceedToCreateNewDatasetDialog = connectionReview.clickButtonNext();
        snack = new Snackbar(driver);
    }

    @DisplayName("Test 12")
    @Test
    @Order(12)
    public void whenClickingAddConnectionButton_thenSuccessSnackbarAppears() {
        then(snack.isSuccess()).isTrue();
    }

    @DisplayName("Test 13")
    @Test
    @Order(13)
    public void whenConnectionCreated_thenCreateNewDatasetConfirmDialogAppears() {
        then(proceedToCreateNewDatasetDialog.isDisplayed()).isTrue();
    }

    @DisplayName("Test 14")
    @Test
    @Order(14)
    public void whenCreateNewDatasetConfirmDialogAppears_thenCreateDatasetButtonIsEnabled() {
        then(proceedToCreateNewDatasetDialog.rightButtonIsEnabled()).isTrue();
    }

    @DisplayName("Test 15")
    @Test
    @Order(15)
    public void whenCreateNewDatasetConfirmDialogAppears_thenNotNowButtonIsEnabled() {
        then(proceedToCreateNewDatasetDialog.leftButtonIsEnabled()).isTrue();
    }

    @DisplayName("Test 16")
    @Test
    @Order(16)
    public void proceedToDeclineNewDatasetCreation() {
        proceedToCreateNewDatasetDialog.submitLeftButton();
    }

    @DisplayName("Test 17")
    @Test
    @Order(17)
    public void whenClickingNotNow_thenCreateNewDatasetDialogDisappears() {
        then(proceedToCreateNewDatasetDialog.isNotDisplayed()).isTrue();
    }

 */
}




