package concurrency.phase3;
class Counter {

    private int count = 0;

    // void increment() {
    //     count++;
    // }

    // synchronized void increment() {
    //     count++;
    // }

    void increment(){
        synchronized (this) {
            count++;
        }
    }

    int getCount() {
        return count;
    }
}
public class RaceConditionDemo2 {

    public static void main(String[] args) throws InterruptedException{
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.getCount());//200000
    }
}
