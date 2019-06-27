package com.company.operation;

import com.company.crickbuzzpage.CrickbuzzPage;
import com.company.crickbuzzpage.SecondInningsPage;

import java.sql.ResultSet;

public class SecondInningsOperation implements Operation{

    private ResultSet rsfirstInningsBatting;
    private ResultSet rsfirstInningsBowling;

    public SecondInningsOperation(ResultSet rsfirstInningsBatting, ResultSet rsfirstInningsBowling){
        this.rsfirstInningsBatting = rsfirstInningsBatting;
        this.rsfirstInningsBowling = rsfirstInningsBowling;
    }

    @Override
    public void perform() {
        CrickbuzzPage firstInnings = new SecondInningsPage(rsfirstInningsBatting, rsfirstInningsBowling);
        firstInnings.display();
    }
}
