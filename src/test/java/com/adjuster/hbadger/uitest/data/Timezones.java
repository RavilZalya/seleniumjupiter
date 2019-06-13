/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.data;

public enum Timezones {
    PST("(GMT-08:00) Pacific Standard Time", "America/Los_Angeles"),
    EST("(GMT-05:00) Eastern Standard Time", "America/New_York"),
    AST("(GMT-04:00) Atlantic Standard Time", "America/Halifax"),
    ST("(GMT) GMT Standard Time", "Etc/GMT"),
    RST("(GMT+01:00) Romance Standard Time", "Europe/Paris"),
    WEST("(GMT+01:00) W. Europe Standard Time", "Europe/Berlin"),
    EEST("(GMT+10:00) A.U.S. Eastern Standard Time", "Australia/Sydney")
    ;

    private final String longText;
    private final String shortText;

    Timezones(final String longText, final String shortText) {

        this.longText = longText;
        this.shortText = shortText;
    }

    public String getLongText() {
        return longText;
    }

    public String getShortText() { return shortText; }

}
