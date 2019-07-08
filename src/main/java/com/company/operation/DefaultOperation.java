package com.company.operation;

import com.company.crickbuzzpage.CrickbuzzPage;
import com.company.crickbuzzpage.DefaultCrickbuzzPage;


public class DefaultOperation implements VoidOperation{
    @Override
    public void perform() {
        CrickbuzzPage page = new DefaultCrickbuzzPage();
        page.display();
    }
}
