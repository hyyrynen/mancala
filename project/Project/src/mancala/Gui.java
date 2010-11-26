package mancala;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * This is a regular JButton, but additionally holds the information of
 * which player owns it and what is the house index this button represents.
 */
class MancalaButton extends JButton {
	private static final long serialVersionUID = -40781832342111414L;
	
	/// Does this button belong to first player.
	private boolean firstPlayer;
	
	/// What is the house index of the button as given in the model.
	private int index;
	
	/**
	 * Create a mancala player button.
	 * @param text
	 * @param firstPlayer Does it belong to first player.
	 * @param index The index of the button as it is in the UML model.
	 */
	public MancalaButton(String text, boolean firstPlayer, int index) {
		super(text);
		this.setFirstPlayer(firstPlayer);
		this.setIndex(index);
	}

	/**
	 * Set the index of the button.
	 * @param index
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Get the index of the button.
	 * @return
	 */	 
	public int getIndex() {
		return index;
	}

	/**
	 * Set the player of the function.
	 * @param firstPlayer If true, then assign this button to first player.
	 */
	public void setFirstPlayer(boolean firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	/**
	 * Does this house belongs to the first player.
	 * @return
	 */
	public boolean isFirstPlayer() {
		return firstPlayer;
	}
}

/**
 * Mancala GUI frame class.
 */
public class Gui extends JFrame implements ActionListener {
	private static final long serialVersionUID = -1049958103353244632L;
	
	/// the number of players
	private static int NUM_PLAYERS = 2;
	
	/// number of houses per player
	static int NUM_HOUSES_PER_PLAYER = 6;
	
	/// Gui controller
	private Controller controller;
	
	// menu specific variables
	JMenuBar menuBar;
	JMenu mainMenu, helpMenu;
	JMenuItem newGameMenuItem;
	JMenuItem restartGameMenuItem;
	JMenuItem playerNamesMenuItem;
	JMenuItem highscoresMenuItem;
	JMenuItem quitMenuItem;
	JMenuItem helpMenuItem;
	
	
	// stores & mancalas
	JButton[] stores;
	JButton[][] houses;
	
	// grid for empty buttons in GridLayout
	JButton[][] buttonGrid;
	private static int GRID_WIDTH = 8;
	private static int GRID_HEIGHT = 3;
	
	/**
	 * Ask player names through input windows and fire an GUI event to the controller.
	 */
	private void askAndSetPlayerNames() {
		String firstName = 
			JOptionPane.showInputDialog("Enter name of the first player", controller.app.getFirstPlayer().getName());
		String secondName = 
			JOptionPane.showInputDialog("Enter name of the second player", controller.app.getSecondPlayer().getName());
		String[] names = new String[2];
		names[0] = firstName;
		names[1] = secondName;
		
		controller.handleGuiEvent(GuiEvent.SET_PLAYER_NAMES, names);
	}
	
	
	/**
	 * Setup menus.
	 */
	private void setupMenus() {
		menuBar = new JMenuBar();
		
		// main menu with items
		mainMenu = new JMenu("Mancala");
		newGameMenuItem = new JMenuItem("Play Player vs Player");
		restartGameMenuItem = new JMenuItem("Rematch");
		playerNamesMenuItem = new JMenuItem("Edit player names");
		highscoresMenuItem = new JMenuItem("Show highscores");
		quitMenuItem = new JMenuItem("Quit Mancala");
		
		mainMenu.add(newGameMenuItem);
		mainMenu.add(restartGameMenuItem);
		mainMenu.add(playerNamesMenuItem);
		mainMenu.add(highscoresMenuItem);
		mainMenu.addSeparator();
		mainMenu.add(quitMenuItem);
		restartGameMenuItem.setEnabled(false);
		
		// event-handlers
		newGameMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.handleGuiEvent(GuiEvent.NEW_GAME, null);
			}
		});
		
		restartGameMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.handleGuiEvent(GuiEvent.REMATCH, null);
			}
		});
		
		playerNamesMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				askAndSetPlayerNames();
			}
		});
		
		highscoresMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.handleGuiEvent(GuiEvent.SHOW_HIGHSCORES, null);
			}
		});
		
		quitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.handleGuiEvent(GuiEvent.QUIT, null);
			}
		});
		
		// help menu
		helpMenu = new JMenu("Help");
		helpMenuItem = new JMenuItem("Show manual");
		
		helpMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.handleGuiEvent(GuiEvent.SHOW_MANUAL, null);
				
				JFrame manualFrame = new JFrame("Manual");
			    JPanel panel = new JPanel();
			    JTextArea jt = new JTextArea("Rules: " + '\n'+
			    		" 1. Each player controls the six houses and their seeds on his side of the board. " + '\n' +
			    		"     His score is the number of seeds in the store to his right." + '\n'+'\n'+
			    		" 2. If the last sown seed lands in the player's store, the player gets an additional move" + '\n' + '\n'+
			    		" 3. If the last sown seed lands in an empty house owned by the player, and the opposite " + '\n' + 
			    		"     house contains seeds, both the last seed and the opposite seeds are captured and placed " + '\n' +
			    		"     into the player's store." + '\n' + '\n' +
			    		" 4. When one player no longer has any seeds in any of his houses, the game ends." + '\n' +
			    		"     The player with the most seeds in his store wins.",55,47);
			    
			    jt.setEditable(false);
			    manualFrame.add(panel);
			    panel.add(jt);
			    
			    manualFrame.setSize(525,300);
			    manualFrame.setResizable(false);
			    manualFrame.setVisible(true);
			}
		});
		
		helpMenu.add(helpMenuItem);
		
		// add menus to menubar
		menuBar.add(mainMenu);
		menuBar.add(helpMenu);
		
		setJMenuBar(menuBar);
	}
	
	/**
	 * Put the stores and houses onto layout and initialize them.
	 * (1,0) .. (6,0) are the houses of the second player
	 * (1,2) .. (6,2) are the houses of the first player
	 * (0,0)  The name of the second player
	 * (7,2)  The name of the first player
	 * (0,1)  The store of the second player
	 * (7,1)  The store of the first player.
	 */
	private void setupStoresAndHouses() {
		GridLayout layout = new GridLayout(Gui.GRID_HEIGHT, Gui.GRID_WIDTH);
		setLayout(layout);
		
		// create the buttongrid
		buttonGrid = new JButton[Gui.GRID_WIDTH][Gui.GRID_HEIGHT];
		for (int j=0 ; j<Gui.GRID_HEIGHT ; ++j) {
			for (int i=0 ; i<Gui.GRID_WIDTH ; ++i) {
				buttonGrid[i][j] = new JButton(i + " " + j);
				buttonGrid[i][j].setVisible(false);
			}
		}
		
		// setup player name buttons
		buttonGrid[0][0].setText("Player2");
		buttonGrid[7][2].setText("Player1");
		buttonGrid[0][0].setVisible(true);
		buttonGrid[7][2].setVisible(true);
		buttonGrid[0][0].setEnabled(false);
		buttonGrid[7][2].setEnabled(false);
		
		// creates stores
		stores = new JButton[Gui.NUM_PLAYERS];
		for (int i=0 ; i<Gui.NUM_PLAYERS ; ++i) {
			stores[i] = new JButton("0");
		}
		
		// put them into buttongrid
		buttonGrid[0][1] = stores[0];
		buttonGrid[7][1] = stores[1];
		
		// create houses
		houses = new JButton[Gui.NUM_PLAYERS][Gui.NUM_HOUSES_PER_PLAYER];
		
		for (int i=0 ; i<Gui.NUM_HOUSES_PER_PLAYER ; ++i) {
			houses[0][i] = new MancalaButton("0", false, i);
			houses[1][i] = new MancalaButton("0", true, 5-i);
			houses[0][i].addActionListener(this);
			houses[1][i].addActionListener(this);
			
			buttonGrid[i+1][0] = houses[0][i];
			buttonGrid[i+1][2] = houses[1][i];
		}
		
		// add buttongrid to layout
		for (int j=0 ; j<Gui.GRID_HEIGHT ; ++j) {
			for (int i=0 ; i<Gui.GRID_WIDTH ; ++i) {
				buttonGrid[i][j].setEnabled(false);
				add(buttonGrid[i][j]);
			}
		}
	}
	
	/**
	 * Handle the clicks on the MancalaButtons.
	 * @param e The actionevent.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		MancalaButton button = (MancalaButton) e.getSource();
		ClickInfo info = new ClickInfo(button.isFirstPlayer(), button.getIndex());
		controller.handleGuiEvent(GuiEvent.BUTTON_CLICKED, info);
	}
	
	/**
	 * Update the cell at given coordinates in the layout with given text.
	 * @param x The x coordinate of the button in layout.
	 * @param y The y coordinate of the button in layout.
	 * @param text The text to display
	 */
	public void updateCell(int x, int y, String text) {
		buttonGrid[x][y].setText(text);
	}
	
	/**
	 * Enable/disable a cell.
	 * 
	 * @param x The x-coordinate.
	 * @param y The y-coordinate.
	 * @param enabled If true, then enable, disable otherwise.
	 */
	public void enableCell(int x, int y, boolean enabled) {
		buttonGrid[x][y].setEnabled(enabled);
	}
	
	/**
	 * Show a GameOver popup containing given text.
	 * @param text The message to display.
	 */
	public void displayGameOver(String text){
		JOptionPane gameOver = new JOptionPane();
		gameOver.setName("GameOver"); 	// not correct
		JOptionPane.showMessageDialog(this, text);
	}
	
	/**
	 * Show a popup containing highscores
	 * 
	 * @param highscores The string to be displayed.
	 */
	public void showHighScores(String highscores) {
		JOptionPane.showMessageDialog(this, highscores);
	}
	
	/**
	 * Initializes necessary components of Mancala GUI.
	 * @param controller The controller instance of this Gui instance.
	 */
	public Gui(Controller controller) {
		super();
		this.controller = controller;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setupStoresAndHouses();
		this.setupMenus();
		this.setSize(800, 400);
		this.setTitle("Mancala");
	}
}
