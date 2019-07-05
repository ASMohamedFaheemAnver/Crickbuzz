package com.company.operation;

import com.company.crickbuzzpage.CrickbuzzPage;
import com.company.crickbuzzpage.InningsPage;

import java.sql.ResultSet;


public class FirstInningsOperation implements VoidOperation{
    private ResultSet rsfirstInningsBatting;
    private ResultSet rsfirstInningsBowling;
    private String[] battingColumn = {"","","", "", "", ""};
    private String[] bowlingColoumn = {"", "", "", "", "", ""};
    private String titleOfFirstInnings = "FIRST INNINGS SCORECARD!";
    private String titleOfFirstInningsBatting = "FIRST INNINGS BATTING!";
    private String titleOfFirstInningsBowling = "FIRST INNINGS BOWLING!";
    public FirstInningsOperation(ResultSet rsfirstInningsBatting, ResultSet rsFirstInningsBowling){
        this.rsfirstInningsBatting = rsfirstInningsBatting;
        this.rsfirstInningsBowling = rsFirstInningsBowling;
    }

    @Override
    public void perform() {
        CrickbuzzPage firstInnings = new InningsPage(rsfirstInningsBatting, rsfirstInningsBowling, titleOfFirstInnings, titleOfFirstInningsBatting, titleOfFirstInningsBowling, battingColumn, bowlingColoumn);
        firstInnings.display();
    }
}