package com;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;   
import java.util.Random;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
                                                                                            
/**                                                                                         
 * class that creates a  window if the button is being clicked                              
 * */
public class DomandeChiuse extends JPanel implements ActionListener{
    private mainListener mainListener;
    int giuste = 0;
    int sbagliate = 0;
    final int ndomande;
    int n;
    Domanda d;
    JButton[] buttons;
    String risposta;
    JTextArea[] opzioni;
    JTextField numeroDomanda = new JTextField();
    JTextArea testo = new JTextArea();
    ArrayList<Domanda> domande;
    JTextField statistic;

    /**
     * constructor method for a widnow
     * */
    public DomandeChiuse(ArrayList<Domanda> domande, MainFrame mf) {
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

        buttons = new JButton[4];
        opzioni = new JTextArea[4];
        for(int i = 0; i < 4; i ++){
            buttons[i] = new JButton();
            buttons[i].setBounds(0, i*100 + 100, 100, 100);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setFont(new Font("Ink Free", Font.BOLD, 30));
            this.add(buttons[i]);

            opzioni[i] = new JTextArea();
            opzioni[i].setBounds(125, i*100+130, 450, 100);
            opzioni[i].setBackground(Color.BLACK);
            opzioni[i].setForeground(Color.WHITE);
            opzioni[i].setFont(new Font("Ink Free", Font.PLAIN, 14));
            opzioni[i].setLineWrap(true);
            opzioni[i].setWrapStyleWord(true);
            this.add(opzioni[i]);
        }

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
            for(int i = 0; i < 4; i++){
                opzioni[i].setText(d.opzioni[i]);
            }
            this.risposta = d.risposta;                                                                         
                                                                                                                
            float percentuale = (float)giuste / (float)(giuste + sbagliate) * 100;                                                                             
            statistic.setText((String.format("%.1f", percentuale))+ "%");                    
        }else{ // if there are no more questions signals to the mainlistener to change page
            System.out.println("no more questions, going to display statistics");
            mainListener.onPanelChange("FinalPage");
        }
    }                                                                                                                                                                                     
                                                                                                                                                                                             
    //listens if one of the buttons is being pressed                                                                                                                                         
    @Override                                                                                                                                                                                
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 4; i++){
            if (e.getSource() == buttons[i]) {
                if (opzioni[i].getText().equals(risposta)) {
                    giuste++;
                    rimuovi();
                }else{
                    sbagliate++;
                }
            }
        }
        rivela();                                                                                                                                                                        
    }                                                                                   
                                                                                        
    /**                                                                                 
     * method which removes the question that has been anwered correctly                
     *                                                                           
     */                                                                          
    public void rimuovi(){                                                       
        domande.remove(n);                                                       
        System.out.println("Question " + d.numero + " removed");                                          
    }                                                                                                                                                                               
                                                                                                                                                                                         
    private void rivela(){
        for(int i = 0; i < 4; i++) {
            buttons[i].setEnabled(false);
        }
        //display the colors of the right and the wrong answers
        for(int i = 0; i < 4; i++){
            if(opzioni[i].getText().equals(risposta)){opzioni[i].setForeground(Color.GREEN);}
            else{opzioni[i].setForeground(Color.RED);}
        }
                                                                                              
        Timer pause = new Timer(2000, e -> {
            for(int i = 0; i < 4; i++){
                opzioni[i].setForeground(Color.WHITE);
                buttons[i].setEnabled(true);
            }
            next();
          });
                                                                                
        pause.setRepeats(false);  
        pause.start();                                     
    }

    public void setmainListener(mainListener l) { this.mainListener = l;}
}