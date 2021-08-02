import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JPanel implements ActionListener {
    private CardLayout cl;
    private ScreenManager sm;

    public Home(CardLayout clIn, ScreenManager smIn) {
        setBackground( new Color(17, 138, 178) );
        cl = clIn;
        sm = smIn;
        setLayout( new GridLayout(4,1) );
        JButton create = new JButton("Create Account");
        JButton signIn = new JButton("Sign in");
        create.addActionListener(this);
        signIn.addActionListener(this);
        create.setFont( new Font("Verdana", Font.BOLD, 25) );
        signIn.setFont( new Font("Verdana", Font.BOLD, 25) );

        JLabel title = new JLabel("Credit Score Visualizer", JLabel.CENTER);
        title.setFont( new Font("Verdana", Font.BOLD, 55));
        title.setForeground( new Color(237, 242, 244));
        
        add(title);
        add(create);
        add(signIn);
    }

    public void actionPerformed(ActionEvent evt) {
        String button = evt.getActionCommand();
        if (button.equals("Create Account")) {
            cl.show(sm, "signup");
        } else if (button.equals("Sign in")) {
            cl.show(sm, "signin");
        }

        System.out.println(button);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
