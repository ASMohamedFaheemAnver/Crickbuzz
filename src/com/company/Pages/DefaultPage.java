package com.company.Pages;

import javax.swing.*;

public class DefaultPage implements Page{
    private JFrame defaultFrame = new JFrame();
    private JTextField searchText = new JTextField("Enter Match ID");
    private JButton searchButton = new JButton("Search");

    @Override
    public void Display() {
        searchButton.setBounds(280, 100, 100, 40);
        searchText.setBounds(130, 100, 100, 40);
        defaultFrame.add(searchButton);
        defaultFrame.add(searchText);

        defaultFrame.setSize(1920, 1050);
        defaultFrame.setLayout(null);
        defaultFrame.setVisible(true);
    }
}