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

public class SignIn extends JPanel implements ActionListener{
    private ScreenManager sm;
    private CardLayout cl;
    private CreditAccount ca;
    private JTextField username;
    private JTextField password;
    private JLabel errorMessage;

    public SignIn(ScreenManager smIn, CardLayout clIn, CreditAccount caIn) {

        setForeground(new Color(237, 242, 244));
        setBackground(new Color(17, 138, 178));
        sm = smIn;
        cl = clIn;
        ca = caIn;
        setLayout( new GridLayout(4, 1));
        Font labelFont = new Font("Verdana", Font.PLAIN, 17);

        JPanel topPan = new JPanel();
        topPan.setBackground(new Color(17, 138, 178));
        JLabel title = new JLabel("Sign In", JLabel.CENTER);
        title.setForeground(new Color(237, 242, 244));
        title.setFont( new Font("Verdana", Font.BOLD, 55));
        topPan.add( title );

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(17, 138, 178));
        panel2.setLayout( new FlowLayout(FlowLayout.CENTER));
        JLabel labelUsername = new JLabel("Username:", JLabel.CENTER);
        labelUsername.setForeground(new Color(237, 242, 244));
        labelUsername.setFont(labelFont);
        username = new JTextField("Enter a username", 20);
        panel2.add(labelUsername);
        panel2.add(username);

        JPanel panel3 = new JPanel();
        panel3.setBackground( new Color(17, 138, 178) );
        panel3.setLayout( new FlowLayout(FlowLayout.CENTER));
        JLabel labelPassword = new JLabel("Password:", JLabel.CENTER);
        labelPassword.setForeground(new Color(237, 242, 244));
        labelPassword.setFont(labelFont);
        password = new JTextField("Enter a password", 20);
        panel3.add(labelPassword);
        panel3.add(password);

        JPanel botPan = new JPanel();
        botPan.setBackground( new Color(17, 138, 178) );
        botPan.setLayout(new GridLayout(2, 1));
        JButton btn = new JButton("Sign In!");
        JButton back = new JButton("Back");
        errorMessage = new JLabel("Incorrect Username/Password!", JLabel.CENTER);
        errorMessage.setForeground( new Color(17, 138, 178) );
        btn.addActionListener(this);
        back.addActionListener(this);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground( new Color(17, 138, 178));
        buttonPanel.add(btn);
        buttonPanel.add(back);
        botPan.add(buttonPanel);
        botPan.add(errorMessage);

        add(topPan);
        add(panel2);
        add(panel3);
        add(botPan);
    }

    public void actionPerformed(ActionEvent evt) {
        String usernameText = username.getText();
        String passwordText = password.getText();

        if (evt.getActionCommand().equals("Sign In!")) {
            boolean signedIn = ca.signIn(usernameText, passwordText);
            if (signedIn == true) {
                cl.show(sm, "getinformation");
                sm.setUsername(usernameText);
            } else {
                username.setText("Enter a username");
                password.setText("Enter a password");
                errorMessage.setForeground(Color.RED);
                repaint();
            }
        } if (evt.getActionCommand().equals("Back")) {
            cl.show(sm, "home");
        }
    }
}
