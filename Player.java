import java.util.*;

import javax.swing.ImageIcon;

public class Player extends Observable {
	private String name;
	private ArrayList<Item> inventory;
	private Room room;
	private ArrayList <MOB> mobArray;
	private int health;
	private String answer;

	// Constructor

	/**
	 * A constructor that takes in a String for a name and a room to start the
	 * player in
	 * 
	 * @param name
	 * @param room
	 */

	public Player(String name, Room room) {
		this.name = name;
		inventory = new ArrayList<Item>();
		this.room = room;
		mobArray = room.mobList(); 
		this.health = 10;
		answer = room.getAnswer();
	}

	// Methods

	/**
	 * Returns name of player
	 * 
	 * @return String: player's name
	 */
	public String getPlayerName() {
		return name;
	}
	/**
	 * returns the riddle from a room
	 * @return string
	 */
	public String getRoomRiddle() {
		return room.getRiddle();
	}
	
	/**
	 * sets the name of the player
	 * 
	 * @param newName
	 */
	public void setPlayerName(String newName) {
		this.name = newName;
	}
	/**
	 * returns the answer of a riddle from a specific room
	 * @return string
	 */
	public String getAnswer(){
		return answer;
	}
	/**
	 * get the player's health
	 * @return int: player's health
	 */
	public int getHealth(){
		return this.health;
	}
	
	/**
	 * set the health of a player
	 * @param newHealth
	 */
	public void setHealth(int newHealth) {
		this.health = newHealth;
	}
	
	/**
	 * checks to see if the players health is zero
	 * @return boolean
	 */
	public boolean dead(){
		if(this.getHealth() == 0){
			return true;
		}
		return false;
	}
	
	/**
	 * returns the current room of a player is in currently.
	 * 
	 * @return The room the player is located in
	 */
	public Room getCurrentRoom() {
		return room;
	}

	/**
	 * returns the name of a room
	 * 
	 * @return String: Room name/description
	 */
	public String getRoomName() {
		return room.getDescription();
	}

	/**
	 * returns the contents of a room as a string
	 * 
	 * @return String: Room's item Arraylist
	 */
	public String getRoomContents() {
		return room.showContents();
	}

	/**
	 * returns the exits in a room as a string
	 * 
	 * @return String: Room's exit Arraylist
	 */
	public String getRoomExits() {
		return room.showExits();
	}
	

	/**
	 * returns the image assoicated with a room
	 * 
	 * @return Image: room image
	 */
	public ImageIcon getRoomImage() {
		return room.getImage();
	}
	
	/**
	 * get the name of the MOBs in a room
	 * @return
	 */
	public String getMobNames() {
		return room.mobsInRoom();
	}
	
	/**
	 * gets the name of a specific mob at index in the ArrayList 
	 * @param index
	 * @return name of MOB
	 */
	public String getMobName(int index){
		return room.mobList().get(index).getName();
	}
	
	/**
	 * Get the ArrayList of MOBs
	 * @return Arraylist of MOBs
	 */
	public ArrayList<MOB> mobList() {
		return room.mobList();
	}
	
	
	/**
	 * Returns the ArrayList of Items in the player's inventory 
	 * @return Room item Arraylist
	 */
	public ArrayList<Item> getInventory() {
		return this.inventory;
	}
	
	/**
	 * kill a specific MOB by checking its name
	 * @param mobName
	 */
	public void MOBkill(String mobName) {
		for (int i = 0; i < mobArray.size(); i++){
			if (mobName == mobArray.get(i).getName()){
				mobArray.get(i).kill();
			}
		}

	}
	

	/**
	 * Checks to see if an exit is there and then moves the player through that exit
	 * @param direction
	 */
	public void go(String direction) {
		if (room.checkExits(direction)) {
			Exit next = room.getExit(direction);
			room = next.getNextRoom();
			this.setChanged();
			this.notifyObservers();
		}
	}

	
	
	/**
	 * shows the items a player has in their inventory
	 * 
	 * @return String: player's inventory 
	 */
	public String showInventory() {
		String invent = new String("");
		for (Item it : inventory) {
			invent = invent + "\n" + it.getItemName();
		}
		return invent;
	}

	/**
	 * Check through the player's inventory for an item
	 * 
	 * @param it
	 * @return boolean
	 */
	public Item checkInventory(Item it) {
		for (int i = 0; i < inventory.size(); i++) {
			if (it.equals(i)) {
				return it;
			}
		}
		return null;
	}

	/**
	 * the player can pick up items and add to the inventory
	 * 
	 * @param item
	 * @return boolean
	 */
	public boolean getItem(String item) {
		Room r = this.room;
		Item it = r.getItem(item);
		ArrayList<Item> items = this.inventory;
		if (r.checkContents(it)) {
			items.add(it);
			this.inventory = items;
			r.removeItem(it);
			return true;
		}
		return false;
	}

	/**
	 * the player can drop item from their inventory
	 * 
	 * @param item
	 * @return boolean
	 */
	public boolean dropItem(String item) {
		for (Item it : inventory) {
			if (it.getItemName().equalsIgnoreCase(item)) {
				inventory.remove(it);
				room.addItem(it);
				return true;
			}
		}
		return false;
	}
	
}
