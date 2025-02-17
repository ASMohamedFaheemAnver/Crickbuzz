package com.company.crickbuzzpage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


public class OverviewInningsPage implements CrickbuzzPage{
    private JFrame overviewInningsFrame = new JFrame();
    private ResultSet rsoverviewInnings;
    private String font = "Serif";

    private JLabel titleofoverviewInnings = new JLabel();
    private JLabel matchTitle = new JLabel();
    private JLabel matchOverview = new JLabel();
    JButton overviewInningsDone;

    public OverviewInningsPage(ResultSet rsoverviewInnings){
        this.rsoverviewInnings = rsoverviewInnings;
    }

    @Override
    public void display() {
        titleofoverviewInnings.setText("MATCH PREVIEW!");
        matchTitle.setText("WILL UPDATE");
        matchOverview.setText("WILL UPDATE");

        titleofoverviewInnings.setBounds(800, 0, 400, 100);
        matchTitle.setBounds(760, 200, 400, 200);
        matchOverview.setBounds(600, 400, 800, 300);

        titleofoverviewInnings.setFont(new Font(font, Font.BOLD, 25));

        overviewInningsDone = new JButton("DONE");
        overviewInningsDone.setBounds(1690, 950, 100, 40);

        overviewInningsFrame.add(titleofoverviewInnings);
        overviewInningsFrame.add(matchTitle);
        overviewInningsFrame.add(matchOverview);
        overviewInningsFrame.add(overviewInningsDone);
        matchTitle.setFont(new Font(font, Font.BOLD, 20));
        matchOverview.setFont(new Font(font, Font.BOLD, 20));

        try {
            if (rsoverviewInnings.next()){
                String text = "<html><p>" + rsoverviewInnings.getString(2) + "</p></html>";
                matchTitle.setText(rsoverviewInnings.getString(1));
                matchOverview.setText(text);
            }

        } catch (SQLException e) {
            e.getMessage();
        }


        overviewInningsFrame.setSize(1920, 1050);
        overviewInningsFrame.setLayout(null);
        overviewInningsFrame.setVisible(true);

        overviewInningsDone.addActionListener(e -> {
            CrickbuzzPage defaultPage = new DefaultCrickbuzzPage();
            overviewInningsFrame.setVisible(false);
            defaultPage.display();

        });
    }
}