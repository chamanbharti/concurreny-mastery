package phase0;
public class Application {

    public static void main(String[] args) {

        OrderProcessor processor = new OrderProcessor(
                        new InventoryService(),
                        new FraudService(),
                        new PaymentService()
                );

        Order order1 = new Order(
                        "ORD-1001",
                        "CUS-101",
                        "PRODUCT-1",
                        1,
                        2500
                );

        Order order2 = new Order(
                        "ORD-1002",
                        "CUS-102",
                        "PRODUCT-2",
                        2,
                        4000
                );

        processor.process(order1);
        System.out.println("second");
        processor.process(order2);
    }
}