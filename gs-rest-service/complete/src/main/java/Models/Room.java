package Models;

import java.util.Arrays;
import java.util.List;

public class Room {
    private int roomId;
    private List<Service> allowedService;

    public boolean[][] getAvailability() {
        return availability;
    }

    public void setAvailability(boolean[][] availability) {
        this.availability = availability;
    }

    public List<Service> getAllowedService() {
        return allowedService;
    }

    public void setAllowedService(List<Service> allowedService) {
        this.allowedService = allowedService;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
    public Room() {
        availability = new boolean[7][8];
        for (int i = 0; i < availability.length; i++) {
            // All time slots are initially available
            Arrays.fill(availability[i], true);
        }
    }

    private boolean[][] availability;
}
