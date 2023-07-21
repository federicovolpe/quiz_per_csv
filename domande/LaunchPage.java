package domande;

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
public class LaunchPage implements ActionListener{                                                                         
    int giuste = 0;                             
    int sbagliate = 0;                          
    final int ndomande;                                                                        
    int n;                                                                                  
    JFrame frame = new JFrame();                                                            
    Domanda d;                                                                              
    JButton b1;                                                                                                          
    JButton b2;                                                                                                          
    JButton b3;                                                                                                          
    JButton b4;                                                                                                          
    String risposta;                                                                        
    JTextArea opzione1;                                                                                                
    JTextArea opzione2;                                                                                                                                                                                            
    JTextArea opzione3;                                                                                                                                                                                            
    JTextArea opzione4;                                                                                                                                                                                            
    JTextField numeroDomanda = new JTextField();                                                                                                                                                                
    JTextArea testo = new JTextArea();                                                                                                                                                                        
    ArrayList<Domanda> domande;       
    JTextField statistic;                
                                                 
    /**                                                                                                                                                                                                         
     * constructor method for a widnow                                                                                                                                                                          
     * */                                                                                                                                                                                                       
    public LaunchPage(ArrayList<Domanda> domande) {                                                                                    
        this.domande = domande;                  
        ndomande = domande.size();                               
                                                                
        JLabel questionLabel = new JLabel();                                                                                                                                                                      
        frame.setLayout(null);                                                                                                                                                                                    
        frame.setResizable(true);                                                                                                                                                                                 
        frame.getContentPane().setBackground(Color.BLACK);                                                                                                                                                
                                                                                                                                                                                                                  
        numeroDomanda.setBounds(0,0,600,50);                                                                                                                                                                      
        numeroDomanda.setBackground(Color.BLACK);                                                                                                                                                                 
        numeroDomanda.setForeground(Color.GREEN);                                                                                                                                                                 
        numeroDomanda.setBorder(BorderFactory.createBevelBorder(1, null, null, null, null));                                                                                                                      
        numeroDomanda.setHorizontalAlignment(JTextField.CENTER);        // per centrare il testo del numero della domanda                                                                                         
        numeroDomanda.setEditable(false);                                                                                                                                                                                                                                                                                                                                               
        frame.add(numeroDomanda);                                                                                                                                                                                 
                                                                                                                                                                                                                  
        testo.setBounds(0,50,600,50);                                                                                                                                                                             
        testo.setLineWrap(true);                                                                                                                                                                                  
        testo.setWrapStyleWord(true);                                                                                                                                                                             
        testo.setBackground(Color.BLACK);                                                                                                                                                                         
        testo.setForeground(Color.GREEN);                                                                                                                                                                         
        testo.setBorder(BorderFactory.createBevelBorder(1, null, null, null, null));                                                                                                                              
        testo.setEditable(false);                                                      
        testo.setFont(new Font("Ink Free", Font.ITALIC, 20));                                                                                                                                                                               
        frame.add(testo);                                                                                                                                                                                       
                                                                                                                                                                                                                
        b1 = new JButton("A");                                                                                                                                                                                   
        b1.setBounds(0, 100, 100, 100);                                                                                                                                                                          
        b1.setFocusable(false);                                                                                                                                                                                  
        b1.addActionListener(this);                                                                                                                                                                             
        b1.setFont(new Font("Ink Free", Font.BOLD, 30));                                                                                                                                      
        opzione1 = new JTextArea();                                                                                                                                                                    
        opzione1.setBounds(125, 130, 450, 100);                                                                                                                                                                 
        opzione1.setBackground(Color.BLACK);                                                                                                                                                                    
        opzione1.setForeground(Color.WHITE);                                                                                                                                                                    
        opzione1.setFont(new Font("Ink Free", Font.PLAIN, 14));                        
        opzione1.setLineWrap(true);                                                                                                                                                                                  
        opzione1.setWrapStyleWord(true);                                                                                                                                       
                                                                                       
        b2 = new JButton("B");                                                                                                                                                                                   
        b2.setBounds(0, 200, 100, 100);                                                                                                                                                                          
        b2.setFocusable(false);                                                                                                                                                                                  
        b2.addActionListener(this);                             
        b2.setFont(new Font("Ink Free", Font.BOLD, 30));                                                                                                                                      
        opzione2 = new JTextArea();                                                                                                                                                                           
        opzione2.setBounds(125, 230, 450, 100);                                                                       
        opzione2.setBackground(Color.BLACK);                                                                   
        opzione2.setForeground(Color.WHITE);                                         
        opzione2.setFont(new Font("Ink Free", Font.PLAIN, 14));                                                                                                                                      
        opzione2.setLineWrap(true);                                                                                                                                                                                  
        opzione2.setWrapStyleWord(true);                                                                                                                  
                                                                                          
        b3 = new JButton("C");                                                                                                                                
        b3.setBounds(0, 300, 100, 100);                                                                                                                       
        b3.setFocusable(false);                                                                                                                                                                                        
        b3.addActionListener(this);                                                                                                                                                                                    
        b3.setFont(new Font("Ink Free", Font.BOLD, 30));                                                                                                                                                               
        opzione3 = new JTextArea();                                                                                                                                                                                    
        opzione3.setBounds(125, 330, 450, 100);                                                                                                                                                                        
        opzione3.setBackground(Color.BLACK);                                                                                                                                                                           
        opzione3.setForeground(Color.WHITE);                                                                                                                                                                           
        opzione3.setFont(new Font("Ink Free", Font.PLAIN, 14));                                                                                                                                                        
        opzione3.setLineWrap(true);                                                                                                                                                                                    
        opzione3.setWrapStyleWord(true);                                                                                                                                                                              
                                          
        b4 = new JButton("D");                                                                                                                                                                                         
        b4.setBounds(0, 400, 100, 100);                                                                                                                                                                                
        b4.setFocusable(false);                                                                                                                                                                                        
        b4.addActionListener(this);                                                                                                                                                                                    
        b4.setFont(new Font("Ink Free", Font.BOLD, 30));                                                                                                                                                               
        opzione4 = new JTextArea();                                                                                                                                                                                    
        opzione4.setBounds(125, 430, 450, 100);                                                                                                                                                                        
        opzione4.setBackground(Color.BLACK);                                                                                                                                                                           
        opzione4.setForeground(Color.WHITE);                                                                                                                                                                                          
        opzione4.setFont(new Font("Ink Free", Font.PLAIN, 14));                                                                                                                                                        
        opzione4.setLineWrap(true);                                                                                                                                                                                  
        opzione4.setWrapStyleWord(true);                          
                                                                  
        statistic = new JTextField();                             
        statistic.setBounds(500,500,100,100);                     
        statistic.setForeground(Color.BLUE);                      
        statistic.setBackground(Color.GRAY);                      
        statistic.setFont(new Font("Ink Free", Font.PLAIN, 25));
        statistic.setEditable(false);                           
                                                                                                                                                                                                     
        frame.add(this.opzione1);                                                                                                                                                                    
        frame.add(this.opzione2);                                                                                                                                                                    
        frame.add(this.opzione3);                                                                                                                                                                    
        frame.add(this.opzione4);                                                                                                                                                                    
        frame.add(questionLabel);                                                                                                                                                                    
        frame.add(b1);                                                                                                                                                                               
        frame.add(b2);                                                                                                                                                                               
        frame.add(b3);                                                                                                                                                                               
        frame.add(b4);                                          
        frame.add(statistic);                                                                                                                                                                 
        frame.setSize(600, 600);                                                                                                                                                       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                                                                                                          
        frame.setVisible(true);                                                                                                                                                       
                                              
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
            numeroDomanda.setText(d.numero.toString());                                                         
            testo.setText(d.domanda);                                                                           
            opzione1.setText(d.opzioni[0]);                                                                                                                                               
            opzione2.setText(d.opzioni[1]);                                                                                                                                               
            opzione3.setText(d.opzioni[2]);                                                                                                                                               
            opzione4.setText(d.opzioni[3]);                                                                                                                                               
            this.risposta = d.risposta;                                                                         
                                                                                                                
            float percentuale = (float)giuste / (float)(giuste + sbagliate) * 100;                                                                             
            statistic.setText((String.format("%.1f", percentuale))+ "%");                    
        }//else{                                                                                              
           // paginafinale                                                                                    
        //}                                                                                                                                                                  
    }                                                                                                                                                                                     
                                                                                                                                                                                             
    //listens if one of the buttons is being pressed                                                                                                                                         
    @Override                                                                                                                                                                                
    public void actionPerformed(ActionEvent e) {                                                                                                                                             
                                                                                                                                                                                             
        if (e.getSource() == b1) {                                                                                                                                                           
            if (opzione1.getText().equals(risposta)) {                                                                                                                                          
                giuste++;                                                                                                                                                                    
                rimuovi();                                                                                                                                                                   
            }else{                                           
                sbagliate++;         
            }                                                                                                                                                                                                                                                                                                                                              
        }                                                                                                                                                                                    
        if (e.getSource() == b2) {                                                                                                                                                           
            if (opzione2.getText().equals(risposta)) {                                                                                                                                          
                giuste++;                                                                                                                                                                    
                rimuovi();                                                                                                                                                                                         
            }else{                   
                sbagliate++; 
            }                                                                                                                                                                                
        }                                                                                                                                                                                    
        if (e.getSource() == b3) {                                                                                                                                                           
            if (opzione3.getText().equals(risposta)) {                                                                                                                                          
                giuste++;                                                                                                                                                                    
                rimuovi();                                                                                                                                                               
            }else{           
                sbagliate++; 
            }                                                                                                                                                                             
        }                                                                                                                                                                                
        if (e.getSource() == b4) {                                                                                                                                                      
            if (opzione4.getText().equals(risposta)) {                                        
                giuste++;                                                               
                rimuovi();                                                              
            }else{           
                sbagliate++; 
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
        b1.setEnabled(false);                                                                                                                                                       
        b2.setEnabled(false);                                                                                                                                                       
        b3.setEnabled(false);                                                                                                                                                       
        b4.setEnabled(false);                                                                                                                                                      
                                                                                   
        //display the colors of the right and the wrong answers                    
                                                                                 
        if(opzione1.getText().equals(risposta)){opzione1.setForeground(Color.GREEN);}      
        else{opzione1.setForeground(Color.RED);}                                 
                                                                                 
        if(opzione2.getText().equals(risposta)){opzione2.setForeground(Color.GREEN);}      
        else{opzione2.setForeground(Color.RED);}                                 
                                                                                 
        if(opzione3.getText().equals(risposta)){opzione3.setForeground(Color.GREEN);}                                                                                                         
        else{opzione3.setForeground(Color.RED);}                                                                                                                                        
                                                                                                                                                                                        
        if(opzione4.getText().equals(risposta)){opzione4.setForeground(Color.GREEN);}                                                                                                         
        else{opzione4.setForeground(Color.RED);}                                              
                                                                                              
        Timer pause = new Timer(2000, new ActionListener() {                                  
                                                                                              
          @Override                                                                           
          public void actionPerformed(ActionEvent e) {                                        
              opzione1.setForeground(Color.WHITE);                               
              opzione2.setForeground(Color.WHITE);                               
              opzione3.setForeground(Color.WHITE);                               
              opzione4.setForeground(Color.WHITE);                               
                                                                                 
              b1.setEnabled(true);                                               
              b2.setEnabled(true);                                               
              b3.setEnabled(true);                                               
              b4.setEnabled(true);                                               
                                                                                 
              next();                                                           
            }                                                                                   
        });                                                                     
                                                                                
        pause.setRepeats(false);  
        pause.start();                                     
    }                                                                                                                                                                                    
}                                                                                                                                                                                        