package model;

import javafx.scene.image.Image;

public class BackgroundImage extends Actor{

	@Override
	public void act(long now) {
		
		
	}
	
	public BackgroundImage(String imageLink) {
		setImage(new Image("file:src/main/resources/Image/iKogsKW.png", 600, 850, true, true));
	}

}
