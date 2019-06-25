package com.company.Crickbuzzpage;

import net.proteanit.sql.DbUtils;

import javax.swing.*;

import java.awt.*;
import java.sql.ResultSet;


public class FirstInningsPage implements CrickbuzzPage{
    JFrame firstInningsFrame;
    JTable firstBattingtable;

    private JLabel titleofFirstInnings = new JLabel();
    ResultSet rsfirstInnings;




    public FirstInningsPage(JFrame firstInningsFrame, ResultSet rsfirstInnings){
        this.firstInningsFrame = firstInningsFrame;
        this.rsfirstInnings = rsfirstInnings;
    }


    @Override
    public void Display() {
        titleofFirstInnings.setText("FIRST INNINGS SCORECARD!");

        titleofFirstInnings.setBounds(650, 0, 700, 100);

        titleofFirstInnings.setFont(new Font("Serif", Font.BOLD, 25));

        firstInningsFrame.add(titleofFirstInnings);

        firstBattingtable = new JTable();

        String column[]={"NAME","RUN","BALL", "SIX", "FOUR", "S/R"};

        firstBattingtable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                column
        ));
        firstBattingtable.setBounds(30, 100, 900, 800);
        JScrollPane sp = new JScrollPane(firstBattingtable);
        sp.setBounds(firstBattingtable.getBounds());
        firstInningsFrame.add(sp);

        firstInningsFrame.setSize(1920, 1050);
        firstInningsFrame.setLayout(null);
        firstInningsFrame.setVisible(true);

        firstBattingtable.setModel(DbUtils.resultSetToTableModel(rsfirstInnings));
    }



    @Override
    public void ClearResult() {

    }

    @Override
    public void ShowResult() {

    }
}
