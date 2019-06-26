package com.company.Crickbuzzpage;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SecondInningsPage implements CrickbuzzPage{
    JFrame secondInningsFrame = new JFrame();
    JTable secondBattingtable;
    JTable secondBowlingtable;
    private boolean isNext = false;

    private JLabel titleofsecondInnings = new JLabel();
    private JLabel titleofsecondInningsBatting = new JLabel();
    private JLabel titleofsecondInningsBowling = new JLabel();
    ResultSet rssecondInningsBatting;
    ResultSet rssecondInningsBowling;
    JButton secondInningsDone;




    public SecondInningsPage(ResultSet rssecondInningsBatting, ResultSet rssecondInningsBowling){
        this.rssecondInningsBatting = rssecondInningsBatting;
        this.rssecondInningsBowling = rssecondInningsBowling;
    }


    @Override
    public void Display() {
        titleofsecondInnings.setText("SECOND INNINGS SCORECARD!");
        titleofsecondInningsBatting.setText("SECOND INNINGS BATTING!");
        titleofsecondInningsBowling.setText("SECOND INNINGS BOWLING!");

        secondInningsDone = new JButton("DONE");


        titleofsecondInnings.setBounds(650, 0, 700, 100);
        titleofsecondInningsBatting.setBounds(370, 150, 900, 40);
        titleofsecondInningsBowling.setBounds(1290, 150, 900, 40);
        secondInningsDone.setBounds(1690, 950, 100, 40);

        titleofsecondInnings.setFont(new Font("Serif", Font.BOLD, 25));
        titleofsecondInningsBatting.setFont(new Font(titleofsecondInningsBatting.getFont().toString(), Font.BOLD, 20));
        titleofsecondInningsBowling.setFont(new Font(titleofsecondInningsBowling.getFont().toString(), Font.BOLD, 20));

        secondInningsFrame.add(titleofsecondInnings);
        secondInningsFrame.add(titleofsecondInningsBatting);
        secondInningsFrame.add(titleofsecondInningsBowling);
        secondInningsFrame.add(secondInningsDone);

        secondBattingtable = new JTable();
        secondBowlingtable = new JTable();

        String battingColumn[]={"NAME","RUN","BALL", "SIX", "FOUR", "S/R"};
        String bowlingColoumn[]={"NAME", "OVER", "MAIDEN", "RUN", "WICKET", "ECON"};

        secondBattingtable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                battingColumn
        ));

        secondBowlingtable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                bowlingColoumn
        ));

        secondBattingtable.setBounds(70, 200, 800, 700);
        secondBowlingtable.setBounds(990, 200, 800, 700);


        JScrollPane sp = new JScrollPane(secondBattingtable);
        sp.setBounds(secondBattingtable.getBounds());
        secondInningsFrame.add(sp);

        JScrollPane sp2 = new JScrollPane(secondBowlingtable);
        sp2.setBounds(secondBowlingtable.getBounds());
        secondInningsFrame.add(sp2);

        secondInningsFrame.setSize(1920, 1050);
        secondInningsFrame.setLayout(null);
        secondInningsFrame.setVisible(true);

        secondBattingtable.setModel(DbUtils.resultSetToTableModel(rssecondInningsBatting));
        secondBowlingtable.setModel(DbUtils.resultSetToTableModel(rssecondInningsBowling));

        secondInningsDone.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame defaultFrame = new JFrame();
                CrickbuzzPage defaultPage = new DefaultCrickbuzzPage(defaultFrame);
                secondInningsFrame.setVisible(false);
                defaultPage.Display();

            }
        });
    }
}
