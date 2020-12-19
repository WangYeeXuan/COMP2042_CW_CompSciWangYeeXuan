package model;

import javafx.scene.image.Image;

/**
 * This class is responsible for setting the parameters of the model Car and display of the model Car.
 * @author Wang
 *
 */
public class Car extends Obstacle {
	
	/**
	 * This method is to set the parameters.
	 * @param x indicate x-axis position in the window
	 * @param y indicate y-axis position in the window
	 * @param speed indicate the speed of the car
	 */
	public Car(int x, int y, double speed) {
		
		super(x, y, speed);
		Set_car_image(speed);
		
	}
	
	/**
	 * Set car image that depends on the speed.
	 * @param speed indicate speed of the car
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
