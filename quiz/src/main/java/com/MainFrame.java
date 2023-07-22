package com;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame implements mainListener{
    ArrayList<Component> panels = new ArrayList<>();
    // for now i put all the panels here
    private ArrayList<Domanda> domande;

    /**
     * method that creates the main frame onto which all the panels
     * of the quizzes will be added
     */
    public MainFrame(ArrayList<Domanda> domande){
        this.domande = domande;
        this.setTitle("Main frame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
    }

    @Override
    public Component add(Component comp) {
        panels.add(comp);
        return super.add(comp);
    }

    @Override
    public void onPanelChange(String panelName) {
        System.out.println("ricevuto il messaggio"+ panelName);
        if(panelName.equals("DomandeChiuse")){
            // cambiataggio di pannello dal main al DomandeChiuse
            this.remove(panels.get(panels.size()-1));
            this.add(new DomandeChiuse(domande));
            System.out.println("cambio il pannello");
            this.revalidate();
            this.repaint();
            return;
        }
        System.out.println("il messaggio non identificato");
    }
}
