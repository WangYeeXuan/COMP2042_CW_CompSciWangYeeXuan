package controller;

import java.lang.reflect.InvocationTargetException;


import java.net.URL;
import java.util.ResourceBundle;

import model.Highscore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Highscore_page_controller implements Initializable{
	
	private Highscore highScores;
	private Game_controller gameController;
	
	@FXML 
	private Text highScore;
	
	@FXML
	private Text hs1, hs2, hs3, hs4, hs5, hs6, hs7, hs8, hs9, hs10;
	
	@FXML
	private Text score1, score2, score3, score4, score5, score6, score7, score8, score9, score10;
	
	@FXML
	private Text name1, name2, name3, name4, name5, name6, name7, name8, name9, name10;
	
	@SuppressWarnings("unused")
	private Text[] hsText;
	private Text[] scoreText;
	private Text[] nameText;
	
	public Highscore_page_controller(Highscore highScores) {
		
		this.highScores = highScores;
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		hsText = new Text[] {hs1, hs2, hs3, hs4, hs5, hs6, hs7, hs8, hs9, hs10};
		
		scoreText = new Text[] {score1, score2, score3, score4, score5, score6, score7, score8, score9, score10};
		
		nameText = new Text[] {name1, name2, name3, name4, name5, name6, name7, name8, name9, name10};
		
	}
	
	public void setGameController(Game_controller gameController) {
		
		this.gameController = gameController;
		
	}

	protected void setScoreText() {
		
		String[] hsStringList = highScores.getScoreList();
		String[] parts;
		
		for(int i = 0; i < hsStringList.length;i++ ) {
			
			parts = hsStringList[i].split("\t");
			
			nameText[i].setText(parts[0]);
			scoreText[i].setText(parts[1]);
			
		}
		
	}
	
	@FXML
	private void retry() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		gameController.restart();
		
	}
	@FXML
	public Button closeButton;
	
	@FXML
	private void closeWindow(ActionEvent event) {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}
}
