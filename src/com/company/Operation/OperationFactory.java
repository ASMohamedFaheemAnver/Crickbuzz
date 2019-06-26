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
            System.out.println(qr);
            String qr2 = "SELECT NAME, MOVER, MAIDEN, RUN, WICKET, ECON FROM `MATCHBOWLING` WHERE MATCHID = " + matchID + " AND INNINGS = \"FIRST\"";
            System.out.println(qr2);
            rsfirstInningsBatting = data.read(qr);
            rsfirstInningsBowling = data.read(qr2);
            operation = new FirstInningsOperation(rsfirstInningsBatting, rsfirstInningsBowling);
        }


        return operation;
    }
}
