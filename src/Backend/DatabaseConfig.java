package Backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConfig {
    private static final String URL = "jdbc:sqlite:spendsmart.db";
    private static Connection connection = null;
    
    public static Connection getConnection() {
        if(connection == null || isClosed()) {
            initialize();
        }
        return connection;
    }
    
    private static boolean isClosed() {
        try {
            return connection == null || connection.isClosed();
        } catch(SQLException e) {
            return true;
        }
    }

    public static void initialize() {
        if (connection != null && !isClosed()) {
            return;
        }

        try {
            Class.forName("org.sqlite.JDBC");                      
            connection = DriverManager.getConnection(URL);
            System.out.println("SQLite database initialized successfully.");
            
            try (Statement stmt = connection.createStatement()) {
                stmt.execute("PRAGMA foreign_keys = ON;");
                stmt.execute("PRAGMA journal_mode = WAL;");
            }

            Runtime.getRuntime().addShutdownHook(new Thread(() -> closeConnection()));

            createTables();

        } catch (SQLException e) {
            System.out.println("Database initialization failed: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite Driver missing from classpath: " + e.getMessage());
        }
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                    System.out.println("Database connection closed.");
                }
            } catch (SQLException e) {
                System.out.println("Failed to close database connection: " + e.getMessage());
            } finally {
                connection = null;
            }
        }
    }

    private static void createTables() {
        if (connection == null) {
            System.out.println("Table creation skipped: no database connection.");
            return;
        }

        String createUsersTable = "CREATE TABLE IF NOT EXISTS users ("
                + "user_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "username TEXT NOT NULL UNIQUE,"
                + "password_hash TEXT NOT NULL,"
                + "password_salt TEXT NOT NULL"
                + ");";

        String createCategoriesTable = "CREATE TABLE IF NOT EXISTS categories ("
                + "category_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "category_name TEXT NOT NULL UNIQUE"
                + ");";

        String createTransactionsTable = "CREATE TABLE IF NOT EXISTS transactions ("
                + "expense_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "user_id INTEGER NOT NULL,"
                + "category_id INTEGER NOT NULL,"
                + "amount REAL NOT NULL,"
                + "description TEXT NOT NULL,"
                + "expense_date TEXT NOT NULL,"
                + "created_at TEXT NOT NULL,"
                + "FOREIGN KEY (user_id) REFERENCES users(user_id),"
                + "FOREIGN KEY (category_id) REFERENCES categories(category_id)"
                + ");";
        
        String createIndex = "CREATE INDEX IF NOT EXISTS idx_transactions_user_id ON transactions(user_id);";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createUsersTable);
            stmt.execute(createCategoriesTable);
            stmt.execute(createTransactionsTable);
            stmt.execute(createIndex);
            System.out.println("Database schemas verified and ready.");
        } catch (SQLException e) {
            System.out.println("Table creation failed: " + e.getMessage());
        }
    }
}
