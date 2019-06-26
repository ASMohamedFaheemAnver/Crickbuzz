package com.company;


import com.company.Crickbuzzpage.CrickbuzzPage;
import com.company.Crickbuzzpage.DefaultCrickbuzzPage;
import com.company.Crickbuzzpage.FirstInningsPage;
import com.company.Repository.DatabaseRepository;
import com.company.Repository.Repository;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.ResultSet;
import java.sql.SQLException;

import static javax.swing.UIManager.getString;

public class Test {



    public static void main(String[] args) {
        JFrame jj = new JFrame();
        Repository x = new DatabaseRepository();
        ResultSet res = x.read("SELECT NAME, RUN, BALL, FOUR, SIX, SR FROM `MATCHBATTING` WHERE 1");
        CrickbuzzPage xxx = new FirstInningsPage(jj, res, res);
        xxx.Display();
        boolean xl = xxx.IsNextPageClicked();
    }
}