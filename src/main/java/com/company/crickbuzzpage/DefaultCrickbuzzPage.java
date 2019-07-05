package com.company.crickbuzzpage;



import com.company.operation.VoidOperation;
import com.company.operation.OperationFactory;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DefaultCrickbuzzPage implements CrickbuzzPage{
    final JButton searchButton = new JButton("Search");
    final JRadioButton inningsOverview = new JRadioButton("Innings Overview");
    final JRadioButton firstInnings = new JRadioButton("First Innings");
    final JRadioButton secondInnings = new JRadioButton("Second Innings");
    final ButtonGroup selectionInnings = new ButtonGroup();


    private JFrame defaultFrame = new JFrame();

    static JLabel userGreeting = new JLabel();
    static JLabel searchInstruction = new JLabel();
    static JTextField searchText = new JTextField("");


    @Override
    public void display() {
        userGreeting.setText("WELCOME TO THE AWESOME CRICKBUZZ!");
        searchInstruction.setText("Enter Match ID : ");
        userGreeting.setBounds(650, 0, 700, 100);
        searchInstruction.setBounds(500, 250, 150, 40);
        searchText.setBounds(630, 250, 100, 40);
        searchButton.setBounds(1350, 250, 100, 40);
        firstInnings.setBounds(770, 250, 150, 40);
        secondInnings.setBounds(970, 250, 150, 40);
        inningsOverview.setBounds(1170, 250, 150, 40);

        inningsOverview.setActionCommand("Innings Overview");
        firstInnings.setActionCommand("First Innings");
        secondInnings.setActionCommand("Second Innings");

        userGreeting.setFont(new Font("Serif", Font.BOLD, 25));

        selectionInnings.add(firstInnings);
        selectionInnings.add(secondInnings);
        selectionInnings.add(inningsOverview);
        defaultFrame.add(firstInnings);
        defaultFrame.add(secondInnings);
        defaultFrame.add(inningsOverview);
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
                VoidOperation operation = null;
                try {
                    operation = operationFactory.getInstance(operator, matchID);
                } catch (SQLException ex) {
                    ex.getMessage();
                }
                defaultFrame.setVisible(false);
                if (operation != null) {
                    operation.perform();
                }
            }
        });
    }

}