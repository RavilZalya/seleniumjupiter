/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.data.dashboard;

import com.adjuster.hbadger.uitest.data.report.ReportDimensions;
import com.adjuster.hbadger.uitest.data.report.ReportMetrics;
import com.adjuster.hbadger.uitest.utilities.DateManager;

import java.util.ArrayList;
import java.util.List;

public class CardData {

    private String name;
    private String description;
    private boolean isPrivate;
    private CardTypes cartType;
    private String title;
    private String subtitle;
    private List<ReportDimensions> reportDimensionsList = new ArrayList<>();
    private List<ReportMetrics> reportMetricsList = new ArrayList<>();

    private String dateFormat = "MMddyyyy_HHmm";

    public CardData () {

        DateManager dateManager = new DateManager();

        cartType = CardTypes.BAR;
        name = "Card_" + dateManager.getDate(dateFormat);
        description = "A description for the dashboard";
        title = "Card Title";
        subtitle = "Card Subtitle";
        isPrivate = false;
        reportDimensionsList.add(ReportDimensions.DATE);
        reportMetricsList.add(ReportMetrics.CLICKS);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public CardTypes getCartType() {
        return cartType;
    }

    public void setCartType(CardTypes cartType) {
        this.cartType = cartType;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
