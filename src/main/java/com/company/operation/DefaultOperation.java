package main.java.com.company.operation;

import main.java.com.company.crickbuzzpage.CrickbuzzPage;
import main.java.com.company.crickbuzzpage.DefaultCrickbuzzPage;


public class DefaultOperation implements Operation{
    @Override
    public void perform() {
        CrickbuzzPage firstInnings = new DefaultCrickbuzzPage();
        firstInnings.display();
    }
}
