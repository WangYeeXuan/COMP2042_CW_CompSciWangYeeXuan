package controller;

import java.lang.reflect.InvocationTargetException;

import java.util.HashMap;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import model.level.*;

/**
 * This class is responsible for controlling the scenes.
 * @author Wang
 */
public class Scene_controller {
	
	//Create a HashMap object called scene_Map
	private HashMap<Integer, Pane> scene_Map;
    private Scene scene;
    
    /**
     * This method links the Scene_controller to the HashMap.
     * @param scene indicate scene
     * @param Scene_num indicate scene number
     */
    public Scene_controller(Scene scene, int Scene_num) {
    	scene_Map = new HashMap<>(Scene_num);
        this.scene = scene;
    }
    
    /**
     * This method is used to add a scene to the HashMap.
     * @param Scene_num indicate scene number
     * @param pane indicate pane
     */
    public void Add_scene(Integer Scene_num, Pane pane){
    	scene_Map.put(Scene_num, pane);
    }
    
    /**
     * This method is used to remove a scene from the HashMap.
     * @param Scene_num indicate scene number
     */
    public void Remove_scene(Integer Scene_num){
    	scene_Map.remove(Scene_num);
    }
    
    /**
     * This method is to start the World timer.
     */
    protected void Start() {
    	
    	((Level)scene.getRoot()).start();
  
    }
    
    /**
     * This method is to stop the World timer.
     */
    protected void Stop() {
    	
    	((Level)scene.getRoot()).stop();
    	
    }
    
    /**
     * This method is to activate/display specific scenes from the HashMap.
     * @param Scene_num indicate scene number
     */
    public void Activate(Integer Scene_num){
    	
        scene.setRoot(scene_Map.get(Scene_num));
        
        if (scene.getRoot() instanceof Level) {
        	
        	Start();
        }
    }
	
    /**
     * This method is to change from one scene to another scene.
     * @param Scene_num indicate scene number
     */
    protected void Change_scene(Integer Scene_num) {
    	
    	if (scene.getRoot() instanceof Level) {
        	
    		Stop();
            
        }
    	
    	Activate(Scene_num);

    }
    
    /**
     * This method resets the scenes in the HashMap.
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws SecurityException
     */
    protected void Reset_scene() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    	
    	for (int i = 0; i < scene_Map.size(); i++) {
    		
    		if (scene_Map.get(i) instanceof Level) {
    			
    			Class<? extends Pane> cls = scene_Map.get(i).getClass();
    			scene_Map.replace(i, cls.getDeclaredConstructor().newInstance());
    			
    		}
    		
    	}
    	
    }
	
}
