package model;

/**
 * This class is responsible for the models that the frog can ride on.
 * @author Wang
 *
 */
public class Platform extends Actor {

	protected double speed;
	
	/**
	 * This method is to set the parameters.
	 * @param x indicate x-axis position in the window
	 * @param y indicate y-axis position in the window
	 * @param speed indicate the speed of the Platform
	 */
	public Platform(int x, int y, double speed) {
		
		setX(x);
		setY(y);
		this.speed = speed;
		
	}
	
	/**
	 * This method keeps the platforms within the application window.
	 * @param speed indicate the speed of the frog
	 */
	protected void KeepWithinWindow(double speed) {
		
		if (getX()>600 && speed>0) {
			
			setX(-180);
			
		}
	
		if (getX()<-300 && speed<0) {
			
			setX(700);
			
		}
				
	}
		
	@Override
	public void act(long now) {
		
		move(speed , 0);
		KeepWithinWindow(speed);
		
	}
		
	protected double getSpeed() {
			
		return speed;
			
	}
	
}
