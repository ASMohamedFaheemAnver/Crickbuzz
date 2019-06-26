package com.company.Crickbuzzpage;

import com.company.Operation.Operation;
import com.company.Operation.OperationFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefaultCrickbuzzPage implements CrickbuzzPage{
    final JButton searchButton = new JButton("Search");
    final JRadioButton InningsOverview = new JRadioButton("Innings Overview");
    final JRadioButton firstInnings = new JRadioButton("First Innings");
    final JRadioButton secondInnings = new JRadioButton("Second Innings");
    final ButtonGroup selectionInnings = new ButtonGroup();


    private JFrame defaultFrame = new JFrame();

    static JLabel userGreeting = new JLabel();
    static JLabel searchInstruction = new JLabel();
    static JTextField searchText = new JTextField("");


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
        InningsOverview.setBounds(1170, 250, 150, 40);

        InningsOverview.setActionCommand("Innings Overview");
        firstInnings.setActionCommand("First Innings");
        secondInnings.setActionCommand("Second Innings");

        userGreeting.setFont(new Font("Serif", Font.BOLD, 25));

        selectionInnings.add(firstInnings);
        selectionInnings.add(secondInnings);
        selectionInnings.add(InningsOverview);
        defaultFrame.add(firstInnings);
        defaultFrame.add(secondInnings);
        defaultFrame.add(InningsOverview);
        defaultFrame.add(userGreeting);
        defaultFrame.add(searchInstruction);
        defaultFrame.add(searchButton);
        defaultFrame.add(searchText);


        defaultFrame.setSize(1920, 1050);
        defaultFrame.setLayout(null);
        defaultFrame.setVisible(true);
        searchButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                OperationFactory operationFactory = new OperationFactory();
                String operator = "-1";
                int matchID = -1;

                try{
                    operator = selectionInnings.getSelection().getActionCommand();
                    matchID = Integer.parseInt(searchText.getText());

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "FILL MATCH ID AND SELECT WHETHER INNINGS OR OVERVIEW!");
                    operator = "-1";
                }
                Operation operation = operationFactory.getInstance(operator, matchID);
                defaultFrame.setVisible(false);
                operation.perform();
            }
        });
    }

}