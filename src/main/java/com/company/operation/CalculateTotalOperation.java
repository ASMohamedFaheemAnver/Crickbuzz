package com.company.operation;


import com.company.repository.DatabaseRepository;
import com.company.repository.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CalculateTotalOperation implements IntOperation{
    private int totalResult = 0;
    @Override
    public int perform(String qr, int choice) throws SQLException {
        Repository total = new DatabaseRepository();
        ResultSet temp = total.read(qr);
        while (temp.next()){
            if(choice==1){
                totalResult += Integer.parseInt(temp.getString("RUN"));
            }else if (choice==2){
                totalResult += Integer.parseInt(temp.getString("WICKET"));
            }
        }
        return totalResult;
    }
}
