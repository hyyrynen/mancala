package mancala;

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
