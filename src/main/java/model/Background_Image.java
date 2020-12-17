package model;

import javafx.scene.image.Image;

public class Background_Image extends Actor{

	//Constructor 
	public Background_Image() {
		
		setImage(new Image("file:src/main/resources/image/iKogsKW.png", 600, 900, true, true));
	}
	

	@Override
	public void act(long now) {
		
		
	}
	
}
