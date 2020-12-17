package model;

import javafx.scene.image.Image;

public class Short_truck extends Obstacle {

	public Short_truck(int x, int y, double speed) {
		
		super(x, y, speed);
		setShortTruckImage(speed);
		
	}
	
	/**
	 * Set truck image that depends on the speed
	 * @param speed
	 */
	private void setShortTruckImage(double speed) {
		
		if(speed > 0) {
			
			setImage(new Image("file:src/main/resources/image/truck1Right.png", 120, 120, true, true));
			
		}
		else {
			
			setImage(new Image("file:src/main/resources/image/truck1Left.png", 120, 120, true, true));
		
		}
		
	}

}
