package com.company.Crickbuzzpage;

import net.proteanit.sql.DbUtils;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class FirstInningsPage implements CrickbuzzPage{
    JFrame firstInningsFrame = new JFrame();
    JTable firstBattingtable;
    JTable firstBowlingtable;

    private JLabel titleofFirstInnings = new JLabel();
    private JLabel titleofFirstInningsBatting = new JLabel();
    private JLabel titleofFirstInningsBowling = new JLabel();
    ResultSet rsfirstInningsBatting;
    ResultSet rsFirstInningsBowling;
    JButton firstInningsDone;




    public FirstInningsPage(ResultSet rsfirstInningsBatting, ResultSet rsFirstInningsBowling){
        this.rsfirstInningsBatting = rsfirstInningsBatting;
        this.rsFirstInningsBowling = rsFirstInningsBowling;
    }


    @Override
    public void Display() {
        titleofFirstInnings.setText("FIRST INNINGS SCORECARD!");
        titleofFirstInningsBatting.setText("FIRST INNINGS BATTING!");
        titleofFirstInningsBowling.setText("FIRST INNINGS BOWLING!");

        firstInningsDone = new JButton("DONE");


        titleofFirstInnings.setBounds(650, 0, 700, 100);
        titleofFirstInningsBatting.setBounds(370, 150, 900, 40);
        titleofFirstInningsBowling.setBounds(1290, 150, 900, 40);
        firstInningsDone.setBounds(1690, 950, 100, 40);

        titleofFirstInnings.setFont(new Font("Serif", Font.BOLD, 25));
        titleofFirstInningsBatting.setFont(new Font(titleofFirstInningsBatting.getFont().toString(), Font.BOLD, 20));
        titleofFirstInningsBowling.setFont(new Font(titleofFirstInningsBowling.getFont().toString(), Font.BOLD, 20));

        firstInningsFrame.add(titleofFirstInnings);
        firstInningsFrame.add(titleofFirstInningsBatting);
        firstInningsFrame.add(titleofFirstInningsBowling);
        firstInningsFrame.add(firstInningsDone);

        firstBattingtable = new JTable();
        firstBowlingtable = new JTable();

        String battingColumn[]={"NAME","RUN","BALL", "SIX", "FOUR", "S/R"};
        String bowlingColoumn[]={"NAME", "OVER", "MAIDEN", "RUN", "WICKET", "ECON"};

        firstBattingtable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                battingColumn
        ));

        firstBowlingtable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                bowlingColoumn
        ));

        firstBattingtable.setBounds(70, 200, 800, 700);
        firstBowlingtable.setBounds(990, 200, 800, 700);


        JScrollPane sp = new JScrollPane(firstBattingtable);
        sp.setBounds(firstBattingtable.getBounds());
        firstInningsFrame.add(sp);

        JScrollPane sp2 = new JScrollPane(firstBowlingtable);
        sp2.setBounds(firstBowlingtable.getBounds());
        firstInningsFrame.add(sp2);

        firstInningsFrame.setSize(1920, 1050);
        firstInningsFrame.setLayout(null);
        firstInningsFrame.setVisible(true);

        firstBattingtable.setModel(DbUtils.resultSetToTableModel(rsfirstInningsBatting));
        firstBowlingtable.setModel(DbUtils.resultSetToTableModel(rsFirstInningsBowling));

        firstInningsDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrickbuzzPage defaultPage = new DefaultCrickbuzzPage();
                firstInningsFrame.setVisible(false);
                defaultPage.Display();
            }
        });
    }

}
