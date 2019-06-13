/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.data.report;

public enum ReportStatus {
    IN_QUEUE("In Queue"),
    OK("Ok"),
    ;

    private final String text;

    ReportStatus(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}
