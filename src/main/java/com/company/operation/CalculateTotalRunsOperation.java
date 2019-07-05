package com.company.operation;


import java.sql.ResultSet;
import java.sql.SQLException;

public class CalculateTotalRunsOperation implements FloatOperation{
    private ResultSet runs;

    CalculateTotalRunsOperation(ResultSet runs){
        this.runs = runs;
    }

    @Override
    public float perform() throws SQLException {
        float totalRun = 0;
        String stringRun;
        while ((stringRun = runs.getString("RUN")).equals(null)){
            totalRun += Float.parseFloat(stringRun);
        }
        return totalRun;
    }
}
