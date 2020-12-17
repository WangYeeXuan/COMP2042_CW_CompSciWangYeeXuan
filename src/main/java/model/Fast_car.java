package model;

import javafx.scene.image.Image;

public class Fast_car extends Obstacle {

	public Fast_car(int x, int y, double speed) {
		
		super(x, y, speed);
		Set_fastcar_image(speed);
		
	}
	
	/**
	 * Set car image that depends on the speed
	 * @param speed
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
