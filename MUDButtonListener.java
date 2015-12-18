import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class MUDButtonListener implements ActionListener {

	private JButton button;
	private Player player;
	private JLabel label, picLabel;
	private ImageIcon image;
	private JTextArea display, display2, output;

	public MUDButtonListener(JLabel label, JLabel picLabel, ImageIcon image, Player player, JTextArea edisplay, JTextArea cDisplay, JTextArea riddle) {
		this.player = player;
		this.label = label;
		this.picLabel = picLabel;
		this.image = image;
		this.display = edisplay;
		this.display2 = cDisplay;
		this.output = riddle;
	}

	// WHen a button is pressed, the player moves in that direction and the
	// display are updated to show current inventory, room contents, and exits
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		String buttonText = button.getText();
		player.go(buttonText);
		image = player.getRoomImage();
		label.setIcon(image);
		picLabel.setText(player.getCurrentRoom().getDescription());
		display.setText(player.getRoomExits());
		display2.setText(player.getRoomContents());
		output.setText(player.getRoomRiddle());
	}

}