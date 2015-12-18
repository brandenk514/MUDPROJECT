import java.util.*;

import javax.swing.ImageIcon;

public class Room {

	private String description;
	private ArrayList<Item> contents;
	private ArrayList<Exit> exits;
	private ArrayList<MOB> mobs;
	private Player player;
	private ImageIcon image;
	private String riddle;
	private String answer;
	
	// Constructor

	/**
	 * A constructor that takes in a string for a description of a room
	 * 
	 * @param description
	 */

	public Room(String description, String riddle, String answer, ImageIcon image) {
		this.description = description;
		this.riddle = riddle;
		this.contents = new ArrayList<Item>();
		this.exits = new ArrayList<Exit>();
		this.mobs = new ArrayList<MOB>();
		this.image = image;
		this.riddle = riddle;
		this.answer = answer;

	}
	
	// Methods

	/**
	 * gets description of room
	 * 
	 * @return String: room description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * gets the riddle from the room
	 * 
	 * @return string
	 */
	public String getRiddle() {
		return riddle;
	}
	/**
	 * gets the answer from a room
	 * 
	 * @return string
	 */
	public String getAnswer(){
		return answer;
	}
	
	/**
	 * add a MOB the room's MOB arrayList
	 * @param mob
	 */
	
	public void addMob(MOB mob) {
		mobs.add(mob);
	}
	
	/**
	 * removes a Mob from the room's MOB arrayList
	 * @param mob
	 */
	public void removeMob(MOB mob){
		mobs.remove(mob);
	}
	
	/**
	 * add an exit to the room
	 * 
	 * @param exit
	 */
	public void addExit(Exit exit) {
		exits.add(exit);
	}

	/**
	 * returns the image of a room
	 * @return Image: A room's image
	 */
	public ImageIcon getImage() {
		return image;
	}
	
	/**
	 * returns the Arraylist of MOBs
	 * @return the room's ArrayList of MOBs
	 */
	public ArrayList<MOB> mobList() {
		return this.mobs;
	}
	
	/**
	 * returns in names of MOBs in a room
	 * @return String: Arraylist of MOBs
	 */
	public String mobsInRoom() {
		String mobNames = new String("");
		for (MOB m : mobs) {
			mobNames = mobNames + "\n"+ m.getName();
		}
		return mobNames;
	}

	
	/**
	 * Checks the exit's direction and gets that exit from the room
	 * 
	 * @param direction
	 * @return exit
	 */
	public Exit getExit(String direction) {
		for (Exit ex : exits) {
			if (ex.getDirection().equalsIgnoreCase(direction)) {
				return ex;
			}
		}
		return null;
	}
	
	/**
	 * returns the ArrayList of Exits
	 * @return Arraylist of Exits
	 */
	public ArrayList<Exit> getAllExits() {
		return this.exits;
	}

	/**
	 * Checks the exits in Room by comparing the string and the exit direction
	 * 
	 * @param direction
	 * @return boolean
	 */

	public Boolean checkExits(String direction) {
		for (Exit ex : exits) {
			if (ex.getDirection().equalsIgnoreCase(direction)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * returns the length of the exit array in a room
	 * @return int: number of exits
	 */
	public int getNumOfExits() {
		return exits.size();
	}

	/**
	 * shows the exits in a room by iterating through the Array and pulling the
	 * direction from the Exit object
	 * 
	 * @return String: exits
	 */
	public String showExits() {
		String allExits = new String("");
		for (Exit ex : exits) {
			allExits = allExits + "\n" + ex.getDirection() + " - " + ex.getNextRoom().getDescription();
		}
		return allExits;
	}
	

	/**
	 * return the Item arraylist of the contents in a room
	 * @return Item arraylist
	 */
	public ArrayList<Item> getContents() {
		return this.contents;
	}
	
	/**
	 * show the contents in a room
	 * 
	 * @return String: Item Arraylist
	 */
	public String showContents() {
		String inventory = new String("");
		for (Item it : contents) {
			inventory = inventory + "\n" + it.getItemName();
		}
		return inventory;
	}

	/**
	 * Check through the  room's contents for an item
	 * 
	 * @param it
	 * @return boolean
	 */
	public Boolean checkContents(Item it) {
		for (Item item : contents) {
			if (it.equals(item)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * adds an item to contents array
	 * 
	 * @param item
	 */
	public Boolean addItem(Item it) {
		contents.add(it);
		return true;
	}
	
	/**
	 * removes an item from the room's contents
	 * @param it
	 * @return boolean
	 */

	public Boolean removeItem(Item it) {
		contents.remove(it);
		return true;
	}

	/**
	 * add and item from the player's inventory into the room's contents
	 * @param item
	 * @return boolean 
	 */
	public Item getItem(String item) {
		ArrayList<Item> items = this.contents;
		for (int i = 0; i < items.size(); i++) {
			Item it = items.get(i);
			if (item.equals(it.getItemName())) {
				return it;
			}
		}
		Item none = new Item("No item exist");
		return none;
	}

}
