package de.tum.in.ase.eist;

import static org.easymock.EasyMock.expect;
import static org.junit.jupiter.api.Assertions.*;

import java.time.*;
import java.util.*;

import org.easymock.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(EasyMockExtension.class)
class NavigationServiceTest {

	// TODO make sure to specify the necessary elements for the mock object pattern
    @Mock
     private NavigationService testNavigationService;

     private PEV testPEV;
     private RealTimePositionService realTimePositionServiceMock;

	// TODO implement the 2 tests here
    @Test
    public void getInstructions3() {
        Destination testDestination = new Destination(2,2, "Munich");
        testNavigationService = new NavigationService();
        testPEV = new EBike(100, "Plate");
        expect(realTimePositionServiceMock.getX(testPEV)).andReturn(2);
        expect(realTimePositionServiceMock.getY(testPEV)).andReturn(2);

        expect(testNavigationService.getInstructions(testPEV, testDestination)).andReturn("destination reached");
        assertEquals("destination reached", testNavigationService.getInstructions(testPEV, testDestination));

    }
}
