package model;

import javafx.scene.image.Image;

public class Car extends Obstacle {

	public Car(int x, int y, double speed) {
		
		super(x, y, speed);
		Set_car_image(speed);
		
	}
	
	/**
	 * Set car image that depends on the speed
	 * @param speed
	 */
	private void Set_car_image(double speed) {
		
		if(speed > 0) {
			
			setImage(new Image("file:src/main/resources/image/car1Right.png", 50, 50, true, true));
			
		}
		else {
			
			setImage(new Image("file:src/main/resources/image/car1Left.png", 50, 50, true, true));
		
		}
		
	}

}
