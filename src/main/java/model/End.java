package model;

import javafx.scene.image.Image;

public class End extends Actor{
	boolean activated = false;
	
	
	public End(int x, int y) {
		setImage(new Image("file:src/main/resources/image/End.png", 60, 60, true, true));
		setX(x);
		setY(y);
	}
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * This method sets the End image and set activated to true
	 */
	protected void setEnd() {
		setImage(new Image("file:src/main/resources/image/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}
	
	/**
	 * This method return if frog has reached and End is activated
	 * @return
	 */
	protected boolean isActivated() {
		return activated;
	}

}
