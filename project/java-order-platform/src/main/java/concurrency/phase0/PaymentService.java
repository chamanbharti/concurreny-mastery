package concurrency.phase0;
public class PaymentService {

    public void processPayment(Order order) {
        System.out.println(
                "Processing payment for: " + order.orderId()
        );
    }
}