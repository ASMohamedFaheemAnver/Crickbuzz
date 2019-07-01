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
    JFrame InningsFrame = new JFrame();
    JTable Battingtable;
    JTable Bowlingtable;

    private JLabel titleofInnings = new JLabel();
    private JLabel titleofInningsBatting = new JLabel();
    private JLabel titleofInningsBowling = new JLabel();
    ResultSet rsInningsBatting;
    ResultSet rsInningsBowling;
    JButton InningsDone;

    private String[] battingColumn;
    private String[] bowlingColoumn;



    public InningsPage(ResultSet rsInningsBatting, ResultSet rsInningsBowling, String titleofInnings,
                       String titleofInningsBatting, String titleofInningsBowling, String[] battingColumn, String[] bowlingColoumn){
        this.rsInningsBatting = rsInningsBatting;
        this.rsInningsBowling = rsInningsBowling;
        this.titleofInnings.setText(titleofInnings);
        this.titleofInningsBatting.setText(titleofInningsBatting);
        this.titleofInningsBowling.setText(titleofInningsBowling);
    }


    @Override
    public void display() {
        /*
        titleofInnings.setText(" INNINGS SCORECARD!");
        titleofInningsBatting.setText(" INNINGS BATTING!");
        titleofInningsBowling.setText(" INNINGS BOWLING!");
         */

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

        /*
        String[] battingColumn = {"NAME","RUN","BALL", "SIX", "FOUR", "S/R"};
        String[] bowlingColoumn = {"NAME", "OVER", "MAIDEN", "RUN", "WICKET", "ECON"};
         */

        Battingtable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                battingColumn
        ));

        Bowlingtable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                bowlingColoumn
        ));

        Battingtable.setRowHeight(60);
        Bowlingtable.setRowHeight(60);

        Battingtable.setBounds(70, 200, 800, 622);
        Bowlingtable.setBounds(990, 200, 800, 322);


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
