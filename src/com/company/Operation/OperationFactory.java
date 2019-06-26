package com.company.Operation;

import com.company.Crickbuzzpage.CrickbuzzPage;
import com.company.Crickbuzzpage.FirstInningsPage;
import com.company.Repository.DatabaseRepository;
import com.company.Repository.Repository;

import java.sql.ResultSet;

public class OperationFactory{
    public Operation getInstance(String operator, int matchID){
        Repository data = new DatabaseRepository();
        ResultSet rsfirstInningsBatting, rsfirstInningsBowling, rssecondInningsBatting,
                rssecondInningsBowling, rsmatchOverview;

        Operation operation = null;
        if ("First Innings".equals(operator)){
            String qr = "SELECT NAME, RUN, BALL, FOUR, SIX, SR FROM `MATCHBATTING` WHERE MATCHID = " + matchID + " AND INNINGS = \"FIRST\"";
            String qr2 = "SELECT NAME, MOVER, MAIDEN, RUN, WICKET, ECON FROM `MATCHBOWLING` WHERE MATCHID = " + matchID + " AND INNINGS = \"FIRST\"";
            rsfirstInningsBatting = data.read(qr);
            rsfirstInningsBowling = data.read(qr2);
            operation = new FirstInningsOperation(rsfirstInningsBatting, rsfirstInningsBowling);
        }else if("Second Innings".equals(operator)){
            String qr = "SELECT NAME, RUN, BALL, FOUR, SIX, SR FROM `MATCHBATTING` WHERE MATCHID = " + matchID + " AND INNINGS = \"SECOND\"";
            String qr2 = "SELECT NAME, MOVER, MAIDEN, RUN, WICKET, ECON FROM `MATCHBOWLING` WHERE MATCHID = " + matchID + " AND INNINGS = \"SECOND\"";
            rssecondInningsBatting = data.read(qr);
            rssecondInningsBowling = data.read(qr2);
            operation = new SecondInningsOperation(rssecondInningsBatting, rssecondInningsBowling);
        }else if("Innings Overview".equals(operator)){
            String qr = "SELECT TEAM, OVERVIEW FROM `MATCHOVERVIEW` WHERE MATCHID = " + matchID;
            rsmatchOverview = data.read(qr);
            operation = new OverviewInningsOperation(rsmatchOverview);
        }else{
            operation = new DefaultPageOperation();
        }


        return operation;
    }
}
