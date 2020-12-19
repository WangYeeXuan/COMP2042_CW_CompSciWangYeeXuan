package javaTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import javafx.embed.swing.JFXPanel;
import model.Fast_car;

/**
 * This test class is to test the initial position of model Fast_car.
 * @author Wang
 *
 */
class Fast_carTest {
	
	JFXPanel jfxPanel = new JFXPanel() ;
	
	@Test
	void test() {
		
		System.out.println("\nTest case : The Initial position of fast car");
		
		Fast_car testfastcar = new Fast_car(500, 485, 5) ;
		
		assertEquals(500.0 , testfastcar.getX(), 0.0) ;
		assertEquals(485.0 ,  testfastcar.getY(), 0.0) ;
		
		System.out.println("Initial X-coordinate of fast car: " +  testfastcar.getX()) ;
		System.out.println("Initial Y-coordinate of fast car: " +  testfastcar.getY()) ;
	}

}
