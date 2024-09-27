package Services;

import Models.*;


import java.util.*;

public class ScheduleServiceImpl implements ScheduleService{
    int bookingId = 1;
    private Map<Integer, Booking> bookings = new HashMap<>();
    private Map<Integer, Provider> providers = new HashMap<>();
    private Map<Integer, Room> rooms = new HashMap<>();
    private Map<Integer, Service> services = new HashMap<>();

    @Override
    public Booking createBooking(int providerId, int serviceId, int roomId, Date startTime, Date endTime, int clientId) {
        Booking newBooking = new Booking(bookingId, providerId, serviceId, roomId, startTime, endTime, clientId);
        bookings.put(bookingId, newBooking);
        Provider provider = providers.get(providerId);
        provider.addAppointment(startTime, endTime);
        return newBooking;
    }



    @Override
    public boolean cancelBooking(int bookingId) {
        return false;
    }

    @Override
    public Booking getBookingDetails(int bookingId) {
        if (bookings.containsKey(bookingId)) {
            return bookings.get(bookingId);
        }
        return null;
    }

    @Override
    public List<Date> getAllBookingsForProvider(int providerId) {
        List<Date> availableHours = new ArrayList<>();
        Provider provider = providers.get(providerId);

        boolean[][] providerAvailability = provider.getAvailability();

        Calendar calendar = Calendar.getInstance();

        for (int day = 0; day < providerAvailability.length; day++) {
            for (int hour = 0; hour < providerAvailability[day].length; hour++) {
                if (providerAvailability[day][hour]) { // If available
                    calendar.set(Calendar.DAY_OF_WEEK, day + Calendar.MONDAY);
                    calendar.set(Calendar.HOUR_OF_DAY, hour);
                    calendar.set(Calendar.MINUTE, 0);
                    calendar.set(Calendar.SECOND, 0);
                    calendar.set(Calendar.MILLISECOND, 0);

                    availableHours.add(calendar.getTime()); // Add available time slot
                }
            }
        }

        return availableHours;
    }

    @Override
    public List<Date> getAllBookingsForRoom(int roomId, int serviceId) {
        List<Date> availableTimeSlots = new ArrayList<>();

        // Create a calendar instance to build Date objects
        Calendar calendar = Calendar.getInstance();
        for (Room room : rooms.values()) {
            boolean[][] roomAvailability = room.getAvailability();

            // Check availability for each day and hour
            for (int day = 0; day < roomAvailability.length; day++) {
                for (int hour = 0; hour < roomAvailability[day].length; hour++) {
                    if (roomAvailability[day][hour]) {
                        boolean providerAvailable = providers.values().stream()
                                .anyMatch(provider -> provider.canPerformService(services.get(serviceId)));

                        if (providerAvailable) {
                            // Set the calendar to the correct date and time
                            calendar.set(Calendar.DAY_OF_WEEK, day + Calendar.MONDAY);
                            calendar.set(Calendar.HOUR_OF_DAY, hour);
                            calendar.set(Calendar.MINUTE, 0);
                            calendar.set(Calendar.SECOND, 0);
                            calendar.set(Calendar.MILLISECOND, 0);

                            availableTimeSlots.add(calendar.getTime()); // Add available time slot
                        }
                    }
                }
            }
        }

        return availableTimeSlots;
    }

    @Override
    // implement if have more time
    public boolean checkAvailability(int providerId, int roomId, Date startTime, Date endTime) {
        return false;
    }

    public void addRooms(int roomId) {
        Room room = new Room();
        room.setRoomId(roomId);
    }
    public void addProvider(int providerId) {
        if (providers.containsKey(providerId)) {
            return;
        } else {
            Provider provider = new Provider();
            provider.setProviderId(providerId);
        }
    }
    public void addService(int serviceId) {
        Service service = new Service();
        service.setServiceId(serviceId);
    }

    @Override
    public void demo() {
        addProvider(1);
        addProvider(2);
        addRooms(1);
        addRooms(2);
        addService(1);
        addService(2);
    }


}
