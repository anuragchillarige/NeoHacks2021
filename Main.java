import javax.swing.JFrame;

public class Main {
    public static void main(String args[]) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(900, 1000);
        frame.setLocation(0,0);
        frame.setResizable(false);
        ScreenManager sm = new ScreenManager();
        frame.getContentPane().add(sm);
        frame.setVisible(true);
        }
    
}
