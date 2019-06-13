/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.data.report;

public enum ReportingBreakout {
    DAILY("Daily"),
    WEEKLY("Weekly"),
    MONTHLY("Monthly"),
    ;

    private final String text;

    ReportingBreakout(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}
