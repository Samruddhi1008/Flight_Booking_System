package flight;

public class Flight {
    private String flightNumber;
    private String departure;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private double price;
    private int availableSeats;

    public Flight(String flightNumber, String departure, String destination, String departureTime, String arrivalTime, double price, int availableSeats) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    // Getter methods for private fields
    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void displayFlightInfo() {
        System.out.println("Flight: " + flightNumber + " | From: " + departure + " | To: " + destination);
        System.out.println("Departure: " + departureTime + " | Arrival: " + arrivalTime + " | Price: $" + price);
        System.out.println("Available Seats: " + availableSeats);
    }

    public boolean checkAvailability() {
        return availableSeats > 0;
    }

    public void reserveSeat() {
        if (availableSeats > 0) availableSeats--;
    }
}
