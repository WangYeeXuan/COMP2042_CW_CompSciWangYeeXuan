package javaTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import javafx.embed.swing.JFXPanel;
import model.Turtle;

/**
 * This test class is to test the initial position of model Turtle.
 * @author Wang
 *
 */
class TurtleTest {
	
	JFXPanel jfxPanel = new JFXPanel() ;
	
	@Test
	void test() {
		
		System.out.println("\nTest case : The Initial position of turtle");
		
		Turtle testturtle = new Turtle(500, 376, -1) ;
		
		assertEquals(500.0 , testturtle.getX(), 0.0) ;
		assertEquals(376.0 ,  testturtle.getY(), 0.0) ;
		
		System.out.println("Initial X-coordinate of turtle: " +  testturtle.getX()) ;
		System.out.println("Initial Y-coordinate of turtle: " +  testturtle.getY()) ;
	}

}
