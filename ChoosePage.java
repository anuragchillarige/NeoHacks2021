import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
