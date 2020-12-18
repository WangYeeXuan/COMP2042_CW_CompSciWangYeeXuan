package javaTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import model.Fast_car;

class Fast_carTest {
	
	JFXPanel jfxPanel = new JFXPanel() ;
	
	@Test
	void test() {
		
		System.out.println("\nTest case : The Initial position of fast car");
		
		Fast_car TESTfastcar = new Fast_car(500, 485, 5) ;
		
		assertEquals(500.0 , TESTfastcar.getX(), 0.0) ;
		assertEquals(485.0 ,  TESTfastcar.getY(), 0.0) ;
		
		System.out.println("Initial X-coordinate of fast car: " +  TESTfastcar.getX()) ;
		System.out.println("Initial Y-coordinate of fast car: " +  TESTfastcar.getY()) ;
	}

}
