/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateManager {

    private Calendar calendar;
    SimpleDateFormat dateFormat;

    public DateManager() {

        calendar = Calendar.getInstance();
    }

    public String getDate (String format) {

        dateFormat = new SimpleDateFormat(format);

        return dateFormat.format(calendar.getTime());
    }


}
