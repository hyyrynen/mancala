package mancala;


/**
 * Mancala model-view controller between the Application class and GUI.
 */
public class Controller {
	Application app;
	Gui gui;
	boolean gameEnd;
	
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
				String[] names = (String[])data;
				app.getFirstPlayer().setName(names[0]);
				app.getSecondPlayer().setName(names[1]);
				refreshDisplay();
				return;
			case SHOW_HIGHSCORES:
				return;
			case SHOW_MANUAL:
				System.out.println("Display manual");
				return;
			case BUTTON_CLICKED:
				ClickInfo info = (ClickInfo)data;
				System.out.println("Click firstPlayer=" + info.belongsToFirstPlayer() + " index=" + info.getIndex());
				if (info.belongsToFirstPlayer()) {
					app.getFirstPlayer().playHouse(info.getIndex());
				} else {
					app.getSecondPlayer().playHouse(info.getIndex());
				}
				refreshDisplay();
				gameEnd = app.checkEnd();
				System.out.println("Game end=" + gameEnd + '\n');
				if(gameEnd == true);//game is over
				
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
	
	/**
	 * 
	 * @param firstPlayer
	 * @param index
	 * @param score
	 * @param enableCell
	 */
	private void updateHouse(boolean firstPlayer, int index, int score, boolean enableCell) {
		String scoreString = String.valueOf(score);
		
		int x = 6-index;
		int y = 2;
		
		if (!firstPlayer) {
			x = index+1;
			y = 0;
		}
		
		gui.updateCell(x, y, scoreString);
		gui.enableCell(x, y, enableCell);
	}
	
	/**
	 * This method fetches seed counts from all houses
	 * and stores and then forces the GUI to update.
	 */
	public void refreshDisplay() {
		// get the first and second player
		Player player1 = app.getFirstPlayer();
		Player player2 = app.getSecondPlayer();
		
		// whose turn it is
		boolean firstTurn = (player1.getTurn() != null);
		
		// update the stores
		updateStore(true,  player1.getStore().getSeeds());
		updateStore(false, player2.getStore().getSeeds());
		
		// update the houses
		for (int i=0 ; i<Gui.NUM_HOUSES_PER_PLAYER ; ++i) {
			int numseeds1 = player1.getHouse(i).getSeeds();
			int numseeds2 = player2.getHouse(i).getSeeds();
			updateHouse(true,  i, numseeds1, firstTurn && numseeds1 != 0);
			updateHouse(false, i, numseeds2, !firstTurn && numseeds2 != 0);
		}
		
		// update player names
		gui.updateCell(7, 2, player1.getName());
		gui.updateCell(0, 0, player2.getName());
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