/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.data.report;

public enum ReportDimensions {
    ADVERTISER("Advertiser"),
    BIDDER("Bidder"),
    BRAND("Brand"),
    COUNTRY_NAME("Country Name"),
    DATE("Date"),
    MEDIA_TYPE("Media Type"),
    PLACEMENT("Placement"),
    PLACEMENT_GROUP("Placement Group"),
    PUBLISHER_CURRENCY("Publisher Currency"),
    SIZE("Size"),
    SUPPLY_TYPE("Supply Type"),
    YIELD_PARTNER("Yield Partner"),
    ;

    private final String text;

    ReportDimensions(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}
