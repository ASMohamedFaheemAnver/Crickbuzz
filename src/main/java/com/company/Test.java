package com.company;

import com.company.operation.CalculateTotalRunsOperation;
import com.company.operation.CalculateTotalWicketOperation;
import com.company.operation.FloatOperation;
import com.company.repository.DatabaseRepository;
import com.company.repository.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        Repository rs = new DatabaseRepository();
        ResultSet xx = rs.read("SELECT * FROM `MATCHBOWLING` WHERE MATCHID = 1 AND INNINGS = \"SECOND\"");
        FloatOperation x = new CalculateTotalWicketOperation(xx);
        float xxx = x.perform();
        System.out.print(xxx);
    }
}
