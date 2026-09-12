package phase0;
public class FraudService {

    public boolean isSafe(Order order) {
        System.out.println(
                "Running fraud check for: " + order.orderId()
        );

        return true;
    }
}
