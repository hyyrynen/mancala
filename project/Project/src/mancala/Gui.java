package mancala;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public void setFirstPlayer(boolean firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public boolean isFirstPlayer() {
		return firstPlayer;
	}
}

/**
 * Mancala GUI class.
 */
public class Gui extends JFrame implements ActionListener {
	private static final long serialVersionUID = -1049958103353244632L;
	
	private static int NUM_PLAYERS = 2;
	static int NUM_HOUSES_PER_PLAYER = 6;
	
	// we need the controller to wire it up with some events
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
	 * Setup menus.
	 */
	private void setupMenus() {
		menuBar = new JMenuBar();
		
		// main menu with items
		mainMenu = new JMenu("Mancala");
		newGameMenuItem = new JMenuItem("Play Player vs Player");
		restartGameMenuItem = new JMenuItem("Restart game");
		playerNamesMenuItem = new JMenuItem("Edit player names");
		highscoresMenuItem = new JMenuItem("Show highscores");
		quitMenuItem = new JMenuItem("Quit Mancala");
		
		mainMenu.add(newGameMenuItem);
		mainMenu.add(restartGameMenuItem);
		mainMenu.add(playerNamesMenuItem);
		mainMenu.add(highscoresMenuItem);
		mainMenu.addSeparator();
		mainMenu.add(quitMenuItem);
		
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
				controller.handleGuiEvent(GuiEvent.SET_PLAYER_NAMES, null);
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
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		MancalaButton button = (MancalaButton) e.getSource();
		ClickInfo info = new ClickInfo(button.isFirstPlayer(), button.getIndex());
		controller.handleGuiEvent(GuiEvent.BUTTON_CLICKED, info);
	}
	
	/**
	 * Update the cell at given coordinates in the layout with given text.
	 * @param x
	 * @param y
	 * @param text
	 */
	public void updateCell(int x, int y, String text) {
		buttonGrid[x][y].setText(text);
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param enabled
	 */
	public void enableCell(int x, int y, boolean enabled) {
		buttonGrid[x][y].setEnabled(enabled);
	}
	
	/**
	 * Initializes necessary components of Mancala GUI.
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
