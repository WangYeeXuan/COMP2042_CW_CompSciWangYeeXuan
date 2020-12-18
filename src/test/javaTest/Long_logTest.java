package javaTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import model.Long_log;

class Long_logTest {
	
	JFXPanel jfxPanel = new JFXPanel() ;
	
	@Test
	void test() {
		System.out.println("\nTest case : The Initial position of long log");
		
		Long_log TESTlonglog = new Long_log(0, 276, -2) ;
		
		assertEquals(0.0 , TESTlonglog.getX(), 0.0) ;
		assertEquals(276.0 ,  TESTlonglog.getY(), 0.0) ;
		
		System.out.println("Initial X-coordinate of long log: " +  TESTlonglog.getX()) ;
		System.out.println("Initial Y-coordinate of long log: " +  TESTlonglog.getY()) ;
	}

}
