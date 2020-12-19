package model;

import javafx.scene.image.Image;

/**
 * This class is responsible for setting the parameters of the model Long_log and display of the model Long_log.
 * @author Wang
 *
 */
public class Long_log extends Platform {
		
	/**
	 * This method is to set the parameters.
	 * @param x indicate x-axis position in the window
	 * @param y indicate y-axis position in the window
	 * @param speed indicate the speed of the Long_log
	 */
	public Long_log(int x, int y, double speed) {
		
		super(x, y, speed);
		Set_longlog_image();		
		
	}
		
	/**
	 * Set Long_log image
	 */
	public void Set_longlog_image() {
			
		setImage(new Image("file:src/main/resources/image/logs.png", 300, 300, true, true));

	}
	
}
