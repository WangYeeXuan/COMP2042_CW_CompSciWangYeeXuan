package model;

import javafx.scene.image.Image;

/**
 * This class is responsible for setting the parameters of the model Short_log and display of the model Short_log.
 * @author Wang
 *
 */
public class Short_log extends Platform {
		
	/**
	 * This method is to set the parameters.
	 * @param x indicate x-axis position in the window
	 * @param y indicate y-axis position in the window
	 * @param speed indicate the speed of the Short_log
	 */
	public Short_log(int x, int y, double speed) {
		
		super(x, y, speed);
		Set_shortlog_image();
		
	}
	
	/**
	 * Set Short_log image
	 */
	public void Set_shortlog_image() {
			
		setImage(new Image("file:src/main/resources/image/log3.png", 150, 150, true, true));

	}
	
	
}
