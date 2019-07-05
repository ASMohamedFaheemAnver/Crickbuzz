package com.company.crickbuzzpage;

import net.proteanit.sql.DbUtils;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class InningsPage implements CrickbuzzPage{
    private JFrame InningsFrame = new JFrame();
    private JTable Battingtable;
    private JTable Bowlingtable;

    private JLabel titleofInnings = new JLabel();
    private JLabel titleofInningsBatting = new JLabel();
    private JLabel titleofInningsBowling = new JLabel();
    private JLabel totalRun = new JLabel();
    private JLabel totalWicket = new JLabel();

    private ResultSet rsInningsBatting;
    private ResultSet rsInningsBowling;
    private JButton InningsDone;




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

        InningsDone = new JButton("DONE");


        titleofInnings.setBounds(650, 0, 700, 100);
        titleofInningsBatting.setBounds(370, 150, 900, 40);
        titleofInningsBowling.setBounds(1290, 150, 900, 40);
        InningsDone.setBounds(1690, 950, 100, 40);

        titleofInnings.setFont(new Font("Serif", Font.BOLD, 25));
        titleofInningsBatting.setFont(new Font(titleofInningsBatting.getFont().toString(), Font.BOLD, 20));
        titleofInningsBowling.setFont(new Font(titleofInningsBowling.getFont().toString(), Font.BOLD, 20));

        InningsFrame.add(titleofInnings);
        InningsFrame.add(titleofInningsBatting);
        InningsFrame.add(titleofInningsBowling);
        InningsFrame.add(InningsDone);

        Battingtable = new JTable();
        Bowlingtable = new JTable();


        Battingtable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                null
        ));

        Bowlingtable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                null
        ));

        Battingtable.setRowHeight(60);
        Bowlingtable.setRowHeight(60);

        Battingtable.setBounds(70, 200, 800, 622);
        Bowlingtable.setBounds(990, 200, 800, 322);

        totalRun.setBounds(70, 800, 800, 100);
        totalWicket.setBounds(990, 500, 800, 100);

        totalRun.setFont(new Font(titleofInningsBatting.getFont().toString(), Font.BOLD, 20));
        totalWicket.setFont(new Font(titleofInningsBatting.getFont().toString(), Font.BOLD, 20));

        InningsFrame.add(totalRun);
        InningsFrame.add(totalWicket);


        JScrollPane sp = new JScrollPane(Battingtable);
        sp.setBounds(Battingtable.getBounds());
        InningsFrame.add(sp);

        JScrollPane sp2 = new JScrollPane(Bowlingtable);
        sp2.setBounds(Bowlingtable.getBounds());
        InningsFrame.add(sp2);

        InningsFrame.setSize(1920, 1050);
        InningsFrame.setLayout(null);
        InningsFrame.setVisible(true);

        Battingtable.setModel(DbUtils.resultSetToTableModel(rsInningsBatting));
        Bowlingtable.setModel(DbUtils.resultSetToTableModel(rsInningsBowling));

        InningsDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrickbuzzPage defaultPage = new DefaultCrickbuzzPage();
                InningsFrame.setVisible(false);
                defaultPage.display();
            }
        });
    }

}
