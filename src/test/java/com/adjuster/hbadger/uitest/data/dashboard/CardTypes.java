/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.data.dashboard;

public enum CardTypes {
    BAR("Bar"),
    LINE("Line"),
    STACKED_BAR("Stacked Bar"),
    PIE("Pie"),
    TABLE("Table"),
    ;

    private final String text;

    CardTypes(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}
