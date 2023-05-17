package utils;


import java.sql.Connection;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConnectionPool {

    public static volatile ConnectionPool instance;
    private final ConcurrentLinkedQueue<Connection> pool;
    private final int maxSize;

    private ConnectionPool(int maxSize) {
        this.maxSize = maxSize;
        pool = new ConcurrentLinkedQueue<>();
    }

    public static ConnectionPool getInstance(int maxSize) {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool(maxSize);
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return pool.poll();
    }

    public void releaseConnection(Connection connection) {
        pool.add(connection);
    }
}
