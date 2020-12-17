package model;

import model.*;

public class Level2 extends Level {
	
	public Level2() {
		
		//End 
		add(new End(13,96));
		add(new End(141,96));
		add(new End(141 + 141-13,96));
		add(new End(141 + 141-13+141-13+1,96));
		add(new End(141 + 141-13+141-13+141-13+3,96));
				
		//Row 1
		add(new Crocodile(0, 166, 0.75));
		add(new Crocodile(400, 166, 0.75));
				
		//Row 2
		add(new WetTurtle(600, 217, -1));
		add(new WetTurtle(400, 217, -1));
		add(new WetTurtle(200, 217, -1));
				
		//Row 3
		add(new LongLog(0, 276, -2));
		add(new LongLog(400, 276, -2));
				
		//Row 4
		add(new ShortLog(50, 329, 0.75));
		add(new MediumLog(270, 329, 0.75));
		add(new ShortLog(600, 329, 0.75));
				
		//Row 5
		add(new Turtle(500, 376, -1));
		add(new Turtle(300, 376, -1));
		add(new Turtle(700, 376, -1));
				
		//Row 6
		add(new Fastcar(500, 485, -5));
		
		//Row 8
		add(new ShortTruck(0, 597, 1));
		
		setAnimaltoFront();
	}
	
}
