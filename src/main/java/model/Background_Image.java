package model;

import javafx.scene.image.Image;

/**
 * This class is reponsible for setting the background image.
 * @author Wang
 *
 */
public class Background_Image extends Actor{
	
	/**
	 * Set background image
	 */
	public Background_Image() {
		
		setImage(new Image("file:src/main/resources/image/iKogsKW.png", 600, 900, true, true));
	}
	

	@Override
	public void act(long now) {
		
		
	}
	
}
