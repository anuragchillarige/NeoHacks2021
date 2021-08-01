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
import java.util.Calendar;
import java.util.Date;

public class ScreenManager extends JPanel {
    private ScreenManager sm;
    private CardLayout cl;
    private String username; 

    public ScreenManager() {
        sm = this;
        cl = new CardLayout();
        setLayout(cl);

        CreditAccount ca = new CreditAccount();
        Home home = new Home(cl, sm);
        SignUp su = new SignUp(sm, cl, ca);
        SignIn si = new SignIn(sm, cl, ca);
        GetInformation gi = new GetInformation(sm, cl);
        Graph g = new Graph(sm, cl);

        add(home, "home");
        add(su, "signup");
        add(si, "signin");
        add(gi, "getinformation");
        add(g, "graph");

        cl.show(this, "home");

    }

    public void setUsername(String usernameIn) {
        username = usernameIn;
    }

    public String getUsername() {
        return username;
    }

}
