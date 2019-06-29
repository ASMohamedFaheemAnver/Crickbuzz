package com.company.operation;

import com.company.crickbuzzpage.CrickbuzzPage;
import com.company.crickbuzzpage.DefaultCrickbuzzPage;


public class DefaultOperation implements Operation{
    @Override
    public void perform() {
        CrickbuzzPage firstInnings = new DefaultCrickbuzzPage();
        firstInnings.display();
    }
}
