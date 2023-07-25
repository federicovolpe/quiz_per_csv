package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * page which purpose is to display the statistics and inform the user that the
 * quiz has been completed
 */
public class FinalPage extends JPanel implements ActionListener {
    mainListener ml;
    JButton back;
    JTextArea statistiche;
    public FinalPage(MainFrame mf){
        setmainListener(mf);
        this.setBackground(Color.BLACK);
        this.setBounds(0,0,600,600);
        this.setVisible(true);

        back = new JButton("back");
        back.setBounds(0,0,50,100);
        back.setBackground(Color.BLUE);
        back.setVisible(true);
        back.setEnabled(true);
        this.add(back);

        statistiche = new JTextArea();
        statistiche.setBounds(100,100,400,400);
        statistiche.setBackground(Color.BLUE);
        statistiche.setVisible(true);
        statistiche.setText("statistiche varie del risultato del quiz");
        this.add(statistiche);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void setmainListener(mainListener ml){this.ml = ml;}
}
