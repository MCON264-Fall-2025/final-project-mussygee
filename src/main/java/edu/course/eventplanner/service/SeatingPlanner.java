package edu.course.eventplanner.service;

import edu.course.eventplanner.model.*;
import java.util.*;

public class SeatingPlanner {
    private final Venue venue;

    public SeatingPlanner(Venue venue) {
        this.venue = venue;
    }

    public Map<Integer, List<Guest>> generateSeating(List<Guest> guests) {
        Map<String, Queue<Guest>> groups = new HashMap<>();

        for (Guest g : guests) {
            String tag = g.getGroupTag();
            groups.putIfAbsent(tag, new LinkedList<>());
            groups.get(tag).add(g);
        }

        return null; // seating logic comes later
    }
}
