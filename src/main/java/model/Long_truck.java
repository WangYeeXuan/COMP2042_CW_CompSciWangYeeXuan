package model;

import javafx.scene.image.Image;

public class Long_truck extends Obstacle {

	public Long_truck(int x, int y, double speed) {
		
		super(x, y, speed);
		Set_longtruck_image(speed);
		
	}
	
	/**
	 * Set truck image that depends on the speed
	 * @param speed
	 */
	private void Set_longtruck_image(double speed) {
		
		if(speed > 0) {
			
			setImage(new Image("file:src/main/resources/image/truck2Right.png", 200, 200, true, true));
			
		}
		else {
			
			setImage(new Image("file:src/main/resources/image/truck2Left.png", 200, 200, true, true));
		
		}
		
	}

}

