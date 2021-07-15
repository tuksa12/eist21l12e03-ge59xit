package de.tum.in.ase.eist;

import static org.junit.jupiter.api.Assertions.*;

import java.time.*;
import java.util.*;

import org.easymock.Mock;
import org.junit.jupiter.api.*;

class RiderTest {

    private Rider testRider;
    private PEV testPEV;
    private LocalDateTime testLocalDateTime;
    private DriversLicense testDriversLicense;



	/*
     * @formatter:off
     *
     * Helpful methods from java.time:
     *
     * Creating new LocalDateTime objects:
     * - LocalDateTime.now()
     * - LocalDateTime.of(year, month, day, hour, minute)
     * - someDateTime.plusYears(years)
     * - someDateTime.plusSeconds(seconds)
     *
     * Getting the time span between two dates:
     * - Duration.between(from, to).getSeconds()
     *
     * Comparing two LocalDateTime objects
     * - dateTimeOne.isBefore(dateTimeTwo)
     * - dateTimeOne.isAfter(dateTimeTwo)
     *
     * @formatter:on
     */

	// TODO implement the 2 tests here

    @Test
    public void rent() {
        testPEV = new EBike(100, "Plate");
        testDriversLicense = new DriversLicense(LocalDateTime.MAX,"Plate");
        testLocalDateTime = LocalDateTime.now();
        testRider = new Rider("Example", 20, true, testDriversLicense);
        Rental testRental = new Rental(testLocalDateTime, LocalDateTime.MAX, testPEV, testRider);

        Assertions.assertNotNull(testRental);

        testRental = testPEV.rent(testLocalDateTime, LocalDateTime.MAX,testRider);
        Assertions.assertTrue(testPEV.getRentals().contains(testRental));
    }

    @Test
    public void list() {
        testPEV = new EBike(100, "Plate");
        testDriversLicense = new DriversLicense(LocalDateTime.MAX,"Plate");
        testLocalDateTime = LocalDateTime.now();
        testRider = new Rider("Example", 20, true, testDriversLicense);
        Rental testRental = new Rental(testLocalDateTime, LocalDateTime.MAX, testPEV, testRider);

        testPEV.getRentals().add(testRental);
        Assertions.assertFalse(testPEV.getRentals().contains(testRental));
    }


}
