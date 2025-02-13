package booking;

import flight.Flight;
import flight.Seat;
import user.User;
import payment.Payment;
import java.util.List;

public class Booking {
    private String bookingId;
    private User user;
    private Flight flight;
    private List<Seat> selectedSeats;
    private double totalAmount;
    private Payment payment;

    public Booking(String bookingId, User user, Flight flight, List<Seat> selectedSeats, double totalAmount, Payment payment) {
        this.bookingId = bookingId;
        this.user = user;
        this.flight = flight;
        this.selectedSeats = selectedSeats;
        this.totalAmount = totalAmount;
        this.payment = payment;
    }

    public void confirmBooking() {
        payment.processPayment();
        if (payment.getPaymentStatus().equals("Completed")) {
            System.out.println("Booking confirmed! Booking ID: " + bookingId);
        }
    }
}
