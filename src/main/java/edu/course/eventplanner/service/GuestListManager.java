package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Guest;

import java.util.*;

public class GuestListManager {
    private final LinkedList<Guest> guests = new LinkedList<>();
    private final Map<String, Guest> guestByName = new HashMap<>();

    public void addGuest(Guest guest) {
        if (guest == null) {
            return;
        }

        String name = guest.getName();
        if (name == null) {
            return;
        }

        // prevent duplicates by name (keeps list + map consistent)
        if (guestByName.containsKey(name)) {
            return;
        }

        guests.add(guest);
        guestByName.put(name, guest);
    }

    public boolean removeGuest(String guestName) {
        if (guestName == null) {
            return false;
        }

        Guest guest = guestByName.remove(guestName);
        if (guest == null) {
            return false;
        }
        return guests.remove(guest);
    }

    public Guest findGuest(String guestName) {
        if (guestName == null) {
            return null;
        }
        return guestByName.get(guestName);
    }

    public int getGuestCount() {
        return guests.size();
    }

    public List<Guest> getAllGuests() {
        return new ArrayList<>(guests);
    }
}
