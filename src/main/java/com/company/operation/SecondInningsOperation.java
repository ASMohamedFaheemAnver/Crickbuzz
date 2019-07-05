package com.company.operation;

import com.company.crickbuzzpage.CrickbuzzPage;
import com.company.crickbuzzpage.InningsPage;

import java.sql.ResultSet;

public class SecondInningsOperation implements VoidOperation{

    private ResultSet rssecondInningsBatting;
    private ResultSet rssecondInningsBowling;
    private String titleOfsecondInnings = "SECOND INNINGS SCORECARD!";
    private String titleOfsecondInningsBatting = "SECOND INNINGS BATTING!";
    private String titleOfsecondInningsBowling = "SECOND INNINGS BOWLING!";
    private int totalRun;
    private int totalWicket;

    public SecondInningsOperation(ResultSet rssecondInningsBatting, ResultSet rssecondInningsBowling, int totalRun, int totalWicket){
        this.rssecondInningsBatting = rssecondInningsBatting;
        this.rssecondInningsBowling = rssecondInningsBowling;
        this.totalRun = totalRun;
        this.totalWicket = totalWicket;
    }

    @Override
    public void perform() {
        CrickbuzzPage secondInnings = new InningsPage(rssecondInningsBatting, rssecondInningsBowling, titleOfsecondInnings, titleOfsecondInningsBatting, titleOfsecondInningsBowling, totalRun, totalWicket);
        secondInnings.display();
    }
}
