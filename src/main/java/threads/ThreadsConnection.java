package threads;

import utils.ConnectionPool;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsConnection {

    private static final int POOL_SIZE = 3;
    private static final int THREAD_POOL_SIZE = 7;

    public static void main(String[] args) {

        Thread train1 = new Thread(new TrainRunnable("Train1"));
        Thread train2 = new Thread(new TrainRunnable("Train2"));
        train1.start();
        train2.start();

        Thread train3 = new TrainThread("Train3");
        Thread train4 = new TrainThread("Train4");
        train3.start();
        train4.start();

        ConnectionPool pool = ConnectionPool.getInstance(POOL_SIZE);
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<CompletableFuture<Connection>> futures = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            CompletableFuture<Connection> future = CompletableFuture.supplyAsync(pool::getConnection, executor);
            futures.add(future);
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        futures.forEach(f -> {
            try {
                System.out.println("Obtained Connection " + f.get());
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();

            }
        });

    }
}
