package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main_menu_controller {

	private Game_controller gameController;
	
	public void setGameController(Game_controller gameController) {
		
		this.gameController = gameController;
		
	}
	
	@FXML
	private void startGame() {
		
		gameController.start();
		
	}
	
	@FXML
	private void openInfo() {
		
		gameController.nextScene();
		
	}
	
	@FXML
	public Button closeButton;
	
	@FXML
	private void closeWindow(ActionEvent event) {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}
	
}
