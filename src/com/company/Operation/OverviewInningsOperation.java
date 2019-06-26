package com.company.Operation;

import com.company.Crickbuzzpage.CrickbuzzPage;
import com.company.Crickbuzzpage.OverviewInningsPage;

import java.sql.ResultSet;

public class OverviewInningsOperation implements Operation{
    ResultSet rspreviewInnings;

    public OverviewInningsOperation(ResultSet rspreviewInnings){
        this.rspreviewInnings = rspreviewInnings;
    }

    @Override
    public void perform() {
        CrickbuzzPage overviewMatch = new OverviewInningsPage(rspreviewInnings);
        overviewMatch.Display();
    }
}
