/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.data;

import com.adjuster.hbadger.uitest.utilities.DateManager;

public class AccountData {

    private static String accountName;
    private static String salesforceAccount;
    private static Timezones timezone;
    private static boolean enableSsoSupport;
    private static int maxUsers;
    private static PermissionData permissions;
    private static boolean isActive;
    private static boolean hasUsers;

    // date
    private static String dateFormat = "MMddyyyy_HHmm";

    public AccountData (PermissionData permissions) {

        DateManager dateManager = new DateManager();

        accountName = "Account_" + dateManager.getDate(dateFormat);
        salesforceAccount = "";
        timezone = Timezones.PST;
        enableSsoSupport = false;
        maxUsers = 3;
        this.permissions = permissions;
        isActive = true;
    }

    public AccountData (String accountName, String salesforceAccount, Timezones timezone, boolean enableSsoSupport,
                        int maxUsers, PermissionData permissions, boolean isActive, boolean hasUsers) {

        this.accountName = accountName;
        this.salesforceAccount = salesforceAccount;
        this.timezone = timezone;
        this.enableSsoSupport = enableSsoSupport;
        this.maxUsers = maxUsers;
        this.permissions = permissions;
        this.isActive = isActive;
        this.hasUsers = hasUsers;
    }

    public enum AccountLabelAndValue {
        ACCOUNT_NAME("Account Name", accountName),
        SALESFORCE_ACCOUNT("Salesforce Account", salesforceAccount),
        TIMEZONE("Timezone", timezone.getShortText()),
        SSO_SUPPORT("SSO Support", String.valueOf(enableSsoSupport)),
        PERMISSIONS("Permissions", getEnabledPermissions()),
        ;

        private final String label;
        private final String value;

        AccountLabelAndValue(final String label, final String value) {

            this.label = label;
            this.value = value;
        }

        public String getLabel() {
            return label;
        }
        public String getValue() { return value; }
    }

    public String getAccountName() { return accountName; }

    public Timezones getTimezone() {
        return timezone;
    }

    public boolean isEnableSsoSupport() {
        return enableSsoSupport;
    }

    public int getMaxUsers() {
        return maxUsers;
    }

    public PermissionData getPermissions() {
        return permissions;
    }

    // enabled permissions text on verify page
    public static String getEnabledPermissions() {
        return permissions.getEnabledPermissionList().toString()
                .replace(",", "")
                .replace("[", "")
                .replace("]", "");
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setTimezone(Timezones timezone) {
        this.timezone = timezone;
    }

    public void setEnableSsoSupport(boolean enableSsoSupport) {
        this.enableSsoSupport = enableSsoSupport;
    }

    public void setMaxUsers(int maxUsers) {
        this.maxUsers = maxUsers;
    }

    public void setPermissions(PermissionData permissions) {
        this.permissions = permissions;
    }

    public static boolean hasUsers() { return hasUsers; }
}
