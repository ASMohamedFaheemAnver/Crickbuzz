package com.company;


import com.company.Crickbuzzpage.CrickbuzzPage;
import com.company.Crickbuzzpage.FirstInningsPage;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Test {

    public static void main(String[] args) {
        JFrame  jf = new JFrame();
        CrickbuzzPage x = new FirstInningsPage(jf);
        x.Display();
    }
}