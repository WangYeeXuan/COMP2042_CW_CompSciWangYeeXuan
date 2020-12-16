package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import main.Main;

public class StartSceneController {

	private GameController gameController;
	
	public void setGameController(GameController gameController) {
		
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
