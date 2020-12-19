package model;

import javafx.scene.image.Image;

/**
 * This class is responsible for setting the parameters of the model Medium_log and display of the model Medium_log.
 * @author Wang
 *
 */
public class Medium_log extends Platform {
		
	/**
	 * This method is to set the parameters.
	 * @param x indicate x-axis position in the window
	 * @param y indicate y-axis position in the window
	 * @param speed indicate the speed of the Medium_log
	 */
	public Medium_log(int x, int y, double speed) {
		
		super(x, y, speed);
		Set_mediumlog_image();
	}
		
	/**
	 * Set log image.
	*/
	public void Set_mediumlog_image() {
			
		setImage(new Image("file:src/main/resources/image/log2.png", 225, 225, true, true));

	}
	
	
}
