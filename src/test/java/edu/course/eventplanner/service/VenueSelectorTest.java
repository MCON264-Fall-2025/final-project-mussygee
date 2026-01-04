package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Venue;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VenueSelectorTest {

    @Test
    void selectVenue_returnsLowestCost_thenSmallestCapacity() {
        // If Venue constructor differs, tell me what it is.
        Venue v1 = new Venue("CheapBig", 100.0, 50, 5, 10);   // cost=100, cap=50
        Venue v2 = new Venue("CheapSmall", 100.0, 30, 5, 10); // cost=100, cap=30 (should win tie)
        Venue v3 = new Venue("Expensive", 200.0, 30, 5, 10);

        VenueSelector selector = new VenueSelector(List.of(v1, v2, v3));

        Venue chosen = selector.selectVenue(150.0, 25);

        assertNotNull(chosen);
        assertEquals("CheapSmall", chosen.getName());
    }
}

