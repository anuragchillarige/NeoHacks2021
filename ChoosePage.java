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

public class ChoosePage extends JPanel implements ActionListener{

    private ScreenManager sm; private CardLayout cl;
    public ChoosePage(ScreenManager smIn, CardLayout clIn) {
        sm = smIn; cl = clIn;

        setBackground( new Color(17, 138, 178) );
        setLayout( new GridLayout(3,1) );

        JLabel title = new JLabel("Choose An Option", JLabel.CENTER);
        JPanel centerPan = new JPanel( new FlowLayout(FlowLayout.CENTER) );
        JButton graph = new JButton("View Graph");
        JButton info = new JButton("New Entry");
        graph.addActionListener(this);
        graph.addActionListener(this);
        centerPan.setBackground( new Color(17, 138, 178) );
        centerPan.add(info);
        centerPan.add(graph);

        add(title);
        add(centerPan);

    }

    public void actionPerformed(ActionEvent evt) {
        String btn = evt.getActionCommand();

        if (btn.equals("View Graph")) {
            cl.show(sm, "graph");
        } else {
            cl.show(sm, "getinformation");
        }
    }
}
