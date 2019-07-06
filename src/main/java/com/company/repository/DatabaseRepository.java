package com.company.repository;


import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;


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
            LOGGER.log(Level.INFO, "Got an exception.", e);
            JOptionPane.showMessageDialog(null, "THERE WAS AN SQL EXCEPTION!");
        }catch (Exception e){
            LOGGER.log(Level.INFO, "Got an exception.", e);
            JOptionPane.showMessageDialog(null, "   CAN'T CONNECT TO THE DATABASE!");
        }
        return sqlres;
    }
}
