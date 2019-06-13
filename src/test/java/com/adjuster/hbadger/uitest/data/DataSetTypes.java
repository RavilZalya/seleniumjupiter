/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.data;

public enum DataSetTypes {
    SINGLE_SOURCE("Single Source"),
    AGGREGATE("Aggregate"),
    FLAT_FILE("Flat File"),
    ;

    private final String text;

    DataSetTypes(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}
