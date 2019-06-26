package com.company.Operation;

import com.company.Crickbuzzpage.CrickbuzzPage;
import com.company.Crickbuzzpage.DefaultCrickbuzzPage;

import javax.swing.*;

public class DefaultPageOperation implements Operation{
    @Override
    public void perform() {
        CrickbuzzPage firstInnings = new DefaultCrickbuzzPage();
        firstInnings.Display();
    }
}
