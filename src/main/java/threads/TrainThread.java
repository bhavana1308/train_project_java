package threads;

public class TrainThread extends Thread {

    private final String name;

    public TrainThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
                + " " + name + ", is on the move");
    }
}

