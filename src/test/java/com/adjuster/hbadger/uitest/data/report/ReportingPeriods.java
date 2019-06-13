/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.data.report;

public enum ReportingPeriods {
    MONTH_TO_DATE("Month to Date"),
    YEAR_TO_DATE("Year to Date"),
    LAST_N_DAYS("Last N Days"),
    CUSTOM_DATE_RANGE("Custom Date Range"),
    ;

    private final String text;

    ReportingPeriods(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}
