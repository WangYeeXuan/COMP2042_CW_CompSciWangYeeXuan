package model;

import javafx.scene.image.Image;

/**
 * This class is responsible for setting the parameters of the model Long_truck and display of the model Long_truck.
 * @author Wang
 *
 */
public class Long_truck extends Obstacle {
	
	/**
	 * This method is to set the parameters.
	 * @param x indicate x-axis position in the window
	 * @param y indicate y-axis position in the window
	 * @param speed indicate the speed of the Long_truck
	 */
	public Long_truck(int x, int y, double speed) {
		
		super(x, y, speed);
		Set_longtruck_image(speed);
		
	}
	
	/**
	 * Set truck image that depends on the speed.
	 * @param speed indicate the speed of the truck
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

