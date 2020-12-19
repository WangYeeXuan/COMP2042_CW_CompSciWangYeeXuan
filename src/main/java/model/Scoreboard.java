package model;

/**
 * This class is responsible of the display and update of the scoreboard.
 * @author Wang
 *
 */
public class Scoreboard {

	private Digit[] scoreDigit;
	
	/**
	 * This methos is the set the position of the scoreboard.
	 * @param level indicate level
	 */
	public Scoreboard(model.level.Level level) {
		
		//Create an array to store the digits
		scoreDigit =  new Digit[4];
		
		scoreDigit[0] = new Digit(0, 20, 570, 40);
		scoreDigit[1] = new Digit(0, 20, 550, 40);
		scoreDigit[2] = new Digit(0, 20, 530, 40);
		scoreDigit[3] = new Digit(0, 20, 510, 40);
		
		for(int i = 0;i < scoreDigit.length; i++) {
			
			level.add(scoreDigit[i]);
			
		}
		
	}
	
	/**
	 * This method is used to set the score.
	 * @param n n
	 */
	public void setScore(int n) {
		
    	for(int i=0;i<4;i++) {
    		
    		int d = n / 10;
    		int k = n - d * 10;
    		scoreDigit[i].setDigit(k);
    		n = d;
    		
    	}
		
	}
	
}
