package com.company.operation;

import com.company.crickbuzzpage.CrickbuzzPage;
import com.company.crickbuzzpage.FirstInningsPage;

import java.sql.ResultSet;


public class FirstInningsOperation implements Operation{
    private ResultSet rsfirstInningsBatting;
    private ResultSet rsfirstInningsBowling;
    public FirstInningsOperation(ResultSet rsfirstInningsBatting, ResultSet rsFirstInningsBowling){
        this.rsfirstInningsBatting = rsfirstInningsBatting;
        this.rsfirstInningsBowling = rsFirstInningsBowling;
    }

    @Override
    public void perform() {
        CrickbuzzPage firstInnings = new FirstInningsPage(rsfirstInningsBatting, rsfirstInningsBowling);
        firstInnings.Display();
    }
}