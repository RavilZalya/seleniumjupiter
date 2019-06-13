/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.data;

public enum Connections {
    AppNexus("AppNexus"),
    FileImport("File Import"),
    ;

    private final String text;

    Connections(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}
