/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.data.report;

import com.adjuster.hbadger.uitest.data.DataSetTypes;
import com.adjuster.hbadger.uitest.utilities.DateManager;
import java.util.ArrayList;
import java.util.List;

public class ReportData {

    private String name;
    private ReportTypes reportType;
    private DataSetTypes dataSetType;
    private ReportStatus status;
    private ReportingPeriods reportingPeriod;
    private ReportingBreakout reportingBreakout;
    private boolean includeHeader;
    private boolean isPrivate;
    private String lastRun;
    private List<ReportDimensions> reportDimensionsList = new ArrayList<>();
    private List<ReportMetrics> reportMetricsList = new ArrayList<>();


    public ReportData() {

        DateManager dateManager = new DateManager();

        dataSetType = DataSetTypes.SINGLE_SOURCE;
        name = " Name 1";
        status = ReportStatus.IN_QUEUE;
        reportType = ReportTypes.NETWORK_ANALYTICS;
        reportingPeriod = ReportingPeriods.MONTH_TO_DATE;
        reportingBreakout = ReportingBreakout.DAILY;
        includeHeader = false;
        isPrivate = true;
        lastRun = dateManager.getDate("MM/dd/yyyy");
        reportDimensionsList.add(ReportDimensions.DATE);
        reportMetricsList.add(ReportMetrics.CLICKS);
        reportMetricsList.add(ReportMetrics.REVENUE);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataSetTypes getDataType() {
        return dataSetType;
    }

    public void setDataType(DataSetTypes dataSetType) {
        this.dataSetType = dataSetType;
    }

    public ReportTypes getReportType() {
        return reportType;
    }

    public void setReportType(ReportTypes reportType) {
        this.reportType = reportType;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public ReportingPeriods getReportingPeriod() {
        return reportingPeriod;
    }

    public void setReportingPeriod(ReportingPeriods reportingPeriod) {
        this.reportingPeriod = reportingPeriod;
    }

    public ReportingBreakout getReportingBreakout() {
        return reportingBreakout;
    }

    public void setReportingBreakout(ReportingBreakout reportingBreakout) {
        this.reportingBreakout = reportingBreakout;
    }

    public boolean isIncludeHeader() {
        return includeHeader;
    }

    public void setIncludeHeader(boolean includeHeader) {
        this.includeHeader = includeHeader;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        this.isPrivate = aPrivate;
    }

    public String getLastRun() {
        return lastRun;
    }

    public void setLastRun(String lastRun) {
        this.lastRun = lastRun;
    }

    public List<ReportDimensions> getReportDimensionsList() {
        return reportDimensionsList;
    }

    public void setReportDimensionsList(List<ReportDimensions> reportDimensionsList) {
        this.reportDimensionsList = reportDimensionsList;
    }

    public List<ReportMetrics> getReportMetricsList() {
        return reportMetricsList;
    }

    public void setReportMetricsList(List<ReportMetrics> reportMetricsList) {
        this.reportMetricsList = reportMetricsList;
    }
}


