public class Exit {
	private String direction;
	public Room nextRoom;

	// Constructor

	/**
	 * A constructor that takes in a direction and a Room to have the player go
	 * into.
	 * 
	 * @param direction
	 * @param nextRoom
	 */

	public Exit(String direction, Room nextRoom) {
		this.direction = direction;
		this.nextRoom = nextRoom;

	}

	// Methods

	/**
	 * Gets the direction of an exit
	 * 
	 * @return direction as string
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * gets the next room an exit leads to.
	 * 
	 * @return the next room
	 */

	public Room getNextRoom() {
		return nextRoom;
	}

}
