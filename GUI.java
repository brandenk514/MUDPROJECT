import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame implements Observer {

	private Player player;
	private JTextArea contentsText,exitText,inventoryText, MOBtext, outputText;
	private JTextField userInput;
	private JLabel healthText;
	private ArrayList<Item> items;


	public GUI(Player player, ArrayList<Thread> mobThread) {
		this.player = player;
		// Development of Application window
		JFrame appWindow = new JFrame();
		appWindow.setSize(800, 800);
		appWindow.setLayout(new BorderLayout());
		appWindow.setTitle("Exploration");

		// Made appPanel and buttons
		JPanel appPanel = new JPanel();
		appPanel.setLayout(new BorderLayout());

		JButton north = new JButton("North");
		appPanel.add(north, BorderLayout.NORTH);

		JButton east = new JButton("East");
		appPanel.add(east, BorderLayout.EAST);

		JButton south = new JButton("South");
		appPanel.add(south, BorderLayout.SOUTH);

		JButton west = new JButton("West");
		appPanel.add(west, BorderLayout.WEST);



		// Created a image display window
		JPanel imagePanel = new JPanel();
		imagePanel.setLayout(new BorderLayout());
		JLabel imageLabel = new JLabel(player.getRoomImage());
		imagePanel.add(imageLabel, BorderLayout.CENTER);
		appPanel.add(imageLabel, BorderLayout.CENTER);

		appWindow.add(appPanel, BorderLayout.CENTER);

		// Made a display panel for all of the displays
		JPanel multiDisplays = new JPanel();
		multiDisplays.setLayout(new BoxLayout(multiDisplays, BoxLayout.Y_AXIS));

		// Adds a display for contents of Text
		contentsText = new JTextArea(10, 10);
		contentsText.setText(player.getCurrentRoom().showContents());
		JScrollPane contentsDisplay = new JScrollPane(contentsText);
		JPanel contentsPanel = new JPanel();
		JLabel contentsLabel = new JLabel("Items in the room");

		contentsPanel.setLayout(new BoxLayout(contentsPanel, BoxLayout.Y_AXIS));
		contentsPanel.add(contentsLabel);
		contentsPanel.add(contentsDisplay);

		multiDisplays.add(contentsPanel);

		// Display for all the exits in a room
		exitText = new JTextArea(10, 10);
		exitText.setText(player.getRoomExits());

		JScrollPane exitScroll = new JScrollPane(exitText);
		JPanel exitDisplay = new JPanel();

		JLabel exitLabel = new JLabel("Exits");
		exitDisplay.setLayout(new BoxLayout(exitDisplay, BoxLayout.Y_AXIS));

		exitDisplay.add(exitLabel);
		exitDisplay.add(exitScroll);

		multiDisplays.add(exitDisplay);

		// Display for the Player's inventory
		inventoryText = new JTextArea(10, 10);
		inventoryText.setText(player.showInventory());
		JScrollPane inventoryDisplay = new JScrollPane(inventoryText);
		JPanel inventoryPanel = new JPanel();
		JLabel inventoryLabel = new JLabel("Inventory");

		inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.Y_AXIS));
		inventoryPanel.add(inventoryLabel);
		inventoryPanel.add(inventoryDisplay);

		multiDisplays.add(inventoryPanel);

		// Display for MOBs in Room

		MOBtext = new JTextArea(10, 10);
		JScrollPane MOBDisplay = new JScrollPane(MOBtext);
		//MOBtext.setText(player.getMobNames());
		JPanel MOBPanel = new JPanel();
		JLabel MOBLabel = new JLabel("MOBs");
		
		MOBPanel.setLayout(new BoxLayout(MOBPanel, BoxLayout.Y_AXIS));
		MOBPanel.add(MOBLabel);
		MOBPanel.add(MOBDisplay);

		multiDisplays.add(MOBPanel);

		// Adds the display panel to the appWindow
		appWindow.add(multiDisplays, BorderLayout.EAST);

		// Input & Output displays
		outputText = new JTextArea(10, 30);
		JScrollPane outputDisplay = new JScrollPane(outputText);
		outputText.setText(player.getCurrentRoom().getRiddle());
		JPanel outputPanel = new JPanel();
		healthText = new JLabel(player.getPlayerName() + "'s health:" + player.getHealth());
		outputPanel.add(healthText);
		outputPanel.add(outputDisplay);
		
		
		// Input
		userInput = new JTextField();
		JScrollPane input = new JScrollPane(userInput);
		JLabel label = new JLabel("Enter a Command");
		
		outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.Y_AXIS));

		userInput.addActionListener(new MUDInputListener(player, outputText, contentsText, inventoryText, mobThread));

		outputPanel.add(label);
		outputPanel.add(input);

		appWindow.add(outputPanel, BorderLayout.SOUTH);

		// Room Label
		JLabel roomLabel = new JLabel(player.getCurrentRoom().getDescription());
		appWindow.add(roomLabel, BorderLayout.NORTH);

		//ActionListeners
		north.addActionListener(new MUDButtonListener(imageLabel, roomLabel, player.getRoomImage(), player, exitText, contentsText, outputText));
		east.addActionListener(new MUDButtonListener(imageLabel, roomLabel, player.getRoomImage(), player, exitText, contentsText, outputText));
		west.addActionListener(new MUDButtonListener(imageLabel, roomLabel, player.getRoomImage(), player, exitText, contentsText, outputText));
		south.addActionListener(new MUDButtonListener(imageLabel, roomLabel, player.getRoomImage(), player, exitText, contentsText, outputText));

		appWindow.pack();
		appWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appWindow.setVisible(true);

		

	}
	

	@Override
    public void update(Observable o, Object arg) {
        if (o instanceof MOB) {
        	MOBtext.setText(player.getCurrentRoom().mobsInRoom());
        	contentsText.setText(player.getCurrentRoom().showContents());
        	inventoryText.setText(player.showInventory());
            healthText.setText(player.getPlayerName() + "'s health:" + player.getHealth());
            if(player.dead() == true){
            	winWin.infoBox("You have lost. Feel free to feel terrible about yourself!", "Looser!");
				System.exit(0);
            }
        }
    }

}