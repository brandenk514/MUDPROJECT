public class Item {
	
	private String item;
	private int health;
	private Player player;
	
	// constructor
	/**
	 * A constructor that takes in a String for an item name
	 * 
	 * @param object
	 */

	public Item(String item){
		this.item = item;
	}
	// Methods

	/**
	 * Returns the name of an Item
	 * 
	 * @return String: Item name
	 */

	public String getItemName() {
		return item;
	}
	
}
