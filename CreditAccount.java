import java.io.*;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CreditAccount extends JPanel {
	private String username;
	PrintWriter pw;
	
	public CreditAccount() {
		username = new String("");
		pw = null;
	}
	
	public void createAccount(String newUsername, String newPassword) {
		
		File txtFile = new File("login.txt");
		try {
			pw = new PrintWriter( new FileWriter(txtFile, true) );

		} 
		catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}

		pw.println(newUsername + " - " + newPassword);
		pw.close();
		username = newUsername;
	}
			
	
	
	public boolean signIn(String possibleUsername, String possiblePassword) {
		String fileName = "login.txt";
		File txtFile = new File(fileName);
		Scanner sc = null;
		try {
			sc = new Scanner(txtFile);			
		} catch (FileNotFoundException e) {
			return false;
		}

		while (sc.hasNext()) {
			String line = sc.nextLine();
			if (line.substring(0, line.indexOf("-") - 1).equals(possibleUsername)) {
				if (line.substring(line.indexOf("-") + 2).equals(possiblePassword)) {
					username = possibleUsername;
					return true;
				}
			}
		}
		return false;		
	}

	public String getUsername() {
		return username;
	}

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