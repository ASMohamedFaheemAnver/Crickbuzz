package com.company.Crickbuzzpage;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OverviewInningsPage implements CrickbuzzPage{
    private JFrame previewInningsFrame = new JFrame();
    private ResultSet rspreviewInnings;

    private JLabel titleofPreviewInnings = new JLabel();
    private JLabel matchTitle = new JLabel();
    private JLabel matchOverview = new JLabel();

    public OverviewInningsPage(ResultSet rspreviewInnings){
        this.rspreviewInnings = rspreviewInnings;
    }

    @Override
    public void Display() {
        titleofPreviewInnings.setText("MATCH PREVIEW!");
        matchTitle.setText("WILL UPDATE");
        matchOverview.setText("WILL UPDATE");

        titleofPreviewInnings.setBounds(800, 0, 400, 100);
        matchTitle.setBounds(800, 200, 400, 200);
        matchOverview.setBounds(800, 500, 600, 400);

        titleofPreviewInnings.setFont(new Font("Serif", Font.BOLD, 25));

        previewInningsFrame.add(titleofPreviewInnings);
        previewInningsFrame.add(matchTitle);
        previewInningsFrame.add(matchOverview);

        try {
            if (rspreviewInnings.next()){
                matchTitle.setText(rspreviewInnings.getString(1));
                matchOverview.setText(rspreviewInnings.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        previewInningsFrame.setSize(1920, 1050);
        previewInningsFrame.setLayout(null);
        previewInningsFrame.setVisible(true);
    }
}