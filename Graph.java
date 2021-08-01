import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;


public class Graph extends JPanel {

    private String[] dates;
    private int[] scores;
    private Scanner input;
    private ScreenManager sm; 
    private CardLayout cl;

    public Graph(ScreenManager smIn, CardLayout clIn) {
        sm = smIn;
        cl = clIn;
        setBackground( new Color(255, 255, 255));
        dates = new String[20];
        scores = new int[20];
        input = null;
    }

    public void openFile(String nameIn) {
        File txtFile = new File(nameIn + ".txt");
        try {
            input = new Scanner(txtFile);
        } catch(FileNotFoundException e ) {
            System.err.println("Could not open file");
            e.printStackTrace();
            System.exit(-1);
        }
        readFromFile();
    }

    public void readFromFile() {
        int counter = 0;
        while (input.hasNext()) {
            String line = input.nextLine().trim();
            dates[counter] = line.substring(0, line.indexOf("-") - 1);
            scores[counter] = Integer.parseInt(line.substring(line.indexOf("-") + 2));
            counter++;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        openFile(sm.getUsername());
        makeGraph(g);
        drawPoints(g);
    }

    public void drawPoints(Graphics g) {

        int strXPoint = 70;
        int ovalXPoint = 100;
        

        
        for (int i = 0; i < scores.length; i++) {
            if (dates[i] != null) {
                g.fillOval(ovalXPoint, scores[i] + 48, 5, 5);
                g.drawString(dates[i], strXPoint, 40);
                g.drawLine(ovalXPoint + 2, 45, ovalXPoint + 2, 55);

                if (i>= 1) {
                    g.drawLine(ovalXPoint - 100, scores[i-1] + 48, ovalXPoint, scores[i] + 48);
                }
                ovalXPoint += 100;
                strXPoint += 100;
            }
        }
        repaint(); 
    }

    public void makeGraph(Graphics g) {
        g.drawLine(50, 50, 50, 930);
        g.drawLine(50, 50, 750, 50);

        // Drawing the ticks on the y-axis
        for (int i = 75; i <= 930; i+= 25 ) {
            g.drawLine(45, i, 55, i);
            g.drawString((i-50) + "", 20, i + 3);
        }
    }
}