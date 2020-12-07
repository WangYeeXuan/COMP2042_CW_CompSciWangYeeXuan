package model;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.util.List;

public class Animal extends Actor {
	Image imgW1;
	Image imgA1;
	Image imgS1;
	Image imgD1;
	Image imgW2;
	Image imgA2;
	Image imgS2;
	Image imgD2;
	
	private int points = 0; 
	private int end = 0;
	
	//Variable below if for frog movement
	private boolean second = false;
	private boolean noMove = false;
	
	private static final double movement = 13.3333333*2; //y axis movement
	private static final double movementX = 10.666666*2; //x axis movement
	private static final int imgSize = 40;
	
	private boolean carDeath = false;
	private boolean waterDeath = false;
	
	private boolean stop = false;
	private boolean changeScore = false;
	
	private int carD = 0;
	private double w = 800;
	
	ArrayList<End> inter = new ArrayList<End>(); //check if frog is at the end
	
	public Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setFrogToStart();
		imgW1 = new Image("file:src/main/resources/Image/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/main/resources/Image/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/main/resources/Image/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/main/resources/Image/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/main/resources/Image/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/main/resources/Image/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/main/resources/Image/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/main/resources/Image/froggerRightJump.png", imgSize, imgSize, true, true);

		createKeyListener();
	}
	
	private void createKeyListener() {
		
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			public void handle(KeyEvent event){
				
				userControls(event);
			}
		});
		
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			
			public void handle(KeyEvent event) {
				
				userControls(event);
			}
		});
	}
	
	private void userControls(KeyEvent event) {
					
		if (noMove) {
		}
		else {
			switch (event.getCode()) {
				case W: move(0, -movement);
						frogAnimation(second, 'W');
						if (second) {
							changeScore = false;
						}
						else {
							if (getY() < w) {
								changeScore = true;
								w = getY();
								points += 10;
							}
						}
						break;
						
				case A: move(-movementX, 0);
						frogAnimation(second, 'A');
						break;
				
				case S:	move(0, movement);
						frogAnimation(second, 'S');
						break;
	            	
				case D:	move(movementX, 0);
						frogAnimation(second, 'D');
						break;
				default:
				break;
			}
		}
	}
	
	private void frogAnimation(boolean second, char key){
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
		
		froggerInBound();
		objectintersect();
		//intersectEnd();
		deathProcess(now);
	}
	
	public void froggerInBound() {
		if (getY()<0 || getY()>800) {
			setFrogToStart();
		}
		if (getX()<0) {
			move(movement*2, 0);
		}
		if (getX()>600) {
			move(-movement*2, 0);
		}
	}
	
	public void objectintersect() {
		
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			//intersectEnd();
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=50;
			}
			points+=50;
			changeScore = true;
			w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setX(300);
			setY(679.8+movement);
		}
		else if (getY()<413){
			waterDeath = true;
			setFrogToStart();
		}
	}
	
	private void deathProcess(long now) {
		if (carDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/main/resources/Image/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/main/resources/Image/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/main/resources/Image/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				setX(300);
				setY(679.8+movement);
				carDeath = false;
				carD = 0;
				setImage(new Image("file:src/main/resources/Image/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}
		if (waterDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/main/resources/Image/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/main/resources/Image/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/main/resources/Image/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (carD == 4) {
				setImage(new Image("file:src/main/resources/Image/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (carD == 5) {
				setX(300);
				setY(679.8+movement);
				waterDeath = false;
				carD = 0;
				setImage(new Image("file:src/main/resources/Image/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}
		}
	}
		
	

	/*public void intersectEnd() {
		if (getIntersectingObjects(End.class).get(0).isActivated()) {
			end--;
			points-=50;
		}
		points+=50;
		changeScore = true;
		getIntersectingObjects(End.class).get(0).setEnd();
		setFrogToStart();
		end++;
		
	}*/
	
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
	
	private void setFrogToStart() {
		setX(300);
		setY(750);
	}
	

}
