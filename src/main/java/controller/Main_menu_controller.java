package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * This class is responsible for the Main_menu GUI.
 * @author Wang
 */
public class Main_menu_controller {

	private Game_controller Game_controller;
	
	public void setGameController(Game_controller Game_controller) {
		
		this.Game_controller = Game_controller;
		
	}
	
	/**
	 * This method change Main_menu scene to Level_1 scene. This occur when "START" button is clicked.
	 */
	@FXML
	private void Start_game() {
		
		Game_controller.Start_game();
		
	}
	
	/**
	 * This method change Main_menu scene to Info_page scene when "INFO" button is clicked.
	 */
	@FXML
	private void Open_info() {
		
		Game_controller.Next_scene();
		
	}
	
	//connect to close button in fxml
	@FXML
	public Button closeButton;
	
	/**
	 * This method closes the application window when "EXIT" button is clicked by the user.
	 * @param event
	 */
	@FXML
	private void Close_window(ActionEvent event) {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}
	
}
