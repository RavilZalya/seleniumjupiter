/*
 * Copyright (C) 2018-2019. Ad-Juster, Inc - All Rights Reserved
 * Proprietary and confidential
 *
 */

package com.adjuster.hbadger.uitest.data;

public class ConnectionData {

    private Connections connection;
    private String name;


    public ConnectionData() {

        connection = Connections.AppNexus;
        name = "Connection 1";
    }

    public String getConnection() {
        return connection.toString();
    }

    public void setConnection(Connections connection) {
        this.connection = connection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
