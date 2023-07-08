import java.time.LocalDateTime;


public class Trip {
    public String tripName;
    public LocalDateTime departureTime;
    public LocalDateTime arrivalTime;
    public int duration;
    public String departerState = "IDLE";
    public String arrivalState = "IDLE";

    public Trip(String tripName, LocalDateTime departureTime, int tripDuration) {
        this.tripName = tripName;
        this.departureTime = departureTime;
        this.duration = tripDuration;
        this.arrivalTime = calculateArrival();
    }
    public String getTripName() {
        return tripName;
    }
    public LocalDateTime calculateArrival() {
        return this.departureTime.plusMinutes(this.duration);
    }
    public LocalDateTime getDepartureTime() {
        return departureTime;
    }
    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }
    public String getDeparterState() {
        return departerState;
    }

    public void setDeparterState(String state) {
        this.departerState = state;
    }
    public String getArrivalState() {
        return arrivalState;
    }

    public void setArrivalState(String state) {
        this.arrivalState = state;
    }

}
