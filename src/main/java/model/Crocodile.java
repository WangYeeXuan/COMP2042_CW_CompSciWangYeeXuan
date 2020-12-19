package model;

import javafx.scene.image.Image;

/**
 * This class is responsible for setting the parameters of the model Crocodile and display of the model Crocodile.
 * @author Wang
 *
 */
public class Crocodile extends Platform {
	
	/**
	 * This method is to set the parameters.
	 * @param x indicate x-axis position in the window
	 * @param y indicate y-axis position in the window
	 * @param speed indicate the speed of the crocodile
	 */
	public Crocodile(int x, int y, double speed) {
		
		super(x, y, speed);
		Set_crocodile_image();
		
	}
	
	/**
	 * Set crocodile image.
	 */
	private void Set_crocodile_image() {
		
		setImage(new Image("file:src/main/resources/image/crocodileRight.png", 200, 200, true, true));
		
	}
	
}
