package Models;

import java.util.Date;


public class Booking {
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    private int bookingId;
    private int providerId;
    private int roomId;
    private int serviceId;
    private Date startTime;
    private Date endTime;
    private int clientId;

    public Booking(int bookingId, int providerId, int serviceId, int roomId, Date startTime, Date endTime, int clientId) {
        this.bookingId = bookingId;
        this.providerId = providerId;
        this.serviceId = serviceId;
        this.roomId = roomId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.clientId = clientId;
    }
}
