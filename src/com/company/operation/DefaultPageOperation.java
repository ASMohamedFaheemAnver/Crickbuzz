package com.company.operation;

import com.company.crickbuzzpage.CrickbuzzPage;
import com.company.crickbuzzpage.DefaultCrickbuzzPage;

import javax.swing.*;

public class DefaultPageOperation implements Operation{
    @Override
    public void perform() {
        CrickbuzzPage firstInnings = new DefaultCrickbuzzPage();
        firstInnings.Display();
    }
}
