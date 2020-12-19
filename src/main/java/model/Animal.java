package model;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

public class Animal extends Actor {
	private Image imgW1;
	private Image imgA1;
	private Image imgS1;
	private Image imgD1;
	private Image imgW2;
	private Image imgA2;
	private Image imgS2;
	private Image imgD2;
	
	private int points = 0;
	private int end = 0;
	
	private boolean second = false;
	private boolean noMove = false;
	
	private double movement = 13.3333333*2;
	private double movementX = 10.666666*2;
	private int imgSize = 40;
	
	private boolean carDeath = false;
	private boolean waterDeath = false;
	
	private boolean changeScore = false;
	private int carD = 0;
	private int waterD = 0;
	private double w = 800;
	
	public Animal() {
		
		Reset_frog_position();
		
		imgW1 = new Image("file:src/main/resources/image/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/main/resources/image/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/main/resources/image/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/main/resources/image/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/main/resources/image/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/main/resources/image/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/main/resources/image/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/main/resources/image/froggerRightJump.png", imgSize, imgSize, true, true);
		
		setImage(imgW1);
		
		createKeyListener();
		
	}
	
	 private void createKeyListener() {
			
		setOnKeyPressed(new EventHandler<KeyEvent>() {
				
			public void handle(KeyEvent event){
					
				User_controls(event);
					
			}
				
		});
			
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
					
				User_controls(event);
					
			}
				
		});
			
	}
	
	/**
	 * This method take in user's WASD input and also UP DOWN LEFT RIGHT.
	 * The frog is moved accordingly.
	 * The frog animation is displaye accordingly.
	 * The score is updated accordingly.
	 * @param event indicate event
	 */
	private void User_controls(KeyEvent event) {
		
		if (noMove) {
		}
		else {
			switch (event.getCode()) {
				
				case UP:
				case W: move(0, -movement);
						Frog_animation(second, 'W');
	                	if (second) {
	                		changeScore = false;
	                	}
	                	else {
	                		if (getY() < w) {
	                			changeScore = true;
	                			w = getY();
	                			points+=10;
	                		}
	                	}
	                	break;
	            
				case LEFT:    	
				case A:	move(-movementX, 0);
						Frog_animation(second, 'A');
						break;
	            
				case DOWN:		
				case S:	move(0, movement);
						Frog_animation(second, 'S');
						break;
	            
				case RIGHT:		
				case D:	move(movementX, 0);
						Frog_animation(second, 'D');
						break;
						
				default:break;
			}
			
		}
		
	}
	
	/**
	 * This method takes in user's WASD input and assign each input with different frog animation.
	 * @param second indicate second
	 * @param key indicate which key is pressed
	 */
	private void Frog_animation(boolean second, char key){
		
		if (second) {
			
			switch(key) {
				
				case 'W':	setImage(imgW1);
							break;
				case 'A':	setImage(imgA1);
							break;
				case 'S':	setImage(imgS1);
							break;
				case 'D':	setImage(imgD1);
							break;
			}	
			
			this.second = false;
			
		}
		else {
			
			switch(key) {
			
				case 'W':	setImage(imgW2);
							break;
				case 'A':	setImage(imgA2);
							break;
				case 'S':	setImage(imgS2);
							break;
				case 'D':	setImage(imgD2);
							break;
			}	
			
			this.second = true;
				
		}
		
	}
	
	@Override
	public void act(long now) {

		Keep_frog_inbound();
		Object_intersection();
		Death_image(now);
		
	}
	
	/**
	 * This method keeps the frog within the size of the application window.
	 */
	private void Keep_frog_inbound() {
		
		if (getY()<0 || getY()>750) {
			Reset_frog_position();
		}
		if (getX()<0) {
			move(movement*2, 0);
		}
		if (getX()>600) {
			move(-movement*2, 0);
		}
		
	}
	
	/**
	 * This method checks if the frog has intersect with obstacle, wet turtle, platform and end.
	 */
	private void Object_intersection() {
		
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getIntersectingObjects(Wet_turtle.class).size() >= 1) {
			
			if (getIntersectingObjects(Wet_turtle.class).get(0).isSunk()) {
				
				waterDeath = true;
				
			} 
			else {
				
				move(getIntersectingObjects(Wet_turtle.class).get(0).getSpeed(), 0);
				
			}
		}
		else if (getIntersectingObjects(Platform.class).size() >= 1 && !noMove ) {
			
			move(getIntersectingObjects(Platform.class).get(0).getSpeed(), 0);
			
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=50;
			}
			
			getIntersectingObjects(End.class).get(0).setEnd();
			Respawn(true);
		}
		else if (getY()<413){
			
			waterDeath = true;
			
		}
		
	}
	
	/**
	 * This method assign death images according to the type of death.
	 * @param now now
	 */
	private void Death_image(long now) {
		
		if (carDeath) {
			noMove = true;
			if ((now)% 11 == 0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/main/resources/image/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/main/resources/image/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/main/resources/image/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				
				Respawn(false);
				
			}
			
		}
		if (waterDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				waterD++;
			}
			if (waterD==1) {
				setImage(new Image("file:src/main/resources/image/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (waterD==2) {
				setImage(new Image("file:src/main/resources/image/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (waterD==3) {
				setImage(new Image("file:src/main/resources/image/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (waterD == 4) {
				setImage(new Image("file:src/main/resources/image/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (waterD == 5) {
				
				Respawn(false);
				
			}
		}
		
	}
	
	/**
	 * This method resets to frog position to the starting point.
	 */
	private void Reset_frog_position() {
		setX(300);
		setY(750);
	}
	
	/**
	 * This method check if the frog has reached the End.
	 * Scores are updated accordingly.
	 * @param goalReached indicate that the frog has reach the End
	 */
	private void Respawn(boolean End_reached) {
		
		Reset_frog_position();
		
		if (End_reached) {
			
			points+=50;
			changeScore = true;
			w=800;
			end++;
			
		}
		else {
			
			waterDeath = false;
			carDeath = false;
			carD = 0;
			waterD = 0;
			setImage(new Image("file:src/main/resources/image/froggerUp.png", imgSize, imgSize, true, true));
			noMove = false;
			if (points>50) {
				points-=50;
				changeScore = true;
			}
			
		}
	}
	
	public boolean getStop() {
		return end==5;
	}
	
	public int getPoints() {
		return points;
	}
	
	public boolean changeScore() {
		
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	

}
