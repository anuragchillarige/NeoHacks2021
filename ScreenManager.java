
import javax.swing.JPanel;
import java.awt.CardLayout;

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
        ChoosePage cp = new ChoosePage(sm, cl);

        add(home, "home");
        add(su, "signup");
        add(si, "signin");
        add(gi, "getinformation");
        add(g, "graph");
        add(cp, "choosepage");

        cl.show(this, "home");

    }

    public void setUsername(String usernameIn) {
        username = usernameIn;
    }

    public String getUsername() {
        return username;
    }

}
