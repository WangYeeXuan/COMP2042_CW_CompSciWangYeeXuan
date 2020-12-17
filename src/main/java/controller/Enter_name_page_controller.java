package controller;

import java.io.IOException;



import model.Highscore;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.Label;

public class Enter_name_page_controller {
	
	private Game_controller gameController;
	private Highscore highScores;
	//private String fontUrl = "file:src/main/resources/fonts/joystix monospace.ttf";
	private int score;
	
	@FXML
	private Label endScore;
	
	@FXML 
	private Text yourScore, nameText;
	
	@FXML 
	private TextField username;
	
	public Enter_name_page_controller(Highscore highScores) {
		
		this.highScores = highScores;
		
	}
	
	public void setGameController(Game_controller gameController) {
		
		this.gameController = gameController;
		
	}
	
	protected void setEndScore(int score) {
		
		this.score = score;
		endScore.setText(Integer.toString(score));
		
	}
	
	@FXML
	private void keyTyped() {
		
		if(username.getText().length() > 10) {
			
			username.setText(username.getText().substring(0, 10));
			username.positionCaret(10);
			
		}
		
	}
	
	@FXML
	private void enter() throws IOException {
		
		highScores.newScore(username.getText(), score);
		gameController.setHSList();
		gameController.nextScene();
		
			
	}
	
}