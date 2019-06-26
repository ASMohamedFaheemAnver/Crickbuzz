package com.company;


import com.company.Crickbuzzpage.*;
import com.company.Operation.FirstInningsOperation;
import com.company.Operation.Operation;
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
        ResultSet res = x.read("SELECT TEAM, OVERVIEW FROM `MATCHOVERVIEW` WHERE 1");
        Operation fi = new FirstInningsOperation(res, res);
        fi.perform();
    }
}