package model;



public class Scoreboard {

	private Digit[] scoreDigit;
	
	public Scoreboard(Level level) {
		
		scoreDigit =  new Digit[4];
		
		scoreDigit[0] = new Digit(0, 20, 570, 40);
		scoreDigit[1] = new Digit(0, 20, 550, 40);
		scoreDigit[2] = new Digit(0, 20, 530, 40);
		scoreDigit[3] = new Digit(0, 20, 510, 40);
		
		for(int i = 0;i < scoreDigit.length; i++) {
			
			level.add(scoreDigit[i]);
			
		}
		
	}
	
	public void setScore(int n) {
		
    	for(int i=0;i<4;i++) {
    		
    		int d = n / 10;
    		int k = n - d * 10;
    		scoreDigit[i].setDigit(k);
    		n = d;
    		
    	}
		
	}
	
}
