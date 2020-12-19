package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import controller.*;
import model.level.*;
import model.Highscore;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//High score model
		Highscore highScores = new Highscore();
		
		//Level model
		Level[] Level = new Level[5];
		Level[0] = new Level_1();
		Level[1] = new Level_2();
		Level[2] = new Level_3();
		Level[3] = new Level_4();
		Level[4] = new Level_5();
		
		//To setup Scene_controller
		Main_menu_controller Main_menu_controller = new Main_menu_controller();
		Info_page_controller Info_page_controller = new Info_page_controller();
		Enter_name_page_controller Enter_name_page_controller = new Enter_name_page_controller(highScores);
		Leaderboard_page_controller Leaderboard_page_controller= new Leaderboard_page_controller(highScores);

		//Load Main_menu.fxml file
		FXMLLoader Main_menu_Loader = new FXMLLoader(getClass().getResource("/view/Main_menu.fxml"));
		Main_menu_Loader.setController(Main_menu_controller);
		AnchorPane Main_menu = Main_menu_Loader.load();
		
		//Load Info_page.fxml file
		FXMLLoader Info_page_Loader = new FXMLLoader(getClass().getResource("/view/Info_page.fxml"));
		Info_page_Loader.setController(Info_page_controller);
		AnchorPane Info_page = Info_page_Loader.load();
		
		//Load Enter_name_page.fxml file
		FXMLLoader Enter_name_page_Loader = new FXMLLoader(getClass().getResource("/view/Enter_name_page.fxml"));
		Enter_name_page_Loader.setController(Enter_name_page_controller);
		AnchorPane Enter_name_page = Enter_name_page_Loader.load();
		
		//Load Leaderboard_page.fxml file
		FXMLLoader Leaderboard_page_Loader = new FXMLLoader(getClass().getResource("/view/Leaderboard_page.fxml"));
		Leaderboard_page_Loader.setController(Leaderboard_page_controller);
		AnchorPane Leaderboard_page = Leaderboard_page_Loader.load();
		
		//To setup Scene_controller
		Scene scene  = new Scene(Main_menu, 600, 800);
		
		Scene_controller Scene_controller = new Scene_controller(scene, 8);
		
		Scene_controller.Add_scene(0, Main_menu);
		Scene_controller.Add_scene(1, Info_page);
		Scene_controller.Add_scene(2, Level[0]);
		Scene_controller.Add_scene(3, Level[1]);
		Scene_controller.Add_scene(4, Level[2]);
		Scene_controller.Add_scene(5, Level[3]);
		Scene_controller.Add_scene(6, Level[4]);
		Scene_controller.Add_scene(7, Enter_name_page);
		Scene_controller.Add_scene(8, Leaderboard_page);
		
		Scene_controller.Activate(0); //Main_menu is shown first
		
		//To setup GameController
		Game_controller Game_controller = new Game_controller(scene, Scene_controller, Enter_name_page_controller, Leaderboard_page_controller);
		
		//Linking Scene_controllers to Game_controller
		Main_menu_controller.setGameController(Game_controller);
		Info_page_controller.setGameController(Game_controller);
		Enter_name_page_controller.setGameController(Game_controller);
		Leaderboard_page_controller.setGameController(Game_controller);
		
		//Show the scene
	    primaryStage.setResizable(false); //Disable user to adjust the size of the window application
		primaryStage.setScene(scene);
	    primaryStage.show();	
	    
	    //Play music
	    //Game_controller.Play_music();
	    
	}
}
