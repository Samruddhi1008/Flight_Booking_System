package main;

import flight.Flight;
import flight.Seat;
import user.User;
import booking.Booking;
import payment.Payment;

import java.util.*;

public class FlightBookingSystem {
    private List<Flight> flights = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public Flight searchFlight(String departure, String destination) {
        for (Flight flight : flights) {
            if (flight.checkAvailability() && flight.getDeparture().equalsIgnoreCase(departure) && flight.getDestination().equalsIgnoreCase(destination)) {
                return flight;
            }
        }
        return null;
    }

    public void bookFlight(User user, Flight flight, List<String> seatNumbers, String paymentMethod) {
        List<Seat> seats = new ArrayList<>();
        for (String seatNumber : seatNumbers) {
            seats.add(new Seat(seatNumber));
        }

        double totalAmount = flight.getPrice() * seats.size();
        Payment payment = new Payment(totalAmount, paymentMethod);
        Booking booking = new Booking(UUID.randomUUID().toString(), user, flight, seats, totalAmount, payment);
        booking.confirmBooking();
    }

    public void startBookingProcess() {
        System.out.println("Welcome to the Flight Booking System!");

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your phone number: ");
        String phone = scanner.nextLine();

        User user = new User("U" + UUID.randomUUID().toString(), name, email, phone);

        System.out.print("Enter departure location: ");
        String departure = scanner.nextLine();

        System.out.print("Enter destination location: ");
        String destination = scanner.nextLine();

        // Search for flight
        Flight flight = searchFlight(departure, destination);
        if (flight == null) {
            System.out.println("No flights available for the selected route.");
            return;
        }

        // Display flight info
        flight.displayFlightInfo();

        // Enter seat numbers
        System.out.print("Enter the number of seats you want to book: ");
        int seatCount = Integer.parseInt(scanner.nextLine());

        List<String> seatNumbers = new ArrayList<>();
        for (int i = 0; i < seatCount; i++) {
            System.out.print("Enter seat number (e.g., A1, A2): ");
            seatNumbers.add(scanner.nextLine());
        }

        // Select payment method
        System.out.print("Enter payment method (e.g., Credit Card, Debit Card): ");
        String paymentMethod = scanner.nextLine();

        // Book flight
        bookFlight(user, flight, seatNumbers, paymentMethod);
    }

    public static void main(String[] args) {
        FlightBookingSystem system = new FlightBookingSystem();
        system.addFlight(new Flight("F123", "New York", "Los Angeles", "10:00 AM", "1:00 PM", 300, 100));
        system.addFlight(new Flight("F456", "Chicago", "Miami", "2:00 PM", "6:00 PM", 250, 50));

        system.startBookingProcess();
    }
}
