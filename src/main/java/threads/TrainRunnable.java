package threads;

public class TrainRunnable implements Runnable {

    private final String name;

    public TrainRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
                + " " + name + ", is on the move");
    }
}
