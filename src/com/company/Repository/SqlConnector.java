package com.company.Repository;

import java.sql.*;

public class SqlConnector {
    Connection sqlcon = null;

    public Connection ConnectToSql(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/Crickbuzz", "root", "");
            System.out.println("Done!");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sqlcon;
    }
}
