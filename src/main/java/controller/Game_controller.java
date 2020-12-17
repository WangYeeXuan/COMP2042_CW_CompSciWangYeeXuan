package controller;

import java.io.IOException;


import java.lang.reflect.InvocationTargetException;

import model.Music_player;
import model.level.*;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;


public class Game_controller {

	private AnimationTimer timer;
	private int currentScene;
	private int totalScore = 0;
	private int savedScore = 0;
	private Music_player musicPlayer = new Music_player();
	private Scene_controller sceneController;
	private Enter_name_page_controller endSceneController;
	private Highscore_page_controller hsSceneController;
	private Scene scene;
	
	public Game_controller(Scene scene, Scene_controller sceneController, Enter_name_page_controller endSceneController, Highscore_page_controller hsSceneController) throws IOException {
		
		this.scene = scene;
		this.sceneController = sceneController;
		this.endSceneController = endSceneController;
		this.hsSceneController = hsSceneController;
		currentScene = 0;
		
	}
	
	public void playMusic() {
    	
    	musicPlayer.play();
    	
    }
	
	private void nextLevel() {
		
		nextScene();
		
		if (scene.getRoot() instanceof Level) {
			
			((Level)scene.getRoot()).getScoreboard().setScore(savedScore);
			
		}
		else {
			
			stop();
			
		}
		
	}
	
	protected void nextScene() {
		
		sceneController.changeScene(++currentScene);
		
	}
	
	protected void previousScene() {
		
		sceneController.changeScene(--currentScene);
		
	}
	
	protected void setHSList() {
		
		hsSceneController.setScoreText();
		
	}
	
	private void createTimer() {
		
		timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	
            	if (scene.getRoot() instanceof Level) {
            		
            		if(((Level)scene.getRoot()).getAnimal().changeScore()) {
            			
            			totalScore = savedScore + ((Level)scene.getRoot()).getAnimal().getPoints();
            			((Level)scene.getRoot()).getScoreboard().setScore(totalScore);
            			
            		}
            		
            		if(((Level)scene.getRoot()).getAnimal().getStop()) {
            			
            			savedScore = totalScore;
            			nextLevel();
            			
            		}
            		
            	}
            	else {
            		
            		stop();
            		
            	}
            	
            }
        };
		
    }
	
	protected void start() {
	
		currentScene = 2;
		sceneController.activate(currentScene);
    	createTimer();
        timer.start();
        
    }

    private void stop() {
    	
    	endSceneController.setEndScore(savedScore);
        timer.stop();
        
    }
    
    protected void restart() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    	
    	savedScore = 0;
    	totalScore = 0;
    	sceneController.resetScenes();
    	start();
    	
    }
    
}
