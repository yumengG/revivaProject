package Services;


import Models.Booking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface ScheduleService {
    Booking createBooking(int providerId, int serviceId, int roomId, Date startTime, Date endTime, int clientId);

    boolean cancelBooking(int bookingId);

    Booking getBookingDetails(int bookingId);
    public List<Date> getAllBookingsForProvider(int providerId);

    public List<Date> getAllBookingsForRoom(int roomId, int serviceId);

    public boolean checkAvailability(int providerId, int roomId, Date startTime, Date endTime);
    public void demo();
}
