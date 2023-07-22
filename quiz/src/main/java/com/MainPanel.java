package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * class that implements the main panel of the quiz
 * this simple class implements two buttons to select the mode of the game
 */
public class MainPanel extends JPanel implements ActionListener{
    private mainListener mainListener;
    JButton b1, b2;
    JTextField text;

    /**
     * constructor method with the two buttons and the text field for the question
     */
    public MainPanel(){
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        text = new JTextField();
        text.setText("scegli la modalita' di quiz");
        text.setForeground(Color.GREEN);
        text.setBounds(0,0,600, 100);
        text.setBorder(BorderFactory.createBevelBorder(1));
        text.setEditable(false);
        text.setHorizontalAlignment(JTextField.CENTER);

        b1 = new JButton("domande aperte");
        b1.setBounds(0,120, 300, 200 );
        b1.setFocusable(false);
        b1.addActionListener(this);
        b1.setFont(new Font("Ink Free", Font.BOLD, 30));

        b2 = new JButton("domande chiuse");
        b2.setBounds(300,120, 300, 200 );
        b2.setFocusable(false);
        b2.addActionListener(this);
        b2.setFont(new Font("Ink Free", Font.BOLD, 30));

        this.add(text);
        this.add(b1);
        this.add(b2);

        this.setVisible(true);
        System.out.println("main panel added to the frame");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(b2)){
            System.out.println("insertion of the panel of DomandeChiuse");
            mainListener.onPanelChange("DomandeChiuse");
        }
    }

    public void setmainListener(mainListener l){
        this.mainListener = l;
    }
}
