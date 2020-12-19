package controller;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import model.Highscore;

/**
 * This class is responsible for the display of the leaderboard and Leaderboard.fxml GUI.
 * @author Wang
 *
 */
public class Leaderboard_page_controller implements Initializable{
	
	private Highscore highScores;
	private Game_controller Game_controller;
	
	//connect to the highscore in fxml
	@FXML 
	private Text highScore;
	
	//connect to the scores text in fxml
	@FXML
	private Text score_1, score_2, score_3, score_4, score_5, score_6, score_7, score_8, score_9, score_10;
	
	//connect to the name text in fxml
	@FXML
	private Text name_1, name_2, name_3, name_4, name_5, name_6, name_7, name_8, name_9, name_10;
	
	private Text[] Score_text;
	private Text[] Name_text;
	
	public Leaderboard_page_controller(Highscore highScores) {
		
		this.highScores = highScores;
		
	}
	
	public void setGameController(Game_controller Game_controller) {
		
		this.Game_controller = Game_controller;
		
	}
	
	/**
	 * This method initialize all the Score_text and Name_text.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Score_text = new Text[] {score_1, score_2, score_3, score_4, score_5, score_6, score_7, score_8, score_9, score_10};
		
		Name_text = new Text[] {name_1, name_2, name_3, name_4, name_5, name_6, name_7, name_8, name_9, name_10};
		
	}
	
	/**
	 * This method is to display the name and the score text.
	 */
	protected void Set_score_text() {
		
		String[] HS_StringList = highScores.Get_score_list();
		String[] parts;
		
		for(int i = 0; i < HS_StringList.length;i++ ) {
			
			parts = HS_StringList[i].split("\t");
			
			Name_text[i].setText(parts[0]);
			Score_text[i].setText(parts[1]);
			
		}
		
	}
	
	/**
	 * This method change Leaderboard scene to Level_1 scene when the "RETRY" button is clicked.
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	@FXML
	private void Retry() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Game_controller.Reset();
	
	}
	
	//connecct to close button in fxml
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
