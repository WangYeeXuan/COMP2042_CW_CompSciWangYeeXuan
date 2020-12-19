package model;

import javafx.scene.image.Image;

/**
 * This class is responsible for the animation of the model Turtle.
 * @author Wang
 *
 */
public class Turtle extends Platform {
	
	private Image TurtleAnimation1 = new Image("file:src/main/resources/image/TurtleAnimation1.png", 130, 130, true, true);
	private Image TurtleAnimation2 = new Image("file:src/main/resources/image/TurtleAnimation2.png", 130, 130, true, true);
	private Image TurtleAnimation3 = new Image("file:src/main/resources/image/TurtleAnimation3.png", 130, 130, true, true);
	private double speed;
	
	/**
	 * This method is to set the parameters.
	 * @param x indicate x-axis position in the window
	 * @param y indicate y-axis position in the window
	 * @param speed indicate the speed of the Turtle
	 */
	public Turtle(int x, int y, double speed) {
		
		super(x, y, speed);
		this.speed = speed;
		setImage(TurtleAnimation2);
		
	}
	
	/**
	 * This method is used to set the turtle animation.
	 * @param now now
	 */
	private void turtleAnimation(long now) {
			
		if (now/900000000  % 3 ==0) {
			
			setImage(TurtleAnimation2);
				
		}
		else if (now/900000000 % 3 == 1) {
			
			setImage(TurtleAnimation1);
				
		}
		else if (now/900000000 %3 == 2) {
			
			setImage(TurtleAnimation3);
				
		}
			
	}
	
	/**
	 * This method keeps the turtle within the application window.
	 * @param speed indicate the speed of the frog
	 */
	protected void KeepWithinWindow(double speed) {
		
		if (getX() > 600 && speed>0) {
			
			setX(-200);
			
		}
		
		if (getX() < -75 && speed<0) {
			
			setX(600);
			
		}

	}
	
	@Override
	public void act(long now) {

		turtleAnimation(now);	
		move(speed , 0);
		KeepWithinWindow(speed);
		
	}
	

	
}
