package com.company.operation;

import com.company.crickbuzzpage.CrickbuzzPage;
import com.company.crickbuzzpage.InningsPage;

import java.sql.ResultSet;


public class FirstInningsOperation implements VoidOperation{
    private ResultSet rsfirstInningsBatting;
    private ResultSet rsfirstInningsBowling;
    private String titleOfFirstInnings = "FIRST INNINGS SCORECARD!";
    private String titleOfFirstInningsBatting = "FIRST INNINGS BATTING!";
    private String titleOfFirstInningsBowling = "FIRST INNINGS BOWLING!";
    private int totalRun;
    private int totalWicket;
    public FirstInningsOperation(ResultSet rsfirstInningsBatting, ResultSet rsFirstInningsBowling, int totalRun, int totalWicket){
        this.rsfirstInningsBatting = rsfirstInningsBatting;
        this.rsfirstInningsBowling = rsFirstInningsBowling;
        this.totalRun = totalRun;
        this.totalWicket = totalWicket;
    }

    @Override
    public void perform() {
        CrickbuzzPage firstInnings = new InningsPage(rsfirstInningsBatting, rsfirstInningsBowling, titleOfFirstInnings, titleOfFirstInningsBatting, titleOfFirstInningsBowling, totalRun, totalWicket);
        firstInnings.display();
    }
}