package model;

import javafx.scene.image.Image;

public class Car extends Obstacle {

	public Car(int x, int y, double speed) {
		
		super(x, y, speed);
		setCarImage(speed);
		
	}
	
	private void setCarImage(double speed) {
		
		if(speed > 0) {
			
			setImage(new Image("file:src/main/resources/image/car1Right.png", 50, 50, true, true));
			
		}
		else {
			
			setImage(new Image("file:src/main/resources/image/car1Left.png", 50, 50, true, true));
		
		}
		
	}

}
