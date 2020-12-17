package model;

import javafx.scene.image.Image;

public class Short_log extends Platform {
	
		public Short_log(int x, int y, double speed) {
		
		super(x, y, speed);
		Set_shortlog_image();
		
		}
		
		public void Set_shortlog_image() {
			
			setImage(new Image("file:src/main/resources/image/log3.png", 150, 150, true, true));

		}
	
	
}
