package model;

import javafx.scene.image.Image;

public class Long_log extends Platform {
	
		public Long_log(int x, int y, double speed) {
		
		super(x, y, speed);
		Set_longlog_image();		
		
		}
		
		public void Set_longlog_image() {
			
			setImage(new Image("file:src/main/resources/image/logs.png", 300, 300, true, true));

		}
	
}
