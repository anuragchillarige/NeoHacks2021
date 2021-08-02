import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JPanel implements ActionListener {
    private ScreenManager sm;
    private CardLayout cl;
    private CreditAccount ca;
    private JTextField username;
    private JTextField password;

    public SignUp(ScreenManager smIn, CardLayout clIn, CreditAccount caIn) {
        sm = smIn;
        cl = clIn;
        ca = caIn;
        setLayout( new GridLayout(4, 1));

        setForeground(new Color(237, 242, 244));
        setBackground(new Color(17, 138, 178));
        Font labelFont = new Font("Verdana", Font.PLAIN, 17);
        
        JLabel title = new JLabel("Sign Up", JLabel.CENTER);
        title.setForeground(new Color(237, 242, 244));
        title.setFont( new Font("Verdana", Font.BOLD, 55));

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(17, 138, 178));
        panel2.setLayout( new FlowLayout(FlowLayout.CENTER));
        JLabel usernameLabel = new JLabel("Username:", JLabel.CENTER);
        usernameLabel.setFont(labelFont);
        usernameLabel.setForeground(new Color(237, 242, 244));
        username = new JTextField("Enter a username", 20);
        panel2.add(usernameLabel);
        panel2.add(username);

        JPanel panel3 = new JPanel();
        panel3.setBackground(new Color(17, 138, 178));
        panel3.setLayout( new FlowLayout(FlowLayout.CENTER));
        password = new JTextField("Enter a password", 20);
        JLabel passwordLabel = new JLabel("Password:", JLabel.CENTER);
        passwordLabel.setFont(labelFont);
        passwordLabel.setForeground(new Color(237, 242, 244));
        panel3.add(passwordLabel);
        panel3.add(password);

        JPanel botPan = new JPanel();
        botPan.setBackground(new Color(17, 138, 178));
        botPan.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton btn = new JButton("Sign Up!");
        JButton back = new JButton("Back");
        btn.addActionListener(this);
        back.addActionListener(this);
        botPan.add(btn);
        botPan.add(back);

        add(title);
        add(panel2);
        add(panel3);
        add(botPan);
    }

    public void actionPerformed(ActionEvent evt) {
        String usernameText = username.getText();
        String passwordText = password.getText();

        String pressed = evt.getActionCommand();
        if (pressed.equals("Sign Up!")) {
            ca.createAccount(usernameText, passwordText);
            sm.setUsername(usernameText);
            cl.show(sm, "getinformation");
        } else if (pressed.equals("Back")) {
            cl.show(sm, "home");
        }
    }
}
