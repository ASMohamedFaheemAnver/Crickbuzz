package com.company.operation;

import com.company.repository.DatabaseRepository;
import com.company.repository.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OperationFactory{
    public VoidOperation getInstance(String operator, int matchID) throws SQLException {
        Repository data = new DatabaseRepository();
        ResultSet rsInningsBatting;
        ResultSet rsInningsBowling;
        ResultSet rsmatchOverview;
        int totalRun;
        int totalWicket;

        VoidOperation operation = null;
        IntOperation rtotalRun = new CalculateTotalOperation();
        IntOperation rtotalWicket = new CalculateTotalOperation();


        if ("First Innings".equals(operator)){
            String qr = "SELECT NAME, RUN, BALL, FOUR, SIX, SR FROM `MATCHBATTING` WHERE MATCHID = " + matchID + " AND INNINGS = \"FIRST\"";
            String qr2 = "SELECT NAME, MOVER, MAIDEN, RUN, WICKET, ECON FROM `MATCHBOWLING` WHERE MATCHID = " + matchID + " AND INNINGS = \"FIRST\"";
            if((rsInningsBatting = data.read(qr))!=null){
                rsInningsBowling = data.read(qr2);
                totalRun = rtotalRun.perform(qr, 1);
                totalWicket = rtotalWicket.perform(qr2, 2);
                operation = new FirstInningsOperation(rsInningsBatting, rsInningsBowling, totalRun, totalWicket);
            }
        }else if("Second Innings".equals(operator)){
            String qr = "SELECT NAME, RUN, BALL, FOUR, SIX, SR FROM `MATCHBATTING` WHERE MATCHID = " + matchID + " AND INNINGS = \"SECOND\"";
            String qr2 = "SELECT NAME, MOVER, MAIDEN, RUN, WICKET, ECON FROM `MATCHBOWLING` WHERE MATCHID = " + matchID + " AND INNINGS = \"SECOND\"";
            if((rsInningsBatting = data.read(qr))!=null){
                rsInningsBowling = data.read(qr2);
                totalRun = rtotalRun.perform(qr, 1);
                totalWicket = rtotalWicket.perform(qr2, 2);
                operation = new SecondInningsOperation(rsInningsBatting, rsInningsBowling, totalRun, totalWicket);
            }
        }else if("Innings Overview".equals(operator)){
            String qr = "SELECT TEAM, OVERVIEW FROM `MATCHOVERVIEW` WHERE MATCHID = " + matchID;
            if((rsmatchOverview = data.read(qr))!=null){
                operation = new OverviewInningsOperation(rsmatchOverview);
            }
        }else {
            operation = new DefaultOperation();
        }
        return operation;
    }
}
