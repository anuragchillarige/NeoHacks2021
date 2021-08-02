import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;

public class GetInformation extends JPanel implements ActionListener {
    private int derogatory = 0;
    private int outstanding_debt = 0;
    private int credit_length = 0;
    private int new_credit = 0;
    private int credit_mix = 0;
    private int credit;
    private String derogatoryAnswer;
    private String debtAnswer;
    private String creditLengthAnswer;
    private String newCreditAnswer;
    private String creditMixAnswer;

	private JTextField derogatoryTF;
	private JTextField debtTF;
	private JTextField creditLengthTF;
	private JTextField newCreditTF;
	private JTextField creditMixTF;

	private CardLayout cl;
	private ScreenManager sm;


    public GetInformation(ScreenManager smIn, CardLayout clIn) {
		cl = clIn;
		sm = smIn;

        setLayout( new GridLayout(6, 1) );

		// GetDerogatory
		JPanel pan1 = makeDerogatory();
		JPanel pan2 = makeDebt();
		JPanel pan3 = makeCreditLength();
		JPanel pan4 = makeNewCredit();
		JPanel pan5 = makeCreditMix();
		JPanel pan6 = new JPanel( new FlowLayout(FlowLayout.CENTER));
		JButton button = new JButton("Continue");
		button.addActionListener(this);
		pan6.add(button);

		add(pan1);
		add(pan2);
		add(pan3);
		add(pan4);
		add(pan5);
		add(pan6);

    }

	public JPanel makeDerogatory() {
		JPanel panel = new JPanel(new GridLayout(2, 1));
		JTextArea q = new JTextArea("How many months has it been since you're most recent derogatory public record? If you do you"
		+ " not have a derogatory public record please enter 'No Public Record'.");
		q.setEditable(false);
		q.setLineWrap(true);
		q.setWrapStyleWord(true);
		JPanel tfPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		derogatoryTF = new JTextField("", 5);
		panel.add(q);
		tfPan.add(derogatoryTF);
		panel.add(tfPan);
		return panel;
	}

	public JPanel makeDebt() {
		JPanel panel = new JPanel(new GridLayout(2, 1));
		JTextArea q = new JTextArea("What is your current debt(in dollars)? If you do not have any please enter"
		+ " 'No Revolving Trades'.");
		q.setEditable(false);
		q.setLineWrap(true);
		q.setWrapStyleWord(true);
		debtTF = new JTextField("", 5);
		JPanel tfPanel = new JPanel( new FlowLayout(FlowLayout.CENTER));
		panel.add(q);
		tfPanel.add(debtTF);
		panel.add(tfPanel);
		return panel;
	}

	public JPanel makeCreditLength() {
		JPanel panel = new JPanel(new GridLayout(2, 1));
		JTextArea q = new JTextArea("How many months have your credit accounts been open?");
		q.setEditable(false);
		q.setLineWrap(true);
		q.setWrapStyleWord(true);
		creditLengthTF = new JTextField("", 5);
		JPanel tfPanel = new JPanel( new FlowLayout(FlowLayout.CENTER));
		panel.add(q);
		tfPanel.add(creditLengthTF);
		panel.add(tfPanel);
		return panel;
	}

	public JPanel makeNewCredit() {
		JPanel panel = new JPanel(new GridLayout(2, 1));
		JTextArea q = new JTextArea("How many new credit accounts have you opened during the past 6 months?");
		q.setEditable(false);
		q.setLineWrap(true);
		q.setWrapStyleWord(true);
		newCreditTF = new JTextField("", 5);
		JPanel tfPanel = new JPanel( new FlowLayout(FlowLayout.CENTER));
		panel.add(q);
		tfPanel.add(newCreditTF);
		panel.add(tfPanel);
		return panel;
	}

	public JPanel makeCreditMix() {
		JPanel panel = new JPanel(new GridLayout(2, 1));
		JTextArea q = new JTextArea("How many types of different credit accounts do you have(mortgages, lones, credit cards, etc.)?");
		q.setEditable(false);
		q.setLineWrap(true);
		q.setWrapStyleWord(true);
		creditMixTF = new JTextField("", 5);
		JPanel tfPanel = new JPanel( new FlowLayout(FlowLayout.CENTER));
		panel.add(q);
		tfPanel.add(creditMixTF);
		panel.add(tfPanel);
		return panel;
	}

	public void actionPerformed(ActionEvent evt) {
		derogatoryAnswer = derogatoryTF.getText();
		debtAnswer = debtTF.getText();
		creditLengthAnswer = creditLengthTF.getText();
		newCreditAnswer = newCreditTF.getText();
		creditMixAnswer = creditLengthTF.getText();

		if (derogatoryAnswer.equalsIgnoreCase("No Public Record")) {
			credit += 75;
		} else if (!(derogatoryAnswer.equalsIgnoreCase(""))) {
			derogatory = Integer.parseInt(derogatoryAnswer);
		}

		if (debtAnswer.equalsIgnoreCase("No Revolving Trades")) {
			credit += 30;
		} else if (!debtAnswer.equals("")) {
			outstanding_debt = Integer.parseInt(debtAnswer);
		}

		if (!creditLengthAnswer.equals("")) {
			credit_length = Integer.parseInt(creditLengthAnswer);
		}

		if (!newCreditAnswer.equals("")) {
			new_credit = Integer.parseInt(newCreditAnswer);
		}

		if (!creditMixAnswer.equals("")) {
			credit_mix = Integer.parseInt(creditMixAnswer);
		}

		calculateIt();
		String name = sm.getUsername();
		writeToFile(name);
		cl.show(sm, "graph");
	}

	public void calculateIt() {
        if (derogatory >= 24)
            credit += 55;
        else if (derogatory <= 23 && derogatory >= 12)
            credit += 25;
        else if (derogatory <= 11 && derogatory >= 6)
            credit += 15;
        else if (derogatory <= 5 && derogatory >= 0)
            credit += 10;

        if (outstanding_debt >= 1000)
            credit += 15;
        else if (outstanding_debt <= 999 && outstanding_debt >= 750)
            credit += 25;
        else if (outstanding_debt <= 749 && outstanding_debt >= 500)
            credit += 40;
        else if (outstanding_debt <= 499 && outstanding_debt >= 100)
            credit += 50;
        else if (outstanding_debt <= 99 && outstanding_debt >= 1)
            credit += 65;
        else if (outstanding_debt == 0)
            credit += 55;

        if (credit_length >= 48)
            credit += 20;
        else if (credit_length <= 47 && credit_length >= 24)
            credit += 60;
        else if (credit_length <= 23 && credit_length >= 12)
            credit += 35;
        else if (credit_length <= 12)
            credit += 12;

        if (new_credit >= 4)
            credit += 20;
        else if (new_credit == 3)
            credit += 25;
        else if (new_credit == 2)
            credit += 40;
        else if (new_credit == 1)
            credit += 60;
        else if (new_credit == 0)
            credit += 70;

        if (credit_mix >= 4)
            credit += 50;
        else if (credit_mix == 3)
            credit += 60;
        else if (credit_mix == 2)
            credit += 50;
        else if (credit_mix == 1)
            credit += 25;
        else if (credit_mix == 0)
            credit += 15;

        double creditDecimal = credit * 2.46376811594;
        double rounded = Math.round(creditDecimal);
        credit = (int) rounded;
    }

	public void writeToFile(String nameIn) {
		String fileName = new String(nameIn + ".txt");
		File txtFile = new File(fileName);
		PrintWriter pw = null;
		try {
			pw = new PrintWriter( new FileWriter(txtFile, true) );
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}

		String date = Calendar.getInstance().getTime().toString();
		date = date.substring(date.indexOf(" ") + 1, date.indexOf(":") - 3) + ", " + date.substring(date.length() - 4);

		pw.println(date + " - " + credit);
		pw.close();
	}
}
