package model;

import javafx.scene.image.Image;

public class Crocodile extends Platform {
	
	
	public Crocodile(int x, int y, double speed) {
		
		super(x, y, speed);
		Set_crocodile_image();
	}
	
	/**
	 * Set crocodile image
	 */
	private void Set_crocodile_image() {
		setImage(new Image("file:src/main/resources/image/crocodileRight.png", 200, 200, true, true));
	}
	
}
