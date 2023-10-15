package travelPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TravelPackageTest {
     private TravelPackage travelPackage;
	@BeforeEach
	public void setUp() throws Exception {
		travelPackage=new TravelPackage("Test Package",10);
	}

	@Test
	public void testAddDestination() {
		Destination destination=new Destination("Test Destination");
		
		travelPackage.addDestination(destination);
		
		assertTrue(travelPackage.getItinerary().contains(destination));
	}

}
