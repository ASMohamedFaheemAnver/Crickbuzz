package com.company.Repository;

import java.sql.*;

public class DatabaseRepository {
    Connection sqlcon;
    Statement sqlst;
    ResultSet sqlrs;

    public DatabaseRepository(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            System.out.println("Done!");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        DatabaseRepository connect = new DatabaseRepository();
    }
}
