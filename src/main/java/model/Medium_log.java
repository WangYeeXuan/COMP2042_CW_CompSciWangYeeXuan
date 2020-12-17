package model;

import javafx.scene.image.Image;

public class Medium_log extends Platform {
	
	//Constructor
	public Medium_log(int x, int y, double speed) {
		
		super(x, y, speed);
		setImage(new Image("file:src/main/resources/image/log2.png", 225, 225, true, true));
		
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
