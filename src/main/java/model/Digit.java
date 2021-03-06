package model;

import javafx.scene.image.Image;


public class Digit extends Actor{
	
	//Create an array to for the numbers
	private Image[] number = new Image[10];
	
	/**
	 * This method assign each value in the array with a number image.
	 * @param n indicate the value in the array
	 * @param dimensions indicate the dimensions of the image
	 * @param x indicate the x coordinate
	 * @param y indicate the y coordinate
	 */
	public Digit(int n, int dimensions, int x, int y) {
		
		number[0] = new Image("file:src/main/resources/image/0.png", dimensions, dimensions, true, true);
		number[1] = new Image("file:src/main/resources/image/1.png", dimensions, dimensions, true, true);
		number[2] = new Image("file:src/main/resources/image/2.png", dimensions, dimensions, true, true);
		number[3] = new Image("file:src/main/resources/image/3.png", dimensions, dimensions, true, true);
		number[4] = new Image("file:src/main/resources/image/4.png", dimensions, dimensions, true, true);
		number[5] = new Image("file:src/main/resources/image/5.png", dimensions, dimensions, true, true);
		number[6] = new Image("file:src/main/resources/image/6.png", dimensions, dimensions, true, true);
		number[7] = new Image("file:src/main/resources/image/7.png", dimensions, dimensions, true, true);
		number[8] = new Image("file:src/main/resources/image/8.png", dimensions, dimensions, true, true);
		number[9] = new Image("file:src/main/resources/image/9.png", dimensions, dimensions, true, true);
		
		setImage(number[n]);
		setX(x);
		setY(y);
		
	}
	
	/**
	 * This method is to set the digit image.
	 * @param n indicate the value in the array
	 */
	public void setDigit(int n) {
		
		setImage(number[n]);
		
	}
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
}
