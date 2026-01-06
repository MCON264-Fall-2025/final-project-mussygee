package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Guest;
import edu.course.eventplanner.model.Venue;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SeatingPlannerTest {

    @Test
    void generateSeating_seatsEveryone_whenVenueHasEnoughSpace() {
        // Adjust constructor if your Venue constructor differs
        Venue venue = new Venue("TestVenue", 100.0, 10, 2, 5); // capacity 10, 2 tables, 5 seats each

        SeatingPlanner planner = new SeatingPlanner(venue);

        // Adjust Guest constructor if needed
        List<Guest> guests = List.of(
                new Guest("A", "family"),
                new Guest("B", "family"),
                new Guest("C", "friends"),
                new Guest("D", "friends")
        );

        Map<Integer, List<Guest>> seating = planner.generateSeating(guests);

        assertNotNull(seating);

        int seatedCount = seating.values().stream().mapToInt(List::size).sum();
        assertEquals(4, seatedCount);

        // Basic grouping expectation: first table begins with family (since family queue starts first)
        assertEquals("family", seating.get(1).get(0).getGroupTag());
    }
}
