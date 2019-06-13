package com.adjuster.hbadger.uitest.test.cases;

import com.adjuster.hbadger.uitest.config.TestParams;
import com.adjuster.hbadger.uitest.page.common.Snackbar;
import com.adjuster.hbadger.uitest.page.reports.ReportsPage;
import com.adjuster.hbadger.uitest.test.AuthenticatedTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.BDDAssertions.then;

@DisplayName("Create new report.")
@Tag("report")
public class CreateEditDeleteReportTest extends AuthenticatedTest {

    private ReportsPage givenIAmAtReportPage;

    public CreateEditDeleteReportTest() {
        super(new TestParams("CreateNewReportTestOld.csv"));
    }

    @BeforeEach
    public void setupMethod() {
        givenIAmAtReportPage = givenIAmAtHomePage
                .iGoToReportsPage();
    }

    @DisplayName("Create new report test")
    @Test
    public void createReport(String dsName, String rpName, String timePeriod, String breakout, String dimension1,
                             String dimension2, String metrics1, String metrics2, String separator, String email) {
        Snackbar testResult = givenIAmAtReportPage
                .iStartCreatingNewReportAndChooseDataset(testParams.get("datasetName"))
                .andIEditTitleOfTheReport(testParams.get("reportName"))
                .andISelectReportingPeriod(testParams.get("period"))
                .andIMakeReportShared()
                .andISelectReportingBreakout(testParams.get("breakout"))
                .andISelectDimensions(testParams.get("dimension1"), testParams.get("dimension2"))
                .andISelectMetrics(testParams.get("metrics1"), testParams.get("metrics2"))
                .andISetDeliveryMethodNone()
                .andISaveReport();
        then((testResult).isSuccess()).isTrue();
    }
/*
    @DisplayName("Edit report test")
    @ParameterizedTest
    @CsvFileSource(resources = "/data/editReport.csv", numLinesToSkip = 1)
    public void editReport(String rpName, String rpEditName, String timePeriod, String breakout, String dimension1,
                           String dimension2, String metrics1, String metrics2, String email) {
        Snackbar testResult = givenIAmAtReportPage.iOpenReportForEditing(rpName)
                .andIEditTitleOfTheReport(rpEditName)
                .andIMakeReportPrivate()
                .andISelectDimensions(dimension1, dimension2)
                .andISelectMetrics(metrics1, metrics2)
                .andISaveReport();
        then((testResult).isSuccess()).isTrue();
    }

    @DisplayName("Delete report test")
    @ParameterizedTest
    @CsvFileSource(resources = "/data/deleteReport.csv", numLinesToSkip = 1)
    public void deleteReport(String rpName) {
        Snackbar testResult = givenIAmAtReportPage.iDeleteAReport(rpName);
        //then report has been edited
        then((testResult).isSuccess()).isTrue();
    }
*/
}