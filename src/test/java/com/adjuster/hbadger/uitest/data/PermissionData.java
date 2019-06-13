/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.data;

import java.util.ArrayList;
import java.util.List;

public class PermissionData {

    private static boolean userFlag;
    private static boolean accountFlag;
    private static boolean connectionFlag;
    private static boolean mapFlag;
    private static boolean notificationFlag;
    private static boolean discoverFlag;
    private static boolean flowFlag;
    private static boolean illuminateFlag;
    private static boolean programmaticFlag;
    private static boolean verifyFlag;

    private static boolean userEnabled;
    private static boolean accountEnabled;
    private static boolean connectionEnabled;
    private static boolean mapEnabled;
    private static boolean notificationEnabled;
    private static boolean discoverEnabled;
    private static boolean flowEnabled;
    private static boolean illuminateEnabled;
    private static boolean programmaticEnabled;
    private static boolean verifyEnabled;

    // default ui values
    public PermissionData() {

        // by default toggle checked/unchecked
        userFlag = true;
        accountFlag = true;
        connectionFlag = true;
        mapFlag = true;
        notificationFlag = true;
        discoverFlag = true;
        flowFlag = true;
        illuminateFlag = true;
        programmaticFlag = true;
        verifyFlag = true;

        // by default field enabled/disabled
        userEnabled = false;
        accountEnabled = false;
        connectionEnabled = true;
        mapEnabled = true;
        notificationEnabled = true;
        discoverEnabled = true;
        flowEnabled = true;
        illuminateEnabled = true;
        programmaticEnabled = true;
        verifyEnabled = true;
    }

    public enum PermissionElements {
        USER("USER", userFlag, userEnabled),
        ACCOUNT("ACCOUNT", accountFlag, accountEnabled),
        CONNECTION("CONNECTION", connectionFlag, connectionEnabled),
        MAP("MAP", mapFlag, mapEnabled),
        NOTIFICATION("NOTIFICATION", notificationFlag, notificationEnabled),
        DISCOVER("DISCOVER", discoverFlag, discoverEnabled),
        FLOW("FLOW", flowFlag, flowEnabled),
        ILLUMINATE("ILLUMINATE", illuminateFlag, illuminateEnabled),
        PROGRAMMATIC("PROGRAMMATIC", programmaticFlag, programmaticEnabled),
        VERIFY("VERIFY", verifyFlag, verifyEnabled),
        ;

        private final String name;
        private final boolean flag;
        private final boolean fieldEnabled;

        PermissionElements(final String name, final boolean flag, final boolean fieldEnabled) {

            this.name = name;
            this.flag = flag;
            this.fieldEnabled = fieldEnabled;
        }
        public String getName() { return name; }
        public boolean getFlag() {
            return flag;
        }
        public boolean getFieldEnabled() { return fieldEnabled; }
    }

    // creating enabled permission list for verify section
    public static List<String> getEnabledPermissionList() {

        List<String> enabledLabels = new ArrayList<>();
        for (PermissionElements label : PermissionElements.values()) {

            if (label.getFlag())
                enabledLabels.add(label.getName());
        }
        return enabledLabels;
    }

    public boolean isUserFlag() {  return userFlag; }

    public void setUserFlag(boolean userFlag) { this.userFlag = userFlag; }

    public boolean isAccountFlag() { return accountFlag; }

    public void setAccountFlag(boolean accountFlag) { this.accountFlag = accountFlag; }

    public boolean isConnectionFlag() { return connectionFlag; }

    public void setConnectionFlag(boolean connectionFlag) { this.connectionFlag = connectionFlag; }

    public boolean isMapFlag() { return mapFlag; }

    public void setMapFlag(boolean mapFlag) { this.mapFlag = mapFlag; }

    public boolean isNotificationFlag() { return notificationFlag; }

    public void setNotificationFlag(boolean notificationFlag) { this.notificationFlag = notificationFlag; }

    public boolean isDiscoverFlag() { return discoverFlag; }

    public void setDiscoverFlag(boolean discoverFlag) { this.discoverFlag = discoverFlag; }

    public boolean isFlowFlag() { return flowFlag; }

    public void setFlowFlag(boolean flowFlag) { this.flowFlag = flowFlag; }

    public boolean isIlluminateFlag() { return illuminateFlag; }

    public void setIlluminateFlag(boolean illuminateFlag) { this.illuminateFlag = illuminateFlag; }

    public boolean isProgrammaticFlag() { return programmaticFlag; }

    public void setProgrammaticFlag(boolean programmaticFlag) { this.programmaticFlag = programmaticFlag; }

    public boolean isVerifyFlag() { return verifyFlag; }

    public void setVerifyFlag(boolean verifyFlag) { this.verifyFlag = verifyFlag; }
}
