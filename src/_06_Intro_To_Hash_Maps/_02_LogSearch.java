package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addId = new JButton();
	JButton searchId = new JButton();
	JButton viewList = new JButton();
	JButton removeId = new JButton();
	String newIds = "";
	int newId = 000;
	String newName = "";
	HashMap<Integer, String> stuIds = new HashMap<Integer, String>();
	static _02_LogSearch searcher = new _02_LogSearch();

	public static void main(String[] args) {
		searcher.setUp();
	}

	void setUp() {
		frame.add(panel);
		panel.add(addId);
		panel.add(searchId);
		panel.add(viewList);
		// panel.add(removeId);
		addId.addActionListener(this);
		searchId.addActionListener(this);
		viewList.addActionListener(this);
		removeId.addActionListener(this);
		frame.setTitle("Log Searcher");
		addId.setText("Add Entry");
		searchId.setText("Search By ID");
		viewList.setText("View List");
		removeId.setText("Remove Entry");
		frame.setVisible(true);
		frame.setSize(350, 120);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == addId) {
			newIds = JOptionPane.showInputDialog("Put In New Student ID (New Students With The Same Id Will Overide The Older Student With That Id)");
			newId = Integer.parseInt(newIds);
			newName = JOptionPane.showInputDialog("Put In New Student Name");
			stuIds.put(newId, newName);
			// System.out.println(stuIds);
			if (stuIds.size() > 0) {
				panel.add(removeId);
				frame.pack();
			}
		} else if (e.getSource() == removeId) {
			newIds = JOptionPane.showInputDialog("Student Id To Remove");
			newId = Integer.parseInt(newIds);
			if(stuIds.containsKey(newId)) {
				stuIds.remove(newId);
			} else {
				JOptionPane.showMessageDialog(null, "This Student Id Does Not Exist");
			}
			if (stuIds.size() < 1) {
				panel.remove(removeId);
				frame.pack();
			}
		} else if (e.getSource() == searchId) {
			newIds = JOptionPane.showInputDialog("Put In Student Id To Search");
			newId = Integer.parseInt(newIds);
			if(stuIds.containsKey(newId)) {
			JOptionPane.showMessageDialog(null,
					"The Student With And Id Of " + newIds + " Is " + stuIds.get(newId) );}
			else {
				JOptionPane.showMessageDialog(null, "There Is No Student With This Id");
			}
		} else if (e.getSource() == viewList) {
			String message = "";
			for (int key : stuIds.keySet()) {
				message+="Id: "+ key+ " Name: "+ stuIds.get(key)+ "\n";
			}
			JOptionPane.showMessageDialog(null, message);
		}
	}
}
