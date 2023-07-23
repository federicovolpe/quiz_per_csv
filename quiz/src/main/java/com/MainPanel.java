package com;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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

    String testoletto;
    JPanel dropPanel; // New panel for drop zone

    public MainPanel(ArrayList<Domanda> domande) {
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
        JLabel dropLabel = new JLabel("Drop file here", JLabel.CENTER);
        dropLabel.setForeground(Color.WHITE);
        dropLabel.setFont(new Font("Ink Free", Font.BOLD, 20));
        dropPanel.add(dropLabel, BorderLayout.CENTER);

        // Add an icon to the drop panel (optional)
        ImageIcon icon = new ImageIcon("./src/main/resources/dropHereIcon.png"); // Replace "your_icon.png" with your icon file
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel iconLabel = new JLabel(resizedIcon, JLabel.CENTER);
        dropPanel.add(iconLabel, BorderLayout.SOUTH);

        // Add the drop panel to the main panel
        this.add(dropPanel);

        // Add drop target functionality to the panel
        DropTarget dropTarget = new DropTarget(this, this);

        this.setVisible(true);
        System.out.println("main panel added to the frame");
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

    @Override
    public void drop(DropTargetDropEvent event) {
        System.out.println("a file has been dropped");
        try {
            event.acceptDrop(DnDConstants.ACTION_COPY);
            List<File> droppedFiles = (List<File>) event.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
            File droppedFile = droppedFiles.get(0);
            try (InputStream inputStream = Main.class.getResourceAsStream("/domande.csv");
                 BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(";");
                    domande.add(new Domanda(data[0], data[1], data[2], data[3], data[4], data[5], data[6]));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("file has been read");
        } catch (UnsupportedFlavorException | IOException ex) {
            ex.printStackTrace();
        }
        b1.setEnabled(true);
        b2.setEnabled(true);
    }

    /**
     * method that reads the file that has been dropped
     * @param file
     * @throws IOException
     */
    private void readFile(File file) throws IOException {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Now you have the content of the file in the 'content' StringBuilder
        // You can use it as needed, for example, display it in the text field
        testoletto = content.toString();
    }
}
