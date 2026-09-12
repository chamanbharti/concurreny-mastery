package phase0;
public record Order(
        String orderId,
        String customerId,
        String productId,
        int quantity,
        double amount
) {}
