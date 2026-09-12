package concurrency.phase2;

public class RaceConditionDemo {

    public static void main(String[] args)
            throws InterruptedException {

        InventoryService inventory =
                new InventoryService();

        Thread customerA = new Thread(
                () -> inventory.reserve("Customer-A"),
                "customer-a-thread"
        );

        Thread customerB = new Thread(
                () -> inventory.reserve("Customer-B"),
                "customer-b-thread"
        );

        customerA.start();
        customerB.start();

        customerA.join();
        customerB.join();

        System.out.println(
                "Final stock = " + inventory.getStock()
        );
    }
}
