package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Guest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GuestListManagerTest {

    @Test
    void addGuest_increasesCount_andAllowsLookup() {
        GuestListManager glm = new GuestListManager();

        Guest g = new Guest("Avi", "friends"); // constructor may vary
        glm.addGuest(g);

        assertEquals(1, glm.getGuestCount());
        assertNotNull(glm.findGuest("Avi"));
    }
}

