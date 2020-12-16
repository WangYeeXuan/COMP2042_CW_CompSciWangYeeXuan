package model;

import javafx.scene.image.Image;

public class Crocodile extends Rideable {
	
	//Constructor
	public Crocodile(int x, int y, double speed) {
		
		super(x, y, speed);
		setImage(new Image("file:src/main/resources/image/crocodileRight.png", 200, 200, true, true));
		
	}
	
	@Override
	protected void KeepWithinWindow(double speed) {
		
		if (getX()>600 && speed>0) {
			
			setX(-180);
			
		}
	
		if (getX()<-300 && speed<0) {
			
			setX(700);
			
		}
				
	}
	
}
