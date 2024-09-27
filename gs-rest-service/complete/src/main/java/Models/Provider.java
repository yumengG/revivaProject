package Models;


import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Provider {
    private int providerId;

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Service> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Service> qualifications) {
        this.qualifications = qualifications;
    }

    public boolean[][] getAvailability() {
        return availability;
    }
    public boolean canPerformService(Service service) {
        return qualifications.contains(service);
    }


    public void addAppointment(Date startDate, Date endDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        int startDay = calendar.get(Calendar.DAY_OF_WEEK) - Calendar.MONDAY;
        int startHour = calendar.get(Calendar.HOUR_OF_DAY);

        calendar.setTime(endDate);
        int endDay = calendar.get(Calendar.DAY_OF_WEEK) - Calendar.MONDAY;
        int endHour = calendar.get(Calendar.HOUR_OF_DAY);

        // Mark the slots as occupied
        for (int day = startDay; day <= endDay; day++) {
            for (int hour = (day == startDay ? startHour : 0); hour < (day == endDay ? endHour : availability[day].length); hour++) {
                availability[day][hour] = false; // Mark slot as occupied
            }
        }
    }

    public void setAvailability(boolean[][] availability) {
        this.availability = availability;
    }

    private String firstName;
    private String lastName;
    private List<Service> qualifications;
    // 7 days a week 8 hours per day
    private boolean[][] availability;

    public Provider() {
        availability = new boolean[7][8];
        for (int i = 0; i < availability.length; i++) {
            // All time slots are initially available
            Arrays.fill(availability[i], true);
        }
    }
}
