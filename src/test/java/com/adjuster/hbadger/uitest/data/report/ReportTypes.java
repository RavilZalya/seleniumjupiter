/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.data.report;

public enum ReportTypes {
    NETWORK_ANALYTICS("Network Analytics"),
    NETWORK_VIDEO_ANALYTICS("Network Video Analytics"),
    SELLER_BRAND_REVIEW("Seller Brand ReviewDialog"),
    ;

    private final String text;

    ReportTypes(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}
