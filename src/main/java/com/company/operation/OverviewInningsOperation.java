package com.company.operation;

import com.company.crickbuzzpage.CrickbuzzPage;
import com.company.crickbuzzpage.OverviewInningsPage;

import java.sql.ResultSet;

public class OverviewInningsOperation implements VoidOperation{
    ResultSet rspreviewInnings;

    public OverviewInningsOperation(ResultSet rspreviewInnings){
        this.rspreviewInnings = rspreviewInnings;
    }

    @Override
    public void perform() {
        CrickbuzzPage overviewMatch = new OverviewInningsPage(rspreviewInnings);
        overviewMatch.display();
    }
}
