package com.company.operation;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CalculateTotalWicketOperation implements FloatOperation{
    private ResultSet wicket;

    public CalculateTotalWicketOperation(ResultSet wicket){
        this.wicket = wicket;
    }

    @Override
    public float perform() throws SQLException {
        float totalRun = 0;
        String stringRun;
        while (wicket.next()){
            totalRun += Float.parseFloat(wicket.getString("WICKET"));
        }
        return totalRun;
    }
}
