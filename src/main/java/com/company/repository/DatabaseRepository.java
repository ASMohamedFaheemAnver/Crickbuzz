package com.company.repository;


import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DatabaseRepository implements Repository{

    @Override
    public ResultSet read(String quary) {
        ResultSet sqlres = null;
        PreparedStatement sqlstat;
        try{
            SqlConnector con = new SqlConnector();
            Connection sqlcon = con.connectToSql();
            sqlstat = sqlcon.prepareStatement(quary);
            sqlres = sqlstat.executeQuery();
        } catch (SQLException e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, "THERE WAS AN SQL EXCEPTION!");
        }catch (Exception e){
            e.getMessage();
            JOptionPane.showMessageDialog(null, "   CAN'T CONNECT TO THE DATABASE!");
        }
        return sqlres;
    }
}
