package model;

public abstract class Obstacle extends Actor {
	
	protected double speed;
	
	/**
	 * This method is to set the parameters.
	 * @param x indicate x-axis position in the window
	 * @param y indicate y-axis position in the window
	 * @param speed indicate the speed of the Obstacles
	 */
	public Obstacle(int x, int y, double speed) {

		setX(x);
		setY(y);
		this.speed = speed;
		
	}
	
	/**
	 * This method keeps the obstacles within the application window.
	 * @param speed indicate the speed of the the frog
	 */
	private void KeepWithinWindow(double speed) {
		
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
		
	}
	
	@Override
	public void act(long now) {
		move(speed , 0);
		KeepWithinWindow(speed);
	}
	
	
}