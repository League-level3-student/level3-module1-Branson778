package _00_Intro_To_ArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
    /*
     * Create a GUI with two buttons. One button reads "Add Name" and the other
     * button reads "View Names". When the add name button is clicked, display
     * an input dialog that asks the user to enter a name. Add that name to an
     * ArrayList. When the "View Names" button is clicked, display a message
     * dialog that displays all the names added to the list. Format the list as
     * follows:
     * Guest #1: Bob Banders
     * Guest #2: Sandy Summers
     * Guest #3: Greg Ganders
     * Guest #4: Donny Doners
     */
 JFrame frame = new JFrame();
 JPanel panel = new JPanel();
 JButton view = new JButton();
 JButton add = new JButton();
 ArrayList<String> guests = new ArrayList<String>();


void setUp() {
	view.addActionListener(this);
	add.addActionListener(this);
	frame.add(panel);
	panel.add(add);
	panel.add(view);
	view.setText("View Guests");
	add.setText("Add Guests");
	guests.add("Guest #1: Bob Banders");
	guests.add("Guest #2: Sandy Summers");
	guests.add("Guest #3: Greg Ganders");
	guests.add("Guest #4: Donny Doners");
	frame.setTitle("Guest Book");
	frame.pack();
	frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
@Override
public void actionPerformed(ActionEvent e) {
if(e.getSource()==view) {
	String guest = "";
	for (int i = 0; i < guests.size(); i++) {
    guest+= guests.get(i)+"\n";
	}
	JOptionPane.showMessageDialog(null, guest);
}
if(e.getSource()==add) {
	String newGuest = JOptionPane.showInputDialog("Type The Name of Your New Guest");
	guests.add("Guest #" + (guests.size()+1) +": " +newGuest );
}
}
}
