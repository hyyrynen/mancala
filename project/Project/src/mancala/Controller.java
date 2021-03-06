package mancala;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Mancala model-view controller between the Application class and GUI.
 */
public class Controller {
	private final static Logger logger = Logger.getLogger(Controller.class.getName());
	
	/// The reference to the Mancala application instance
	Application app;
	
	/// Reference to the GUI
	Gui gui;

	/**
	 * Handle GUI events.
	 * 
	 * @param event The gui event
	 * @param data Relevant data for event or null otherwise.
	 */
	public void handleGuiEvent(GuiEvent event, Object data) {
		switch (event) {
			case NEW_GAME:
				logger.info("Starting a new game");
				logger.info("First player is " + app.getFirstPlayer().getName() + " and second player is " + app.getSecondPlayer().getName());
				app.startGame();
				gui.restartGameMenuItem.setEnabled(false);	//disable the rematch menu item
				refreshDisplay();
				return;
			case REMATCH:
				if(app.isGameEnd() == true){
					app.startGame();
					if(app.isFirstPlayerStarts() == true){
						app.setFirstPlayerStarts(false);
						app.changeTurn();
					}
					else{
						app.setFirstPlayerStarts(true);
					}
					app.setGameEnd(false);
					gui.restartGameMenuItem.setEnabled(false);	//disable the rematch menu item
					refreshDisplay();
				}
					
				return;
			case SET_PLAYER_NAMES:
				logger.info("Asking users to enter their names");
				String[] names = (String[])data;
				app.getFirstPlayer().setName(names[0]);
				app.getSecondPlayer().setName(names[1]);
				if(app.getFirstPlayer().getName()=="")
					app.getFirstPlayer().setName("Player1");
				if(app.getSecondPlayer().getName()=="")
					app.getSecondPlayer().setName("Player2");
				
				if(app.isGameEnd()== true){
					gui.updateCell(7, 2, app.getFirstPlayer().getName());
					gui.updateCell(0, 0, app.getSecondPlayer().getName());
				}
				else
					logger.info("First player is " + app.getFirstPlayer().getName() + " and second player is " + app.getSecondPlayer().getName());
					refreshDisplay();
				
				return;
			case SHOW_HIGHSCORES:
				logger.info("Showing highscores");
				logger.info(this.getHighScoreString(app.getTopTen()));
				gui.showHighScores(this.getHighScoreString(app.getTopTen()));
				return;
			case SHOW_MANUAL:
				logger.info("User opened the manual");
				System.out.println("Display manual");
				return;
			case BUTTON_CLICKED:
				ClickInfo info = (ClickInfo)data;
				if (info.belongsToFirstPlayer()) {
					logger.info(app.getFirstPlayer().getName() + " distributes seeds from house number " + (info.getIndex()+1));
					app.getFirstPlayer().playHouse(info.getIndex());
				} else {
					logger.info(app.getSecondPlayer().getName() + " distributes seeds from house number " + (info.getIndex()+1));
					app.getSecondPlayer().playHouse(info.getIndex());
				}
				refreshDisplay();
				
				app.setGameEnd( app.checkEnd());
				System.out.println("Game end=" + app.isGameEnd() + '\n');
				if(app.isGameEnd()== true){//game is over
					logger.info("The game ended");
					gui.restartGameMenuItem.setEnabled(true);	//enable the rematch menu item
					disableHouses();
					String winner;
					if(app.getFirstPlayer().getStore().getSeeds() > app.getSecondPlayer().getStore().getSeeds() )
						winner = "The winner is " + app.getFirstPlayer().getName();
					else if( app.getFirstPlayer().getStore().getSeeds() < app.getSecondPlayer().getStore().getSeeds() )
						winner = "The winner is " + app.getSecondPlayer().getName();
					else
						winner = "The game ended with a draw";
					
					logger.info(winner);
					
					gui.displayGameOver("Game over" + '\n' +
							 app.getFirstPlayer().getName()  + ": " + app.getFirstPlayer().getStore().getSeeds()+ '\n' +
							 app.getSecondPlayer().getName() + ": " + app.getSecondPlayer().getStore().getSeeds() + '\n'+
						     winner );
					
					app.updateTopTen();
					
					logger.info("Showing highscores");
					logger.info(this.getHighScoreString(app.getTopTen()));
					gui.showHighScores(this.getHighScoreString(app.getTopTen()));
				}

					
				return;
			case QUIT:
				System.out.println("Exiting mancala application");
				System.exit(0);
			default:
				return;
		}
	}
	
	/**
	 * Given a TopTen list from application instance, construct a String that is presentable
	 * by a popup window.
	 * 
	 * @param entries - list containing highscores in correct order.
	 * @return Textual representation of the highscore list for a popup meassage.
	 */
	private String getHighScoreString(ArrayList entries) {
		String highscores = "";
		for (Entry entry : (ArrayList<Entry>)entries) {
			highscores += entry.getName() + "\t        \t" + entry.getScore() + "\n";
		}
		return highscores;
	}
	
	/**
	 * Updates the store with given value of first or second player.
	 * 
	 * @param firstPlayer Do we update the store of the first player?
	 * @param score What is the score we put in there.
	 */
	private void updateStore(boolean firstPlayer, int score) {
		int x = firstPlayer ? 7 : 0; 
		gui.updateCell(x, 1, Integer.toString(score));
	}
	
	/**
	 * Update the house.
	 * 
	 * @param firstPlayer Do we update hte house of the first player?
	 * @param index Index of the house.
	 * @param score Score we display in the GUI.
	 * @param enableCell Should the cell be enabled.
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
	 * This method disables the house buttons.
	 */
	public void disableHouses() {
		for (int i=1 ; i<Gui.NUM_HOUSES_PER_PLAYER+1 ; i++) {
			gui.enableCell(i, 0,false);
			gui.enableCell(i, 2,false);
		}
	}
	
	
	
	/**
	 * Model-view controller constructor.
	 */
	public Controller() {
		logger.setLevel(Level.FINEST);
		try {
			logger.addHandler(new FileHandler("mancalalog.txt"));
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
