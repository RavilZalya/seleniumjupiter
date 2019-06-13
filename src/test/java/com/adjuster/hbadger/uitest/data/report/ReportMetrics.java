/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.data.report;

public enum ReportMetrics {
    CLICKS("Clicks"),
    IMPRESSIONS("Impressions"),
    REVENUE("Revenue"),
    ;

    private final String text;

    ReportMetrics(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}
