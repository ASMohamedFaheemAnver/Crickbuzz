package com.company.operation;

import com.company.repository.DatabaseRepository;
import com.company.repository.Repository;

import java.sql.ResultSet;

public class OperationFactory{
    public Operation getInstance(String operator, int matchID){
        Repository data = new DatabaseRepository();
        ResultSet rsInningsBatting;
        ResultSet rsInningsBowling;
        ResultSet rsmatchOverview;

        Operation operation = null;
        if ("First Innings".equals(operator)){
            String qr = "SELECT NAME, RUN, BALL, FOUR, SIX, SR FROM `MATCHBATTING` WHERE MATCHID = " + matchID + " AND INNINGS = \"FIRST\"";
            String qr2 = "SELECT NAME, MOVER, MAIDEN, RUN, WICKET, ECON FROM `MATCHBOWLING` WHERE MATCHID = " + matchID + " AND INNINGS = \"FIRST\"";
            if((rsInningsBatting = data.read(qr)).equals(null)){

            }else {
                rsInningsBowling = data.read(qr2);
                operation = new FirstInningsOperation(rsInningsBatting, rsInningsBowling);
            }
        }else if("Second Innings".equals(operator)){
            String qr = "SELECT NAME, RUN, BALL, FOUR, SIX, SR FROM `MATCHBATTING` WHERE MATCHID = " + matchID + " AND INNINGS = \"SECOND\"";
            String qr2 = "SELECT NAME, MOVER, MAIDEN, RUN, WICKET, ECON FROM `MATCHBOWLING` WHERE MATCHID = " + matchID + " AND INNINGS = \"SECOND\"";
            if((rsInningsBatting = data.read(qr)).equals(null)){

            }else {
                rsInningsBowling = data.read(qr2);
                operation = new SecondInningsOperation(rsInningsBatting, rsInningsBowling);
            }
        }else if("Innings Overview".equals(operator)){
            String qr = "SELECT TEAM, OVERVIEW FROM `MATCHOVERVIEW` WHERE MATCHID = " + matchID;
            if((rsmatchOverview = data.read(qr)).equals(null)){

            }else{
                operation = new OverviewInningsOperation(rsmatchOverview);
            }
        }else {
            operation = new DefaultOperation();
        }
        return operation;
    }
}
