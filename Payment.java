package payment;

public class Payment {
    private double amount;
    private String paymentMethod;
    private String paymentStatus;

    public Payment(double amount, String paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = "Pending";
    }

    public void processPayment() {
        // Simulate payment processing
        System.out.println("Processing payment of $" + amount + " using " + paymentMethod + "...");
        paymentStatus = "Completed";
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }
}
