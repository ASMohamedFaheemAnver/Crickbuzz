package com.company.Crickbuzzpage;

import javax.swing.*;
import java.awt.*;

public class DefaultCrickbuzzPage implements CrickbuzzPage{
    public JFrame defaultFrame = new JFrame();
    public JLabel userGreeting = new JLabel();
    public JLabel searchInstruction = new JLabel();
    public JTextField searchText = new JTextField("");
    public JButton searchButton = new JButton("Search");
    public JRadioButton previewInnings = new JRadioButton("Innings Preview");
    public JRadioButton firstInnings = new JRadioButton("First Innings");
    public JRadioButton secondInnings = new JRadioButton("Second Innings");
    public ButtonGroup selectionInnings = new ButtonGroup();

    @Override
    public void Display() {
        userGreeting.setText("WELCOME TO THE AWESOME CRICKBUZZ!");
        searchInstruction.setText("Enter Match ID : ");
        userGreeting.setBounds(650, 0, 700, 100);
        searchInstruction.setBounds(500, 250, 150, 40);
        searchText.setBounds(630, 250, 100, 40);
        searchButton.setBounds(1350, 250, 100, 40);
        firstInnings.setBounds(770, 250, 150, 40);
        secondInnings.setBounds(970, 250, 150, 40);
        previewInnings.setBounds(1170, 250, 150, 40);
        selectionInnings.add(firstInnings);
        selectionInnings.add(secondInnings);
        selectionInnings.add(previewInnings);

        defaultFrame.add(firstInnings);
        defaultFrame.add(secondInnings);
        defaultFrame.add(previewInnings);

        userGreeting.setFont(new Font("Serif", Font.BOLD, 25));

        defaultFrame.add(userGreeting);
        defaultFrame.add(searchInstruction);
        defaultFrame.add(searchButton);
        defaultFrame.add(searchText);

        defaultFrame.setSize(1920, 1050);
        defaultFrame.setLayout(null);
        defaultFrame.setVisible(true);
    }
}