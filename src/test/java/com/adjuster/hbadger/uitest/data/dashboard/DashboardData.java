/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.data.dashboard;

import com.adjuster.hbadger.uitest.utilities.DateManager;

public class DashboardData {

    private String name;
    private String description;
    private boolean isPrivate;

    private String dateFormat = "MMddyyyy_HHmm";

    public DashboardData() {

        DateManager dateManager = new DateManager();

        name = "Dashboard_" + dateManager.getDate(dateFormat);
        description = "A description for the dashboard";
        isPrivate = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean isPrivate) {
        isPrivate = isPrivate;
    }
}
