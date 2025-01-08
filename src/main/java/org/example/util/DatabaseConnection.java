package org.example.util;
import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";
    private static BasicDataSource pool;

    private DatabaseConnection() {
        // Constructor privado para prevenir instanciación
    }

    private static BasicDataSource getInstance() throws SQLException {
        if (pool == null) {
            pool = new BasicDataSource();
            pool.setUrl(URL);
            pool.setUsername(USER);
            pool.setPassword(PASSWORD);

            pool.setInitialSize(3);
            pool.setMinIdle(2); // Mínimo de conexiones inactivas
            pool.setMaxIdle(5); // Máximo de conexiones inactivas
            pool.setMaxOpenPreparedStatements(100); // Máximo de prepared statements
            pool.setMaxTotal(10);
        }
        return pool;
    }

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }
}
