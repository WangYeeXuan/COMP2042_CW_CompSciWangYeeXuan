package main;

import java.io.File;
import java.util.List;

import controller.EndSceneController;
import controller.GameController;
import controller.HSSceneController;
import controller.InfoSceneController;
import controller.SceneController;
import controller.StartSceneController;
import model.HighScores;
import model.Level;
import model.Level1;
import model.Level2;
import model.Level3;
import model.Level4;
import model.Level5;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		//Models
		HighScores highScores = new HighScores();
		Level[] levels = new Level[5];
		levels[0] = new Level1();
		levels[1] = new Level2();
		levels[2] = new Level3();
		levels[3] = new Level4();
		levels[4] = new Level5();
		
		//Setup Scene Controllers
		StartSceneController startSceneController = new StartSceneController();
		InfoSceneController infoSceneController = new InfoSceneController();
		EndSceneController endSceneController = new EndSceneController(highScores);
		HSSceneController hsSceneController= new HSSceneController(highScores);

		//Setup Views
		FXMLLoader startSceneLoader = new FXMLLoader(getClass().getResource("/view/mainMenu.fxml"));
		startSceneLoader.setController(startSceneController);
		Pane startScene = startSceneLoader.load();
		
		FXMLLoader infoSceneLoader = new FXMLLoader(getClass().getResource("/view/infoPage.fxml"));
		infoSceneLoader.setController(infoSceneController);
		Pane infoScene = infoSceneLoader.load();
		
		FXMLLoader endSceneLoader = new FXMLLoader(getClass().getResource("/view/enterNamePage.fxml"));
		endSceneLoader.setController(endSceneController);
		Pane endScene = endSceneLoader.load();
		
		FXMLLoader hsSceneLoader = new FXMLLoader(getClass().getResource("/view/highScorePage.fxml"));
		hsSceneLoader.setController(hsSceneController);
		Pane hsScene = hsSceneLoader.load();
		
		//Setup SceneController
		Scene scene  = new Scene(startScene, 600, 800);
		
		SceneController sceneController = new SceneController(scene, 8);
		
		sceneController.addScene(0, startScene);
		sceneController.addScene(1, infoScene);
		sceneController.addScene(2, levels[0]);
		sceneController.addScene(3, levels[1]);
		sceneController.addScene(4, levels[2]);
		sceneController.addScene(5, levels[3]);
		sceneController.addScene(6, levels[4]);
		sceneController.addScene(7, endScene);
		sceneController.addScene(8, hsScene);
		sceneController.activate(0);
		
		//Setup GameController
		GameController gameController = new GameController(scene, sceneController, endSceneController, hsSceneController);
		
		//Link SceneControllers to GameController
		startSceneController.setGameController(gameController);
		infoSceneController.setGameController(gameController);
		endSceneController.setGameController(gameController);
		hsSceneController.setGameController(gameController);
		
		primaryStage.setScene(scene);
	    primaryStage.setResizable(false);
	    primaryStage.show();
	    
	    gameController.playMusic();
		
		
	}
	
	
}
