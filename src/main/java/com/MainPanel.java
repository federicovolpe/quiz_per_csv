package com;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * class that implements the main panel of the quiz
 * this simple class implements two buttons to select the mode of the game
 */
public class MainPanel extends JPanel implements ActionListener, DropTargetListener {
    private mainListener mainListener;
    ArrayList<Domanda> domande;
    JButton b1, b2;
    JTextField text;
    JPanel dropPanel; // New panel for drop zone
    JLabel dropLabel;
    JLabel iconLabel;

    public MainPanel(ArrayList<Domanda> domande, MainFrame mf) {
        setmainListener(mf);
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.domande = domande;

        text = new JTextField();
        text.setText("scegli la modalita' di quiz");
        text.setForeground(Color.GREEN);
        text.setBackground(Color.BLACK);
        text.setBounds(0, 0, 600, 100);
        text.setBorder(BorderFactory.createBevelBorder(1));
        text.setFont(new Font("Ink Free", Font.BOLD, 30));
        text.setEditable(false);
        text.setHorizontalAlignment(JTextField.CENTER);

        b1 = new JButton("domande aperte");
        b1.setBounds(0, 120, 300, 200);
        b1.setFocusable(false);
        b1.addActionListener(this);
        b1.setFont(new Font("Ink Free", Font.BOLD, 30));
        b1.setEnabled(false);

        b2 = new JButton("domande chiuse");
        b2.setBounds(300, 120, 300, 200);
        b2.setFocusable(false);
        b2.addActionListener(this);
        b2.setFont(new Font("Ink Free", Font.BOLD, 30));
        b2.setEnabled(false);

        this.add(text);
        this.add(b1);
        this.add(b2);

        // Create the drop panel
        dropPanel = new JPanel(new BorderLayout());
        dropPanel.setBounds(100, 350, 400, 200);
        dropPanel.setBackground(Color.DARK_GRAY);

        // Add the "drop file here" label to the drop panel
        dropLabel = new JLabel("Drop file here", JLabel.CENTER);
        dropLabel.setForeground(Color.WHITE);
        dropLabel.setFont(new Font("Ink Free", Font.BOLD, 20));
        dropPanel.add(dropLabel, BorderLayout.CENTER);

        // Add an icon to the drop panel (optional)
        ImageIcon icon = new ImageIcon("./src/main/resources/dropHereIcon.png"); // Replace "your_icon.png" with your icon file
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        iconLabel = new JLabel(resizedIcon, JLabel.CENTER);
        dropPanel.add(iconLabel, BorderLayout.SOUTH);

        // Add the drop panel to the main panel
        this.add(dropPanel);

        // Add drop target functionality to the panel
        new DropTarget(this, this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (b2.equals(source)) {
            System.out.println("Insertion of the panel of DomandeChiuse");
            mainListener.onPanelChange("DomandeChiuse");
        } else if (b1.equals(source)) {
            System.out.println("Insertion of the panel of DomandeAperte");
            mainListener.onPanelChange("DomandeAperte");
        } else {
            System.out.println("Button not recognized");
        }
    }

    public void setmainListener(mainListener l){
        this.mainListener = l;
    }

    @Override
    public void drop(DropTargetDropEvent event) {
        System.out.println("A file has been dropped.");
        try {
            event.acceptDrop(DnDConstants.ACTION_COPY);
            List<File> droppedFiles = (List<File>) event.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
            File droppedFile = droppedFiles.get(0);

            if (droppedFile.getName().endsWith(".csv")) {
                try (BufferedReader br = new BufferedReader(new FileReader(droppedFile))) {
                    String line;
                    try {
                        while ((line = br.readLine()) != null) {
                            String[] data = line.split(";");
                            domande.add(new Domanda(data[0], data[1], data[2], data[3], data[4], data[5], data[6]));
                        }
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("file is not formatted correctly, see the documentation at: \nhttps://github.com/federicovolpe/quiz_per_csv");
                        return;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("File has been read.");
            } else {
                System.out.println("File not in the correct format.");
                return;
            }
        } catch (UnsupportedFlavorException | IOException ex) {
            ex.printStackTrace();
        }

        b1.setEnabled(true);
        b2.setEnabled(true);
        preview();

        event.dropComplete(true);
        new DropTarget(this,this);
    }

    /**
     * method that changes the drop panel to display a preview of the questions which has been inserted
     */
    private void preview(){
        dropPanel.remove(dropLabel);
        dropPanel.remove(iconLabel);
        JTextArea pretext = new JTextArea();
        pretext.setText(domande.toString());

        JScrollPane scrollPane = new JScrollPane(pretext);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        dropPanel.add(scrollPane, BorderLayout.CENTER); // Add the JTextArea to the dropPanel

        // Repaint the dropPanel to reflect the changes
        dropPanel.revalidate();
        dropPanel.repaint();
    }

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {

    }
    @Override
    public void dragOver(DropTargetDragEvent dtde) {

    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {

    }

    @Override
    public void dragExit(DropTargetEvent dte) {

    }
}
