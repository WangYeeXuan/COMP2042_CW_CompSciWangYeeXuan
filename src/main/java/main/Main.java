package main;

import controller.Enter_name_page_controller;
import controller.Game_controller;
import controller.Highscore_page_controller;
import controller.Info_page_controller;
import controller.Scene_controller;
import controller.Main_menu_controller;
import model.Highscore;
import model.level.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		//Models
		Highscore highScores = new Highscore();
		Level[] levels = new Level[5];
		levels[0] = new Level_1();
		levels[1] = new Level_2();
		levels[2] = new Level_3();
		levels[3] = new Level_4();
		levels[4] = new Level_5();
		
		//Setup Scene Controllers
		Main_menu_controller startSceneController = new Main_menu_controller();
		Info_page_controller infoSceneController = new Info_page_controller();
		Enter_name_page_controller endSceneController = new Enter_name_page_controller(highScores);
		Highscore_page_controller hsSceneController= new Highscore_page_controller(highScores);

		//Setup Views
		FXMLLoader startSceneLoader = new FXMLLoader(getClass().getResource("/view/Main_menu.fxml"));
		startSceneLoader.setController(startSceneController);
		Pane startScene = startSceneLoader.load();
		
		FXMLLoader infoSceneLoader = new FXMLLoader(getClass().getResource("/view/Info_page.fxml"));
		infoSceneLoader.setController(infoSceneController);
		Pane infoScene = infoSceneLoader.load();
		
		FXMLLoader endSceneLoader = new FXMLLoader(getClass().getResource("/view/Enter_name_page.fxml"));
		endSceneLoader.setController(endSceneController);
		Pane endScene = endSceneLoader.load();
		
		FXMLLoader hsSceneLoader = new FXMLLoader(getClass().getResource("/view/Highscore_page.fxml"));
		hsSceneLoader.setController(hsSceneController);
		Pane hsScene = hsSceneLoader.load();
		
		//Setup SceneController
		Scene scene  = new Scene(startScene, 600, 800);
		
		Scene_controller sceneController = new Scene_controller(scene, 8);
		
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
		Game_controller gameController = new Game_controller(scene, sceneController, endSceneController, hsSceneController);
		
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
