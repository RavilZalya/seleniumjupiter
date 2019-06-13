/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.test.cases;


import com.adjuster.hbadger.uitest.config.TestParams;
import com.adjuster.hbadger.uitest.page.common.Snackbar;
import com.adjuster.hbadger.uitest.page.datamanager.DataManagerPage;
import com.adjuster.hbadger.uitest.page.datamanager.component.NewDatasetConfig;
import com.adjuster.hbadger.uitest.page.datamanager.component.NewDatasetConnection;
import com.adjuster.hbadger.uitest.page.datamanager.component.NewDatasetDetails;
import com.adjuster.hbadger.uitest.test.AuthenticatedTest;
import io.github.bonigarcia.seljup.SingleSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.BDDAssertions.then;

@DisplayName("Creating a new dataset")
@Tag("dataset")
@Tag("rz")
@SingleSession
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CreateNewDatasetTest extends AuthenticatedTest {


    public CreateNewDatasetTest() {
        super(new TestParams("CreateNewDatasetTestOld.csv"));
    }

    private DataManagerPage dataManager;
    private NewDatasetDetails datasetDetails;
    private NewDatasetConnection datasetConnection;
    private NewDatasetConfig datasetConfig;
    private Snackbar snackbar;


    @BeforeAll
    public void proceedToConnectionTypesGrid() {
        dataManager = givenIAmAtHomePage
                .iGoToDataManagerPage();
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    public class Step1DatasetDetails {

        @BeforeAll
        public void proceedToStep1ConnectionDetailsWindow() {
            datasetDetails = dataManager.andIStartCreatingNewDataset();
        }

        @Test
        public void whenInStep1_thenNextButtonIsDisabled() {
            then(datasetDetails.buttonNextIsEnabled()).isFalse();
        }

        @Test
        public void whenInStep1enterNewDatasetName_thenNextButtonIsDisabled() {
            then(datasetDetails.setDatasetName(testParams.get("datasetName")).buttonNextIsEnabled()).isFalse();
        }

        @Nested
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        class selectConnectionType {


            @BeforeAll
            public void proceedToStep1ConnectionDetailsWindow() {
                datasetDetails = datasetDetails.selectDatatype(testParams.get("datasetType"));
            }

            @Test
            public void whenConnectionNameAndDatasetTypeSelected_thenNextButtonIsEnabled() {
                then(datasetDetails.buttonNextIsEnabled()).isTrue();
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class Step2ConnectionSource {


                @BeforeAll
                public void proceedToStep2ConnectionDetailsWindow() {
                    datasetConnection = datasetDetails.clickButtonNext();
                }

                @Test
                public void whenInConnectionDetailsWindow_thenNextButtonIsDisabled() {
                    then(datasetConnection.buttonNextIsEnabled()).isFalse();
                }

                @Nested
                @TestInstance(TestInstance.Lifecycle.PER_CLASS)
                class AfterDatasetParamsAreSelecteds {

                    @Test
                    public void whenInConnectionDetailsWindow_thenIamAbleToEnterAllRequireParams() {
                        then(datasetConnection.iInsertDatasetParameters(testParams.get("param1"), testParams.get("value1"),
                                testParams.get("param2"), testParams.get("value2"),
                                testParams.get("param3"), testParams.get("value3"),
                                testParams.get("param4"), testParams.get("value4")).buttonNextIsEnabled()).isTrue();
                    }

                    @Nested
                    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
                    class AfterDatasetParamsAreSelected {

                        @Test
                        public void whenAllRequiredDatasetParamsAreSelected_thenNextButtonIsEnabled() {
                            then(datasetConnection.buttonNextIsEnabled()).isTrue();
                        }

                        @Nested
                        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
                        class ProceedToDatasetConfigurationStep {

                            @BeforeAll
                            public void proceedToLastStepOfCreationDataset() {
                                datasetConfig = datasetConnection.clickButtonNext();
                            }

                            @Test
                            public void whenInStep3DatasetConfig_thenNextButtonIsEnabled() {
                                then(datasetConfig.buttonNextIsEnabled()).isTrue();
                            }

                            @Nested
                            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
                            class StepDatsetCreationConfirmation {

                                @BeforeAll
                                public void proceedToStep1ConnectionDetailsWindow() {
                                    snackbar = datasetConfig.clickButtonNext();
                                }

                                @Test
                                public void whenInStep3DatasetConfig_thenNextButtonIsEnabled() {
                                    then(snackbar.isSuccess()).isTrue();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
