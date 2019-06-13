/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.data;

public class UserData {

    private String firstName;
    private String lastName;
    private boolean isExternalUser;
    private String email;
    private boolean sendEmail;

    public UserData() {

        firstName = "Internal";
        lastName = "Testuser";
        isExternalUser = false;
        email = "internaluser1account10@example.com";
        sendEmail = false;
    }

    public UserData(String firstName, String lastName, boolean isExternalUser, String email, boolean sendEmail) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.isExternalUser = isExternalUser;
        this.email = email;
        this.sendEmail = sendEmail;
    }

    public enum UserLabels {
        FIRST_NAME("First Name"),
        LAST_NAME("Last Name"),
        ACCOUNT_TYPE("Account Type"),
        EMAIL_ADDRESS("Email Address"),
        SEND_EMAIL("Send Email"),
        ;

        private final String text;

        UserLabels(final String text) { this.text = text; }

        @Override
        public String toString() {
            return text;
        }
    }

    public String getFullName() { return firstName + " " + lastName; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public boolean isExternalUser() { return isExternalUser; }

    public void setExternalUser(boolean externalUser) { isExternalUser = externalUser; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public boolean isSendEmail() { return sendEmail; }

    public void setSendEmail(boolean sendEmail) { this.sendEmail = sendEmail; }

}
