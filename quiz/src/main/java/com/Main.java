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

    public static void main(String[] args) {

        String currentDirectory = System.getProperty("user.dir");
        System.out.println("Current working directory: " + currentDirectory);

        // sets up the frame
        MainFrame frame = new MainFrame();
    }
}