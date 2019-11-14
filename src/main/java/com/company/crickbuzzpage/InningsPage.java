package com.company.crickbuzzpage;

import net.proteanit.sql.DbUtils;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;


import java.awt.Font;
import java.sql.ResultSet;


public class InningsPage implements CrickbuzzPage{
    JFrame inningsFrame = new JFrame();
    JTable battingTable;
    JTable bowlingTable;

    private JLabel titleofInnings = new JLabel();
    private JLabel titleofInningsBatting = new JLabel();
    private JLabel titleofInningsBowling = new JLabel();
    private JLabel totalRun = new JLabel();
    private JLabel totalWicket = new JLabel();

    private ResultSet rsInningsBatting;
    private ResultSet rsInningsBowling;
    JButton inningsDone;




    public InningsPage(ResultSet rsInningsBatting, ResultSet rsInningsBowling, String titleofInnings,
                       String titleofInningsBatting, String titleofInningsBowling, int totalRun, int totalWicket){
        this.rsInningsBatting = rsInningsBatting;
        this.rsInningsBowling = rsInningsBowling;
        this.titleofInnings.setText(titleofInnings);
        this.titleofInningsBatting.setText(titleofInningsBatting);
        this.titleofInningsBowling.setText(titleofInningsBowling);
        this.totalRun.setText("TOTAL RUN IS : " + totalRun);
        this.totalWicket.setText("TOTAL WICKET IS : " + totalWicket);
    }


    @Override
    public void display() {

        inningsDone = new JButton("DONE");


        titleofInnings.setBounds(650, 0, 700, 100);
        titleofInningsBatting.setBounds(370, 150, 900, 40);
        titleofInningsBowling.setBounds(1290, 150, 900, 40);
        inningsDone.setBounds(1690, 950, 100, 40);

        titleofInnings.setFont(new Font("Serif", Font.BOLD, 25));
        titleofInningsBatting.setFont(new Font(titleofInningsBatting.getFont().toString(), Font.BOLD, 20));
        titleofInningsBowling.setFont(new Font(titleofInningsBowling.getFont().toString(), Font.BOLD, 20));

        inningsFrame.add(titleofInnings);
        inningsFrame.add(titleofInningsBatting);
        inningsFrame.add(titleofInningsBowling);
        inningsFrame.add(inningsDone);

        battingTable = new JTable();
        bowlingTable = new JTable();


        battingTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                null
        ));

        bowlingTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                null
        ));

        battingTable.setRowHeight(60);
        bowlingTable.setRowHeight(60);

        battingTable.setBounds(70, 200, 800, 622);
        bowlingTable.setBounds(990, 200, 800, 322);

        totalRun.setBounds(70, 800, 800, 100);
        totalWicket.setBounds(990, 500, 800, 100);

        totalRun.setFont(new Font(titleofInningsBatting.getFont().toString(), Font.BOLD, 20));
        totalWicket.setFont(new Font(titleofInningsBatting.getFont().toString(), Font.BOLD, 20));

        inningsFrame.add(totalRun);
        inningsFrame.add(totalWicket);


        JScrollPane sp = new JScrollPane(battingTable);
        sp.setBounds(battingTable.getBounds());
        inningsFrame.add(sp);

        JScrollPane sp2 = new JScrollPane(bowlingTable);
        sp2.setBounds(bowlingTable.getBounds());
        inningsFrame.add(sp2);

        inningsFrame.setSize(1920, 1050);
        inningsFrame.setLayout(null);
        inningsFrame.setVisible(true);

        battingTable.setModel(DbUtils.resultSetToTableModel(rsInningsBatting));
        bowlingTable.setModel(DbUtils.resultSetToTableModel(rsInningsBowling));

        inningsDone.addActionListener(actionEvent -> {
            CrickbuzzPage defaultPage = new DefaultCrickbuzzPage();
            inningsFrame.setVisible(false);
            defaultPage.display();
        });
    }

}
