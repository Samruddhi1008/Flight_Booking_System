package flight;

public class Seat {
    private String seatNumber;
    private boolean isAvailable;

    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void reserveSeat() {
        this.isAvailable = false;
    }
}
