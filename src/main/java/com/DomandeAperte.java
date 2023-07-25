package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;

/**
 * class that creates a  window if the button is being clicked
 * */
public class DomandeAperte extends JPanel implements ActionListener{
    private mainListener mainListener;
    int giuste = 0;
    int sbagliate = 0;
    final int ndomande;
    int n;
    Domanda d;
    JButton b1, b2, showButton;
    JTextArea risposta = new JTextArea();
    JTextField numeroDomanda = new JTextField();
    JTextArea testo = new JTextArea();
    ArrayList<Domanda> domande;
    JTextField statistic;
    JPanel dropPanel;

    /**
     * constructor method for a widnow
     * */
    public DomandeAperte(ArrayList<Domanda> domande, MainFrame mf) {
        setmainListener(mf);
        this.domande = domande;
        ndomande = domande.size();

        JLabel questionLabel = new JLabel();
        this.setLayout(null);
        this.setBackground(Color.BLACK);

        numeroDomanda.setBounds(0,0,600,50);
        numeroDomanda.setBackground(Color.BLACK);
        numeroDomanda.setForeground(Color.GREEN);
        numeroDomanda.setBorder(BorderFactory.createBevelBorder(1, null, null, null, null));
        numeroDomanda.setHorizontalAlignment(JTextField.CENTER);        // per centrare il testo del numero della domanda
        numeroDomanda.setEditable(false);
        this.add(numeroDomanda);

        testo.setBounds(0,50,600,50);
        testo.setLineWrap(true);
        testo.setWrapStyleWord(true);
        testo.setBackground(Color.BLACK);
        testo.setForeground(Color.GREEN);
        testo.setBorder(BorderFactory.createBevelBorder(1, null, null, null, null));
        testo.setEditable(false);
        testo.setFont(new Font("Ink Free", Font.ITALIC, 20));
        this.add(testo);

        risposta.setBounds(0,150,600,100);
        risposta.setLineWrap(true);
        risposta.setWrapStyleWord(true);
        risposta.setBackground(Color.BLUE);
        risposta.setForeground(Color.GREEN);
        risposta.setBorder(BorderFactory.createBevelBorder(1, null, null, null, null));
        risposta.setEditable(false);
        risposta.setFont(new Font("Ink Free", Font.ITALIC, 15));
        this.add(risposta);

        buttonShow();

        statistic = new JTextField();
        statistic.setBounds(500,500,100,100);
        statistic.setForeground(Color.BLUE);
        statistic.setBackground(Color.GRAY);
        statistic.setFont(new Font("Ink Free", Font.PLAIN, 25));
        statistic.setEditable(false);

        this.add(questionLabel);
        this.add(statistic);
        this.setSize(600, 600);
        this.setVisible(true);

        next();
    }

    //funzione per rinnovare la domanda con una nuova
    public void next(){
        if(domande.size() > 0){
            //generazione di un numero casuale
            Random rand = new Random();
            n = rand.nextInt(domande.size());
            System.out.println("numero estratto: " + n);

            d = domande.get(n);
            numeroDomanda.setText(d.numero);
            testo.setText(d.domanda);
            risposta.setText("Risposta: \n" + d.risposta);
            risposta.setVisible(false);

            float percentuale = (float)giuste / (float)(giuste + sbagliate) * 100;
            statistic.setText((String.format("%.1f", percentuale))+ "%");
            System.out.println("faccio vedere il bottone show");
            buttonShow();

        }else{ // if there are no more questions signals to the mainlistener to change page
            System.out.println("no more questions, going to display statistics");
            mainListener.onPanelChange("FinalPage");
        }
    }

    //listens if one of the buttons is being pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            giuste++;
            domande.remove(n);
            next();
        }
        if (e.getSource() == b2) {
            sbagliate++;
            next();
        }
        if (e.getSource() == showButton) {
            answer();
        }
    }

    /**
     * method whish shows only the button "show answer"
     */
    private void buttonShow(){
        if(dropPanel != null) {
            this.remove(dropPanel);
        }

        // Create the drop panel
        dropPanel = new JPanel();
        dropPanel.setLayout(null);
        dropPanel.setBounds(200, 400, 200, 100);
        dropPanel.setBackground(Color.BLACK);

        showButton = new JButton("show answer");
        showButton.setBounds(0, 0, 200, 50);
        showButton.setBackground(Color.BLACK);
        showButton.setFocusable(false);
        showButton.addActionListener(this);
        showButton.setFont(new Font("Ink Free", Font.BOLD, 15));
        showButton.setEnabled(true);

        dropPanel.add(showButton);

        // Add the drop panel to the main panel
        this.add(dropPanel);
        this.revalidate();
        this.repaint();
    }

    /**
     * method which shows the two buttons used to give the answer
     */
    private void answer() {
        if (dropPanel != null) {
            this.remove(dropPanel);
        }

        risposta.setVisible(true);

        // Create the drop panel with FlowLayout
        dropPanel = new JPanel();
        dropPanel.setLayout(null);
        dropPanel.setBounds(0, 400, 600, 100);
        dropPanel.setBackground(Color.black);

        b1 = new JButton("risposta corretta");
        b1.setBounds(70, 0, 200,100);
        b1.setFocusable(false);
        b1.addActionListener(this);
        b1.setFont(new Font("Ink Free", Font.BOLD, 15));
        b1.setVisible(true);
        dropPanel.add(b1);

        b2 = new JButton("risposta errata");
        b2.setBounds(330,0,200,100);
        b2.setFocusable(false);
        b2.addActionListener(this);
        b2.setFont(new Font("Ink Free", Font.BOLD, 15));
        b2.setVisible(true);
        dropPanel.add(b2);

        // Add the drop panel to the main panel
        this.add(dropPanel);
        this.revalidate();
        this.repaint();
    }
    public void setmainListener(mainListener l) { this.mainListener = l;}
}
