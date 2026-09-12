package concurrency.phase1;

import concurrency.phase0.FraudService;
import concurrency.phase0.InventoryService;
import concurrency.phase0.Order;
import concurrency.phase0.OrderProcessor;
import concurrency.phase0.PaymentService;

public class ApplicationUsingLambdaExpression {

    public static void main(String[] args) throws InterruptedException{
        System.out.println("Using Lambda Expression");
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
        
        // method-I
        // Thread thread1 = new OrderThread(processor, order1);  
        // Thread thread2 = new OrderThread(processor, order2);  

        // method-II    
        // Thread thread1 = new Thread(new OrderTask(processor, order1), "order-ORD-1001");  
        // Thread thread2 = new Thread(new OrderTask(processor, order2), "order-ORD-1002");  

        // method-III
        Thread thread1 = new Thread( ()-> processor.process(order1),"order-ORD-1001");
        Thread thread2 = new Thread( ()-> processor.process(order2),"order-ORD-1002");
        thread1.start();
        thread2.start();
        
        thread1.join();
        thread2.join();
    }

}
