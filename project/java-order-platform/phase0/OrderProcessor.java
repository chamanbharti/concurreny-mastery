package phase0;
public class OrderProcessor {

    private final InventoryService inventoryService;
    private final FraudService fraudService;
    private final PaymentService paymentService;

    public OrderProcessor(
            InventoryService inventoryService,
            FraudService fraudService,
            PaymentService paymentService) {

        this.inventoryService = inventoryService;
        this.fraudService = fraudService;
        this.paymentService = paymentService;
    }

    public void process(Order order) {

        System.out.println(
                "Processing order: " + order.orderId()
        );

        if (!inventoryService.isAvailable(order)) {
            throw new IllegalStateException("Inventory unavailable");
        }

        if (!fraudService.isSafe(order)) {
            throw new IllegalStateException("Fraud detected");
        }

        paymentService.processPayment(order);

        System.out.println(
                "Order completed: " + order.orderId()
        );
    }
}