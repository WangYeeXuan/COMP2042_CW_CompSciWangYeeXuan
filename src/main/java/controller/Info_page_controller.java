package controller;

import javafx.fxml.FXML;

/**
 * This class is responsible for the Info_page GUI
 * @author Wang
 *
 */
public class Info_page_controller {

	private Game_controller Game_controller;
	
	public void setGameController(Game_controller Game_controller) {
		
		this.Game_controller = Game_controller;
		
	}
	
	/**
	 * This method change Info_page scene to Main_menu scene. This occur when the "BACK" button is clicked
	 */
	@FXML
	private void Exit_info() {
		
		Game_controller.Previous_scene();
		
	}
	
}
