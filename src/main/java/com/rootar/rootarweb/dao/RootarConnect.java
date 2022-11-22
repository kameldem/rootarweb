package com.rootar.rootarweb.dao;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.Connection;

public class RootarConnect {

    private final static String SERVER_NAME="10.115.58.232";
    private final static int PORT_NUMBER =1401;
    private final static String DATABASE_NAME="ROOTAR";

    private final static String USER="sa";
    private final static String PASSWORD="azerty@123456";
    private static Connection connexion;
    private RootarConnect() {

    }

    public static Connection getInstance() {
        if (connexion == null) {
            try {
                SQLServerDataSource ds = new SQLServerDataSource();
                ds.setServerName(SERVER_NAME);
                ds.setPortNumber(PORT_NUMBER);
                ds.setDatabaseName(DATABASE_NAME);
                ds.setIntegratedSecurity(false);
                ds.setEncrypt(false);
                ds.setUser(USER);
                ds.setPassword(PASSWORD);
                connexion = ds.getConnection();
            }

            // Handle any errors that may have occurred.
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connexion;
    }
}