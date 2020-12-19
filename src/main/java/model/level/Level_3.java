package model.level;

import model.*;

/**
 * This class is responsible for which model is added to the Level_3.
 * @author Wang
 *
 */
public class Level_3 extends Level {
	
	public Level_3() {
		
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
		add(new Wet_turtle(600, 217, -1));
		add(new Wet_turtle(400, 217, -1));
		add(new Wet_turtle(200, 217, -1));
						
		//Row 3
		add(new Long_log(0, 276, -2));
		add(new Long_log(400, 276, -2));
						
		//Row 4
		add(new Short_log(50, 329, 0.75));
		add(new Medium_log(270, 329, 0.75));
		add(new Short_log(600, 329, 0.75));
						
		//Row 5
		add(new Turtle(500, 376, -1));
		add(new Turtle(300, 376, -1));
		add(new Wet_turtle(700, 376, -1));
						
		//Row 6
		add(new Fast_car(500, 485, 3));
		
		//Row 7
		add(new Car(0, 555, -1));
		add(new Car(500, 555, -1));
				
		//Row 8
		add(new Short_truck(0, 597, 1));
				
		setAnimaltoFront();
		
	}
	
}
