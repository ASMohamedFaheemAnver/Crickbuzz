package main.java.com.company.operation;

import main.java.com.company.crickbuzzpage.CrickbuzzPage;
import main.java.com.company.crickbuzzpage.DefaultCrickbuzzPage;


public class DefaultPageOperation implements Operation{
    @Override
    public void perform() {
        CrickbuzzPage firstInnings = new DefaultCrickbuzzPage();
        firstInnings.display();
    }
}
