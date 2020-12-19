package model;

import javafx.scene.image.Image;

/**
 * This class is responsible for setting the parameters of the model Short_truck and display of the model Short_truck.
 * @author Wang
 *
 */
public class Short_truck extends Obstacle {
	
	/**
	 * This method is to set the parameters.
	 * @param x indicate x-axis position in the window
	 * @param y indicate y-axis position in the window
	 * @param speed indicate the speed of the Short_truck
	 */
	public Short_truck(int x, int y, double speed) {
		
		super(x, y, speed);
		setShortTruckImage(speed);
		
	}
	
	/**
	 * Set truck image that depends on the speed.
	 * @param speed indicate the speed of the truck
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
