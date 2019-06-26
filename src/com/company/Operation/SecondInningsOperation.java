package com.company.Operation;

import com.company.Crickbuzzpage.CrickbuzzPage;
import com.company.Crickbuzzpage.SecondInningsPage;

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
        firstInnings.Display();
    }
}
