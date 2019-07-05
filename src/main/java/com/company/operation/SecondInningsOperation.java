package com.company.operation;

import com.company.crickbuzzpage.CrickbuzzPage;
import com.company.crickbuzzpage.InningsPage;

import java.sql.ResultSet;

public class SecondInningsOperation implements Operation{

    private ResultSet rssecondInningsBatting;
    private ResultSet rssecondInningsBowling;
    private String[] battingColumn = {"","","", "", "", ""};
    private String[] bowlingColoumn = {"", "", "", "", "", ""};
    private String titleOfsecondInnings = "SECOND INNINGS SCORECARD!";
    private String titleOfsecondInningsBatting = "SECOND INNINGS BATTING!";
    private String titleOfsecondInningsBowling = "SECOND INNINGS BOWLING!";
    public SecondInningsOperation(ResultSet rssecondInningsBatting, ResultSet rssecondInningsBowling){
        this.rssecondInningsBatting = rssecondInningsBatting;
        this.rssecondInningsBowling = rssecondInningsBowling;
    }

    @Override
    public void perform() {
        CrickbuzzPage secondInnings = new InningsPage(rssecondInningsBatting, rssecondInningsBowling, titleOfsecondInnings, titleOfsecondInningsBatting, titleOfsecondInningsBowling, battingColumn, bowlingColoumn);
        secondInnings.display();
    }
}
