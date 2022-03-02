package Wait_ThreadSleep;

public class Main {
    public static void main(String[] agrs) throws InterruptedException {
        Sum sum = new Sum();
        sum.run();
        synchronized (sum) {
            while (sum.sum == 0) {
                System.out.println("Waiting for ThreadB to complete...");
                sum.wait();
            }
            System.out.println("ThreadB has completed. " +
                    "Sum from that thread is: " + sum.sum);
        }
    }
}
