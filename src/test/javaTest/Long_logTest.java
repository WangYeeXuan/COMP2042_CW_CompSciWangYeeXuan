package javaTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import javafx.embed.swing.JFXPanel;
import model.Long_log;

/**
 * This test class is to test the initial position of model Long_log.
 * @author Wang
 *
 */
class Long_logTest {
	
	JFXPanel jfxPanel = new JFXPanel() ;
	
	@Test
	void test() {
		System.out.println("\nTest case : The Initial position of long log");
		
		Long_log testlonglog = new Long_log(0, 276, -2) ;
		
		assertEquals(0.0 , testlonglog.getX(), 0.0) ;
		assertEquals(276.0 ,  testlonglog.getY(), 0.0) ;
		
		System.out.println("Initial X-coordinate of long log: " +  testlonglog.getX()) ;
		System.out.println("Initial Y-coordinate of long log: " +  testlonglog.getY()) ;
	}

}
