package javaTest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import model.Turtle;

class TurtleTest {
	
	JFXPanel jfxPanel = new JFXPanel() ;
	
	@Test
	void test() {
		
		System.out.println("\nTest case : The Initial position of turtle");
		
		Turtle TESTturtle = new Turtle(500, 376, -1) ;
		
		assertEquals(500.0 , TESTturtle.getX(), 0.0) ;
		assertEquals(376.0 ,  TESTturtle.getY(), 0.0) ;
		
		System.out.println("Initial X-coordinate of turtle: " +  TESTturtle.getX()) ;
		System.out.println("Initial Y-coordinate of turtle: " +  TESTturtle.getY()) ;
	}

}
