package com.company.Repository;

import java.sql.*;

public class DatabaseRepository implements Repository{

    @Override
    public ResultSet read(String quary) {
        ResultSet sqlres = null;
        try{
            SqlConnector con = new SqlConnector();
            Connection sqlcon = con.ConnectToSql();
            PreparedStatement sqlstat = con.sqlcon.prepareStatement(quary);
            sqlres = sqlstat.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sqlres;
    }
}
