package com.epam.esm.model.dao;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
/**
 * Class of data base connection pool properties
 */
public class DBCPBase{

    private static BasicDataSource ds = new BasicDataSource();

    static {
        //ds.setUrl("jdbc:h2:mem:test");
        ds.setUrl("jdbc:mysql://localhost:3306/giftcertificates?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("root");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    private DBCPBase(){ }
}
