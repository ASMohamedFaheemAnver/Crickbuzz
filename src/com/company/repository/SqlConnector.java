package com.company.repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnector {
    Connection sqlcon = null;

    public Connection connectToSql(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/Crickbuzz", "root", "");
        }catch (ClassNotFoundException ex){
            ex.getMessage();
        } catch (SQLException e) {
            e.getMessage();
        }

        return sqlcon;
    }
}