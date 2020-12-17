package model;

public abstract class Platform extends Actor {

	protected double speed;
	
	public Platform(int x, int y, double speed) {
		
		setX(x);
		setY(y);
		this.speed = speed;
		
	}
	
	protected abstract void KeepWithinWindow(double speed);
		
	@Override
	public void act(long now) {
		
		move(speed , 0);
		KeepWithinWindow(speed);
		
	}
		
	protected double getSpeed() {
			
		return speed;
			
	}
	
}
