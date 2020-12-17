package model;

import javafx.scene.image.Image;

public class Wet_turtle extends Platform {
	Image turtleframe1 = new Image("file:src/main/resources/image/TurtleAnimation1.png", 130, 130, true, true);
	Image turtleframe2 = new Image("file:src/main/resources/image/TurtleAnimation2Wet.png", 130, 130, true, true);
	Image turtleframe3 = new Image("file:src/main/resources/image/TurtleAnimation3Wet.png", 130, 130, true, true);
	Image turtleframe4 = new Image("file:src/main/resources/image/TurtleAnimation4Wet.png", 130, 130, true, true);
	private double speed;
	boolean sunk = false;
	
	public Wet_turtle(int x, int y, int speed) {
		
		super(x, y, speed);
		this.speed = speed;
		setImage(turtleframe2);
		
	}
	
	private void TurtleState(long now) {
				
		if (now/900000000  % 4 ==0) {
			setImage(turtleframe2);
			sunk = false;
				
		}
		else if (now/900000000 % 4 == 1) {
			setImage(turtleframe1);
			sunk = false;
		}
		else if (now/900000000 %4 == 2) {
			setImage(turtleframe3);
			sunk = false;
		} else if (now/900000000 %4 == 3) {
			setImage(turtleframe4);
			sunk = true;
		}
				
	}
	
	/**
	 * This method keeps the turtle within the application window
	 * @param speed
	 */
	protected void KeepWithinWindow(double speed) {
		
		if (getX() > 600 && speed>0) {
			
			setX(-200);
			
		}
		
		if (getX() < -75 && speed<0) {
			
			setX(600);
			
		}

	}
	
	/**
	 * This method return if the frog is sunk
	 * @return
	 */
	protected boolean isSunk() {
		return sunk;
	}
	
	@Override
	public void act(long now) {

		TurtleState(now);
		move(speed , 0);
		KeepWithinWindow(speed);
		
	}
	
}
