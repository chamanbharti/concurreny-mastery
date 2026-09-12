package concurrency.phase3;
public class InventoryServiceBlock {

    private int stock = 1;

    public boolean reserve(String customerId) {
        logRequest(customerId);

        System.out.printf(
                "[%s] %s checking stock. Current stock = %d%n",
                Thread.currentThread().getName(),
                customerId,
                stock
        );

        synchronized (this) {
            if (stock > 0) {

            stock--;

            System.out.printf(
                    "[%s] %s reserved item. Remaining stock = %d%n",
                    Thread.currentThread().getName(),
                    customerId,
                    stock
            );

            return true;
          }
        }

        System.out.printf(
                "[%s] %s failed. Out of stock.%n",
                Thread.currentThread().getName(),
                customerId
        );

        return false;
    }

    private void logRequest(String customerId) {
        System.out.println("Reservation request: " + customerId);
    }

    public synchronized int getStock() {
        return stock;
    }
}