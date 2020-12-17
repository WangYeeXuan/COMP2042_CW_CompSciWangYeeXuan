package model.level;

import model.*;

public abstract class Level extends World {
	
	private Scoreboard scoreboard;
	private Animal animal;
	
	public Level() {
		
		add(new Background_Image());
		scoreboard = new Scoreboard(this);
		animal = new Animal();
		add(animal);

	}
	
	public Scoreboard getScoreboard() {
		
		return scoreboard;
		
	}
	
	public Animal getAnimal() {
		
		return animal;
		
	}
	
	public void setAnimaltoFront() {
		
		animal.toFront();
		
	}
	
}
