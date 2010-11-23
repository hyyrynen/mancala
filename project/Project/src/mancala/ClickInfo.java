package mancala;

/**
 * This class contains the click info of a button clicked in Mancala window.
 */
public class ClickInfo {
	/// Did first player click on the button.
	private boolean firstPlayer;
	
	/// What is the house index he/she clicked on.
	private int index;
	
	public ClickInfo(boolean firstPlayer, int index) {
		this.firstPlayer = firstPlayer;
		this.index = index;
	}

	public boolean belongsToFirstPlayer() {
		return firstPlayer;
	}

	public int getIndex() {
		return index;
	}
}
