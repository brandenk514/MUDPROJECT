import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.util.*;

public class MUDInputListener implements ActionListener {

	//private JTextField input;
	private Player player;
	private JTextArea area;
	private JTextArea Contentdisplay;
	private JTextArea display2;
	private ArrayList<Thread> mobThread;


	public MUDInputListener(Player p, JTextArea display, JTextArea Cdisplay,
			JTextArea Idisplay, ArrayList<Thread> mobT) {
		player = p;
		area = display;
		Contentdisplay = Cdisplay;
		display2 = Idisplay;
		mobThread = mobT;
	}
	/**
	 * executes the get, drop, kill, and tests to see if the player has won the game
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField textField = (JTextField) e.getSource();
		Scanner s = new Scanner(textField.getText());

		String cmd = s.next();

		if (cmd.equalsIgnoreCase("get")) {
			cmd = s.next();// Add check for room
			if (player.getItem(cmd) == true) {
				player.getItem(cmd);
				if (cmd.equalsIgnoreCase("wedding-ring") || cmd.equalsIgnoreCase("onion") || cmd.equalsIgnoreCase("sandal") || cmd.equalsIgnoreCase("typewriter")){
					winWin.infoBox("You have won. Congratulations!", "Winner");
					
					for (int i =0; i < player.mobList().size(); i++){
						if (player.getMobName(i).equalsIgnoreCase(cmd)){
							try {
								mobThread.get(i).interrupt();
								mobThread.get(i).join();
							} catch (InterruptedException oe) {
								// TODO Auto-generated catch block
							}
							
				}
					}
					System.exit(0);
			
				}
				area.append("\n" + "You have picked up the" + " " + cmd + "\n");
				Contentdisplay.setText(player.getRoomContents());
				display2.setText(player.showInventory()); 
				}else {
				area.append("\n" + "That item does not exist." + "\n");
			}
		} else if (cmd.equalsIgnoreCase("drop")) {
			cmd = s.next();// Add inventory check
			if (player.dropItem(cmd) == true) {
				player.dropItem(cmd);
				area.append("\n" + "You have dropped the" + " " + cmd + "\n");
				Contentdisplay.setText(player.getRoomContents());
				display2.setText(player.showInventory());
			} else {
				area.append("\n" + "You do not have that item." + "\n");
			}	
		}	 else if (cmd.equalsIgnoreCase("kill")) {
			cmd = s.next();
			for (int i =0; i < player.mobList().size(); i++){
			if (player.getMobName(i).equalsIgnoreCase(cmd)){
				try {
					mobThread.get(i).interrupt();
					mobThread.get(i).join();
				} catch (InterruptedException oe) {
					// TODO Auto-generated catch block
				}
				
			}
			}
			area.append("\n" + cmd + " has been killed");
			
		} else if (cmd.equalsIgnoreCase("exit")) {
			for (int i = 0; i < mobThread.size(); i++) {
				try {
					mobThread.get(i).interrupt();
					mobThread.get(i).join();
				} catch (InterruptedException oe) {
					// TODO Auto-generated catch block
				}
				
			}
			System.exit(0);
		} else
			area.append("\n" + "Unrecognized command." + "\n");
	}
	}
