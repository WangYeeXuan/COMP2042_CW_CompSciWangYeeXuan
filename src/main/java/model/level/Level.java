package model.level;

import model.*;

/**
 * This class is responsible for the what is added to the levels.
 * @author Wang
 *
 */
public abstract class Level extends World {
	
	private Scoreboard scoreboard;
	private Animal animal;
	
	/**
	 * For each level, this method add a new background, scoreboard, animals.
	 */
	public Level() {
		
		add(new Background_Image());
		scoreboard = new Scoreboard(this);
		animal = new Animal();
		add(animal);

	}
	
	/**
	 * This method is to get the scoreboard.
	 * @return scoreboard
	 */
	public Scoreboard getScoreboard() {
		
		return scoreboard;
		
	}
	
	/**
	 * This method is to get the animal.
	 * @return animal
	 */
	public Animal getAnimal() {
		
		return animal;
		
	}
	
	/**
	 * This method is to set the animal to front.
	 */
	public void setAnimaltoFront() {
		
		animal.toFront();
		
	}
	
}
