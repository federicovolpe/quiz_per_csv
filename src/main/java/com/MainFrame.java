package com;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame implements mainListener{
    ArrayList<Component> panels = new ArrayList<>();
    // for now i put all the panels here
    ArrayList<Domanda> domande = new ArrayList<>();

    /**
     * method that creates the main frame onto which all the panels
     * of the quizzes will be added
     */
    public MainFrame(){
        this.setTitle("Main frame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);

        //mainframe is born by default with the main panel

        MainPanel mp = new MainPanel(domande,this);
        this.add(mp);
        this.setVisible(true);
    }

    @Override
    public Component add(Component comp) {
        panels.add(comp);
        return super.add(comp);
    }

    @Override
    public void onPanelChange(String panelName) {
        System.out.println("ricevuto il messaggio"+ panelName);
        switch (panelName) {
            case "DomandeChiuse" -> {
                // change of panel to DomandeChiuse
                this.remove(panels.get(panels.size() - 1));
                this.add(new DomandeChiuse(domande,this));
                System.out.println("cambio il pannello");
                this.revalidate();
                this.repaint();
            }
            case "FinalPage" -> {
                this.remove(panels.get(panels.size() - 1));
                this.add(new FinalPage(this));
                System.out.println("cambio il pannello");
                this.revalidate();
                this.repaint();
            }
            case "DomandeAperte" -> {
                this.remove(panels.get(panels.size() - 1));
                this.add(new DomandeAperte(domande,this));
                System.out.println("cambio il pannello");
                this.revalidate();
                this.repaint();
            }
            default -> System.out.println("change panel recieved but not recognized");
        }
        System.out.println("il messaggio non identificato");
    }
}
