package javaTest;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import model.Wet_turtle;

class Wet_turtleTest {
	
	JFXPanel jfxPanel = new JFXPanel() ;
	
	@Test
	void test() {
		
		System.out.println("\nTest case : The Initial position of wet turtle");
		
		Wet_turtle TESTWetturtle = new Wet_turtle(600, 217, -1) ;
		
		assertEquals(600.0 , TESTWetturtle.getX(), 0.0) ;
		assertEquals(217.0 ,  TESTWetturtle.getY(), 0.0) ;
		
		System.out.println("Initial X-coordinate of wet turtle: " +  TESTWetturtle.getX()) ;
		System.out.println("Initial Y-coordinate of wet turtle: " +  TESTWetturtle.getY()) ;
	}

}
