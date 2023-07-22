package com;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;       
import java.io.InputStream;       
import java.io.InputStreamReader;
import java.util.ArrayList;                                                       
                                                                                                 
public class Main {

    private static ArrayList<Domanda> domande;

    public static void main(String[] args) {
                                                                                                                                                         
        String currentDirectory = System.getProperty("user.dir");                                                                                        
        System.out.println("Current working directory: " + currentDirectory);

        String line;                                                                                                                                     
        String csvSeparator = ";";                                                                                                                       
                                                                                                                                                         
        domande = new ArrayList<Domanda>();
        try (InputStream inputStream = Main.class.getResourceAsStream("/domande.csv");
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {             
                                                                                                       
            while ((line = br.readLine()) != null) {                                                   
                String[] data = line.split(csvSeparator);                                              
                domande.add(new Domanda(data[0], data[1], data[2], data[3], data[4], data[5], data[6]));
            }
        } catch (IOException e) {                                                                      
            e.printStackTrace();                                    
        }

        // sets up the frame to add the panels
        MainFrame frame = new MainFrame(domande);
        MainPanel mp = new MainPanel();
        mp.setmainListener(frame);
        frame.add(mp);
        frame.setVisible(true);
    }
}