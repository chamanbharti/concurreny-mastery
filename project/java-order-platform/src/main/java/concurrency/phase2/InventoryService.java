package concurrency.phase2;
public class InventoryService {

    private int stock = 1;

    public boolean reserve(String customerId) {

        System.out.printf(
                "[%s] %s checking stock. Current stock = %d%n",
                Thread.currentThread().getName(),
                customerId,
                stock
        );

        if (stock > 0) {

            simulateDelay();

            stock--;

            System.out.printf(
                    "[%s] %s reserved item. Remaining stock = %d%n",
                    Thread.currentThread().getName(),
                    customerId,
                    stock
            );

            return true;
        }

        System.out.printf(
                "[%s] %s failed. Out of stock.%n",
                Thread.currentThread().getName(),
                customerId
        );

        return false;
    }

    private void simulateDelay() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public int getStock() {
        return stock;
    }
}