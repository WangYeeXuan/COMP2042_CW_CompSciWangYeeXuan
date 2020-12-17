package model;

import javafx.scene.image.Image;

public class Fast_car extends Obstacle {

	public Fast_car(int x, int y, double speed) {
		
		super(x, y, speed);
		setCarImage(speed);
		
	}
	
	private void setCarImage(double speed) {
		
		if(speed > 0) {
			
			setImage(new Image("file:src/main/resources/image/fastcarRight.png", 50, 50, true, true));
			
		}
		else {
			
			setImage(new Image("file:src/main/resources/image/fastcarLeft.png", 50, 50, true, true));
		
		}
		
	}

}
