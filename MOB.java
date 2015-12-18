import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

public class MOB extends Observable implements Runnable {

	private Room room;
	private String name;
	private int sleepTime;
	private ArrayList<Item> mobInventory;
	private boolean run = true;
	private int action;
	private ArrayList<Player> players;
	private Player player;

	/**
	 * Constructor takes a name, a room to start in, and time interval
	 * 
	 * @param name
	 * @param room
	 * @param sTime
	 */
	public MOB(String name, Room room, int sTime, int action, ArrayList<Player> players) {
		this.name = name;
		this.room = room;
		sleepTime = sTime;
		mobInventory = new ArrayList<Item>();
		this.action = action;
		this.players = players;
	}

	/**
	 * Returns name of a mob
	 * 
	 * @return name of MOB
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets the name of the mob
	 * 
	 * @param newName
	 */
	public void setMobName(String newName) {
		this.name = newName;
	}

	/**
	 * returns the current room of a mob.
	 * 
	 * @return current room MOB is in
	 */
	public Room getCurrentRoom() {
		return room;
	}

	/**
	 * returns the name of a room
	 * 
	 * @return name of room
	 */
	public String getRoomName() {
		return room.getDescription();
	}

	/**
	 * returns the contents of a room as a string
	 * 
	 * @return string of room contents
	 */
	public String getRoomContents() {
		return room.showContents();
	}

	/**
	 * returns the exits in a room as a string
	 * 
	 * @return Room exits as string
	 */
	public String getRoomExits() {
		return room.showExits();
	}
	/**
	 * returns the integer of an action
	 * 
	 * @return int of Action
	 */
	public int getAction() {
		return action;
	}
	
	/**
	 * runs through player array and grabs a specific player
	 * 
	 * @return player
	 */
	public Player getPlayer(Player p) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getPlayerName() == p.getPlayerName()) {
				return p;
			} else if (players.isEmpty()) {

			}
		}
		return null;
	}

	/**
	 * Test to see if a exit in a room and moves the mob through that exit
	 * 
	 * @param direction
	 * 
	 */
	public void mobGo(String direction) {
		if (room.checkExits(direction)) {
			Exit next = room.getExit(direction);
			Room oldRoom = room;
			room = next.getNextRoom();
			oldRoom.removeMob(this);
			room.addMob(this);
			this.setChanged();
			this.notifyObservers();
		}

	}

	/**
	 * steals an item from the room and puts in the MOB's inventory
	 * 
	 */
	public void roomSteal(Room r) {
		ArrayList<Item> roomItems = r.getContents();
		if (roomItems.size() > 1) {
			Item it = r.getContents().get(1);
			roomItems.remove(it);
			mobInventory.add(it);
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * steals the first Item from the player's inventory
	 */
	public void playerSteal(Player p) {
		ArrayList<Item> roomItems = room.getContents();
		ArrayList<Item> playerItems = p.getInventory();
		if (playerItems.size() > 0) {
			Item it = playerItems.get(0);
			playerItems.remove(it);
			roomItems.add(it);
			setChanged();
			notifyObservers();
		}


	}

	/**
	 * destroys the players inventory by clearing it
	 */
	public void vandalize(Player p) {
		ArrayList<Item> playerItems = p.getInventory();
		if (playerItems.isEmpty()) {

		} else {
			playerItems.clear();
			setChanged();
			notifyObservers();
		}
	}
	/**
	 * lowers players healthy by 2
	 */
	public void attack(Player p) {
		if (p.getHealth() == 0){
			
		}
		else {
			p.setHealth(p.getHealth() - 2);
			setChanged();
			notifyObservers();
		}
	}
	/**
	 * gets the player at the specific index
	 * @param integer
	 * @return player
	 */
	public Player getPlayer(int i) {
		ArrayList<Player> players = this.players;
		return players.get(i);
	}
	/**
	 * raises players health by 2
	 */
	public void heal(Player p){
		if(p.getHealth() == 10){
			
		}
		else{
			p.setHealth(p.getHealth() + 2);
			setChanged();
			notifyObservers();
		}
	}
	/**
	 * gets the mob in the array list inventory
	 * @return ArrayList
	 */
	public ArrayList<Item> getInventory() {
		return this.mobInventory;
	}
	
	/**
	 * shows the items in a mob has in their inventory
	 * 
	 * @return string of Inventory
	 */
	public String showInventory() {
		String invent = new String("");
		for (Item it : mobInventory) {
			invent = invent + "\n" + it.getItemName();
		}
		return invent;
	}

	/**
	 * Check through the mob's inventory for an item
	 * 
	 * @param it
	 * @return item in inventory
	 */
	public Item checkInventory(Item it) {
		for (int i = 0; i < mobInventory.size(); i++) {
			if (it.equals(i)) {
				return it;
			}
		}
		return null;
	}

	/**
	 * the mob can pick up items and add to the inventory
	 * 
	 * @param item
	 * @return true or false
	 */
	public boolean getItem(String item) {
		Room r = this.room;
		Item it = r.getItem(item);
		ArrayList<Item> items = this.mobInventory;
		if (r.checkContents(it)) {
			items.add(it);
			this.mobInventory = items;
			r.removeItem(it);
			return true;
		}
		return false;
	}

	/**
	 * the mob can drop item from their inventory
	 * 
	 * @param item
	 * @return removes Item from MOB Arraylist
	 */
	public boolean dropItem(String item) {
		for (Item it : mobInventory) {
			if (it.getItemName().equalsIgnoreCase(item)) {
				mobInventory.remove(it);
				room.addItem(it);
				return true;
			}
		}
		return false;
	}

	/**
	 * creates a random integer for the mob that is used in the mobThread class
	 * 
	 * @param min
	 * @return integer
	 */

	public int randInt() {
		Random rand = new Random();
		int randomInt = (rand.nextInt(room.getNumOfExits()));
		return randomInt;
		// generate a random int between 0 and n-1
	}

	/**
	 * set the boolean value to false
	 * 
	 * @param newStop
	 */
	public void setStop(boolean stop) {
		this.run = stop;
	}

	/**
	 * kills the MOB by setting the condition of the while loop to false
	 */
	public void kill() {
		this.setStop(false);
	}
	/**
	 *executes all the mob methods playersteal, attack, heal, valdalize, roomsteal, and go
	 * 
	 */
	@Override
	public void run() {
		try {
			while (run) {
				// get number of exits
				// choose random values
				// take an exit in the arraylist
					if (players != null && this.getCurrentRoom().getAllExits() != null) {
						ArrayList<Exit> roomExits = room.getAllExits();
						Exit goExit = roomExits.get(this.randInt());
						Thread.sleep(sleepTime);
						Player p1 = players.get(0);
						Player p2 = players.get(1);
						if (this.getAction() == 1 && players != null && this.getCurrentRoom() == p1.getCurrentRoom()) {
							this.attack(p1);
							setChanged();
							notifyObservers();
						} else if (this.getAction() == 1 && players != null && this.getCurrentRoom() == p2.getCurrentRoom()) {
							this.attack(p2);
							setChanged();
							notifyObservers();
						}
						else if (this.getAction() == 2 && players != null && this.getCurrentRoom() == p1.getCurrentRoom()) {
							this.playerSteal(p1);
							setChanged();
							notifyObservers();
						} else if (this.getAction() == 2 && players.size() > 0 && this.getCurrentRoom() == p2.getCurrentRoom()) {
							this.playerSteal(p2);
							setChanged();
							notifyObservers();
						} else if (this.getAction() == 3 && players.size() > 0 && this.getCurrentRoom().getContents() != null) {
							this.roomSteal(this.getCurrentRoom());
							setChanged();
							notifyObservers();
						} else if (this.getAction() == 4 && players.size() > 0 && this.getCurrentRoom() == p1.getCurrentRoom()) {
							this.vandalize(p1);
							setChanged();
							notifyObservers();
						}  else if (this.getAction() == 4 && players.size() > 0 && this.getCurrentRoom() == p2.getCurrentRoom()) {
							this.vandalize(p2);
							setChanged();
							notifyObservers();
						}else if (this.getAction() == 5 && players.size() > 0 && this.getCurrentRoom() == p1.getCurrentRoom()){
							this.heal(p1);
							setChanged();
							notifyObservers();
						} else if (this.getAction() == 5 && players.size() > 0 && this.getCurrentRoom() == p2.getCurrentRoom()){
							this.heal(p2);
							setChanged();
							notifyObservers();
						}else {
							
						}
						setChanged();
						notifyObservers();
						this.mobGo(goExit.getDirection());
					} else {
						Thread.interrupted();
					}
				}
		} catch (InterruptedException ie) {

		}
	}
}
