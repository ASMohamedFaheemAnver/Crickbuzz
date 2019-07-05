package com.company.operation;


import java.sql.ResultSet;
import java.sql.SQLException;

public class CalculateTotalRunsOperation implements FloatOperation{
    private ResultSet runs;

    public CalculateTotalRunsOperation(ResultSet runs){
        this.runs = runs;
    }

    @Override
    public float perform() throws SQLException {
        float totalRun = 0;
        String stringRun;
        while (runs.next()){
            totalRun += Float.parseFloat(runs.getString("RUN"));
        }
        return totalRun;
    }
}
