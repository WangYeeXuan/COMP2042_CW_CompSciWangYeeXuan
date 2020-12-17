package controller;

import javafx.fxml.FXML;

public class Info_page_controller {

	private Game_controller gameController;
	
	public void setGameController(Game_controller gameController) {
		
		this.gameController = gameController;
		
	}
	
	@FXML
	private void exitInfo() {
		
		gameController.previousScene();
		
	}
	
}
