package Wait_ThreadSleep;

class Sum implements Runnable {
    public int sum = 0;

    @Override
    public void run() {
        synchronized (this) {
            int i = 0;
            while (i < 100000) {
                sum += i;
                i++;
            }
            notifyAll();
        }
    }
}

