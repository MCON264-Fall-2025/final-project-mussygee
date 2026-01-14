package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Venue;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VenueSelectorTest {

    @Test
    void selectVenue_returnsNullWhenNoVenueWithinBudget() {
        VenueSelector selector = new VenueSelector();
        List<Venue> venues = List.of(
                new Venue("A", 1000, 10, 10, 8),
                new Venue("B", 900,  10, 10, 8)
        );

        assertNull(selector.selectVenue(venues, 200));
    }

    @Test
    void selectVenue_picksCheapestWithinBudget() {
        VenueSelector selector = new VenueSelector();
        Venue cheap = new Venue("Cheap", 300, 10, 10);
        Venue mid   = new Venue("Mid",   400, 10, 10);

        Venue result = selector.selectVenue(List.of(mid, cheap), 500);

        assertNotNull(result);
        assertEquals("Cheap", result.getName());
    }

    @Test
    void selectVenue_tieOnCost_picksSmallerCapacity() {
        VenueSelector selector = new VenueSelector();
        Venue small = new Venue("Small", 500, 5, 10);
        Venue large = new Venue("Large", 500, 10, 10);

        Venue result = selector.selectVenue(List.of(large, small), 500);

        assertNotNull(result);
        assertEquals("Small", result.getName());
    }
}
