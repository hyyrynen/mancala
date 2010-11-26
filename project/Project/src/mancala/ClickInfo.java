package mancala;

/**
 * This class contains the click info of a button clicked in Mancala window.
 */
public class ClickInfo {
	/// Did first player click on the button.
	private boolean firstPlayer;
	
	/// What is the house index he/she clicked on.
	private int index;
	
	/**
	 * Construct a ClickInfo instance.
	 * 
	 * @param firstPlayer Did the fist player perform the click.
	 * @param index The index of clicked house.
	 */
	public ClickInfo(boolean firstPlayer, int index) {
		this.firstPlayer = firstPlayer;
		this.index = index;
	}

	/**
	 * Was this instance initiated by a click of the first player.
	 * @return
	 */
	public boolean belongsToFirstPlayer() {
		return firstPlayer;
	}

	/**
	 * What was the index of the clicked house.
	 * @return
	 */
	public int getIndex() {
		return index;
	}
}
