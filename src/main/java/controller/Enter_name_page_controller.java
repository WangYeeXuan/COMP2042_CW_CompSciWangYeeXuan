package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.Label;

import model.Highscore;

/**
 * This class is responsible for the Enter_name_page GUI
 * @author Wang
 *
 */
public class Enter_name_page_controller {
	
	private Game_controller Game_controller;
	private Highscore Highscore;
	private int score;
	
	@FXML
	private Label Final_score;
	
	@FXML 
	private Text Your_score, Name_text;
	
	@FXML 
	private TextField Username;
	
	public Enter_name_page_controller(Highscore highScores) {
		
		this.Highscore = highScores;
		
	}
	
	public void setGameController(Game_controller Game_controller) {
		
		this.Game_controller = Game_controller;
		
	}
	
	/**
	 * This method register user's keyboard input and display it
	 */
	@FXML
	private void Key_typed() {
		
		if(Username.getText().length() > 15) {
			
			Username.setText(Username.getText().substring(0, 15));
			Username.positionCaret(10);
			
		}
		
	}
	
	/**
	 * This method is to set the final score achieved by the user
	 * @param score
	 */
	protected void Set_final_score(int score) {
		
		this.score = score;
		Final_score.setText(Integer.toString(score));
		
	}
	
	/**
	 * This method change Enter_name_page scene to Leaderbard scene
	 * @throws IOException
	 */
	@FXML
	private void Next() throws IOException {
		
		Highscore.New_score(Username.getText(), score);
		Game_controller.Set_highscore_list();
		Game_controller.Next_scene();
		
	}
	
}