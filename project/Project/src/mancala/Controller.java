package mancala;

import java.util.Iterator;

/**
 * Mancala model-view controller between the Application class and GUI.
 */
public class Controller {
	Application app;
	Gui gui;
	
	/**
	 * Handle Gui events here.
	 * @param event The gui event
	 * @param data Relevant data for event or null otherwise.
	 */
	public void handleGuiEvent(GuiEvent event, Object data) {
		switch (event) {
			case NEW_GAME:
				System.out.println("Starting new game");
				app.startGame(false);
				refreshDisplay();
				return;
			case REMATCH:
				return;
			case SET_PLAYER_NAMES:
				return;
			case SHOW_HIGHSCORES:
				return;
			case SHOW_MANUAL:
				return;
			case QUIT:
				System.out.println("Exiting mancala application");
				System.exit(0);
			default:
				return;
		}
	}
	
	/**
	 * Updates the store with given value of first or second player.
	 * @param firstPlayer
	 * @param score
	 */
	private void updateStore(boolean firstPlayer, int score) {
		int x = firstPlayer ? 7 : 0; 
		gui.updateCell(x, 1, Integer.toString(score));
	}
	
	private void updateHouse(boolean firstPlayer, int index, int score) {
		String scoreString = String.valueOf(score);
		if (firstPlayer) {
			gui.updateCell(6-index, 2, scoreString);
		} else {
			gui.updateCell(index+1, 0, scoreString);
		}
	}
	
	/**
	 * This method fetches seed counts from all houses
	 * and stores and then forces the GUI to update.
	 */
	public void refreshDisplay() {
		Player player1 = null;
		Player player2 = null;
		
		// get the first and second player
		Iterator<?> iter = app.iteratorOfPlayer();
		while (iter.hasNext()) {
			Player player = (Player) iter.next();
			if (player.isFirstPlayer()) {
				player1 = player;
			} else {
				player2 = player;
			}
		}
		
		// update the stores
		updateStore(true,  player1.getStore().getSeeds());
		updateStore(false, player2.getStore().getSeeds());
		
		// update the houses
		for (int i=0 ; i<Gui.NUM_HOUSES_PER_PLAYER ; ++i) {
			updateHouse(true,  i, player1.getHouse(i).getSeeds());
			updateHouse(false, i, player2.getHouse(i).getSeeds());
		}
	}
	
	/**
	 * Model-view controller constructor.
	 */
	public Controller() {
		app = new Application();
		gui = new Gui(this);
		gui.setVisible(true);
	}
	
	/*
	 * Program entry point.
	 */
	public static void main(String[] args) {
		new Controller();
	}
}
