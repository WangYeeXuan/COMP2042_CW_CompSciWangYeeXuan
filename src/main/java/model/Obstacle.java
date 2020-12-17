package model;

public abstract class Obstacle extends Actor {
	
	protected double speed;
	
	public Obstacle(int x, int y, double speed) {

		setX(x);
		setY(y);
		this.speed = speed;
		
	}
	
	/**
	 * This method keeps the obstacles within the application window
	 * @param speed
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