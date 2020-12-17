package model;

import javafx.scene.image.Image;

public class Medium_log extends Platform {
	
		public Medium_log(int x, int y, double speed) {
		
		super(x, y, speed);
		Set_mediumlog_image();
		}
		
		/**
		 * Set log image
		 */
		public void Set_mediumlog_image() {
			
			setImage(new Image("file:src/main/resources/image/log2.png", 225, 225, true, true));

		}
	
	
}
