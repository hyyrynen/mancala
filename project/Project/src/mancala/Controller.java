package mancala;

/**
 * Mancala model-view controller between the Application class and GUI.
 */
public class Controller {
	Application app;
	Gui gui;
	
	/**
	 * Model-view controller constructor.
	 */
	public Controller() {
		app = new Application();
		gui = new Gui();
		gui.setVisible(true);
	}
	
	/*
	 * Program entry point.
	 */
	public static void main(String[] args) {
		new Controller();
	}
}
