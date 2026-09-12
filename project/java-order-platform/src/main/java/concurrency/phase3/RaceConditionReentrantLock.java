package concurrency.phase3;

public class RaceConditionReentrantLock {

    public static void main(String[] args) throws InterruptedException{
        InventoryServiceReentrantLock inventory = new InventoryServiceReentrantLock();

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

        System.out.println("Final stock = " + inventory.getStock());
    }
}
