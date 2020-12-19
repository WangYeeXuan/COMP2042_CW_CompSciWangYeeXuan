package model;

import javafx.scene.image.Image;

/**
 * This class is responsible for setting the parameters of the model Fast_car and display of the model Fast_car.
 * @author Wang
 *
 */
public class Fast_car extends Obstacle {
	
	/**
	 * This method is to set the parameters.
	 * @param x indicate x-axis position in the window
	 * @param y indicate y-axis position in the window
	 * @param speed indicate the speed of the car
	 */
	public Fast_car(int x, int y, double speed) {
		
		super(x, y, speed);
		Set_fastcar_image(speed);
		
	}
	
	/**
	 * Set car image that depends on the speed.
	 * @param speed indicate the speed of the car
	 */
	private void Set_fastcar_image(double speed) {
		
		if(speed > 0) {
			
			setImage(new Image("file:src/main/resources/image/fastcarRight.png", 50, 50, true, true));
			
		}
		else {
			
			setImage(new Image("file:src/main/resources/image/fastcarLeft.png", 50, 50, true, true));
		
		}
		
	}

}
