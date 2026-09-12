package concurrency.phase1;

import concurrency.phase0.Order;
import concurrency.phase0.OrderProcessor;

public class OrderThread extends Thread{

    private final OrderProcessor processor;
    private final Order order;

    public OrderThread(
            OrderProcessor processor,
            Order order) {

        this.processor = processor;
        this.order = order;
    }

    @Override
    public void run() {
        processor.process(order);
    }

}
