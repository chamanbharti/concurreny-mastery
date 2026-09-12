package concurrency.phase0;
public class InventoryService {

    public boolean isAvailable(Order order) {
        System.out.println(
                "Checking inventory for: " + order.orderId()
        );

        return true;
    }

}

