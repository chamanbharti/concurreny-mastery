package concurrency.phase1;

import concurrency.phase0.FraudService;
import concurrency.phase0.InventoryService;
import concurrency.phase0.Order;
import concurrency.phase0.OrderProcessor;
import concurrency.phase0.PaymentService;

public class Application {

    public static void main(String[] args) throws InterruptedException{

        OrderProcessor processor = new OrderProcessor(new InventoryService(), new FraudService(), new PaymentService());
        Order order1 =
                new Order(
                        "ORD-1001",
                        "CUS-101",
                        "PRODUCT-1",
                        1,
                        2500
                );

        Order order2 =
                new Order(
                        "ORD-1002",
                        "CUS-102",
                        "PRODUCT-2",
                        1,
                        3000
                );

        Thread thread1 = new OrderThread(processor, order1);  
        Thread thread2 = new OrderThread(processor, order2);  
        
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("All orders completed");
        
    }

}
