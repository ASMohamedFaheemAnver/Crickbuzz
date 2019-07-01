package com.company.crickbuzzpage;


import java.sql.ResultSet;

public class SecondInningsPage extends InningsPage{

    public SecondInningsPage(ResultSet rsInningsBatting, ResultSet rsInningsBowling, String titleofInnings, String titleofInningsBatting, String titleofInningsBowling, String[] battingColumn, String[] bowlingColoumn) {
        super(rsInningsBatting, rsInningsBowling, titleofInnings, titleofInningsBatting, titleofInningsBowling, battingColumn, bowlingColoumn);
    }
}
