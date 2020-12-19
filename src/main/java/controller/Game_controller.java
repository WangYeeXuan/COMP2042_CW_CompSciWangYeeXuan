package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import model.Music_player;
import model.level.*;

/**
 * This class is responsible to control the game scenes.
 * @author Wang
 *
 */
public class Game_controller {

	private AnimationTimer timer;
	private int current_Scene;
	private int total_Score = 0;
	private int saved_Score = 0;
	private Music_player music_Player = new Music_player();
	private Scene_controller Scene_controller;
	private Enter_name_page_controller Enter_name_page_controller;
	private Leaderboard_page_controller Leaderboard_page_controller;
	private Scene scene;
	
	public Game_controller(Scene scene, Scene_controller Scene_controller, Enter_name_page_controller Enter_name_page_controller, Leaderboard_page_controller Leaderboard_page_controller) throws IOException {
		
		this.scene = scene;
		this.Scene_controller = Scene_controller;
		this.Enter_name_page_controller = Enter_name_page_controller;
		this.Leaderboard_page_controller = Leaderboard_page_controller;
		current_Scene = 0;
		
	}
	
	/**
	 * This method plays the game music.
	 */
	public void Play_music() {
    	
		music_Player.play();
    	
    }
	
	/**
	 * This method is is used to create Animation Timer.
	 * In the timer's handle method, it is to update the score and check if the level is completed.
	 * If the level is completed, the next level will be displayed.
	 */
	private void Create_timer() {
		
		timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	
            	if (scene.getRoot() instanceof Level) {
            		
            		if(((Level)scene.getRoot()).getAnimal().changeScore()) {
            			
            			total_Score = saved_Score + ((Level)scene.getRoot()).getAnimal().getPoints();
            			((Level)scene.getRoot()).getScoreboard().setScore(total_Score);
            			
            		}
            		
            		if(((Level)scene.getRoot()).getAnimal().getStop()) {
            			
            			saved_Score = total_Score;
            			Next_level();
            			
            		}
            		
            	}
            	else {
            		
            		stop();
            		
            	}
            	
            }
        };
		
    }
	
	/**
	 * This method starts the game and Level_1 is displayed, animation timer created and started.
	 */
	protected void Start_game() {
	
		current_Scene = 2;
		Scene_controller.Activate(current_Scene);
		Create_timer();
        timer.start();
        
    }
	
	/**
	 * This method stops the game and the final score is saved, animation timer is also stoped.
	 */
    private void Stop_game() {
    	
    	Enter_name_page_controller.Set_final_score(saved_Score);
        timer.stop();
        
    }
	
	/**
	 * This method is used to change from one scene to the subsequent scene.
	 */
	protected void Next_scene() {
		
		Scene_controller.Change_scene(++current_Scene);
		
	}
	
	/**
	 * This method is used to change from the current scene to the previous scene.
	 */
	protected void Previous_scene() {
		
		Scene_controller.Change_scene(--current_Scene);
		
	}
	
	/**
	 * This method is used changes from one level scene to the next level scene.
	 */
	private void Next_level() {
		
		Next_scene();
		
		if (scene.getRoot() instanceof Level) {
			
			((Level)scene.getRoot()).getScoreboard().setScore(saved_Score);
			
		}
		else {
			
			Stop_game();
			
		}
		
	}
	
	/**
	 * This method sets the highscore list.
	 */
	protected void Set_highscore_list() {
		
		Leaderboard_page_controller.Set_score_text();
		
	}
    
    /**
     * This method is used to reset the scores and the scenes and Level_1 is displayed.
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws SecurityException
     */
    protected void Reset() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    	
    	saved_Score = 0;
    	total_Score = 0;
    	Scene_controller.Reset_scene();
    	Start_game();
    	
    }
    
}
