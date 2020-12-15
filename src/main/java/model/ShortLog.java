package model;

import javafx.scene.image.Image;

public class ShortLog extends Rideable {
	
	//Constructor
	public ShortLog(int x, int y, double speed) {
		
		super(x, y, speed);
		setImage(new Image("file:src/main/resources/image/log3.png", 150, 150, true, true));
		
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
