package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/MalvaderDB";  // Altere conforme necessário
    private static final String USER = "root";
    private static final String PASSWORD = "123456789";

    private static final Logger logger = Logger.getLogger(DBUtil.class.getName());
    private static ThreadLocal<Connection> threadConnection = new ThreadLocal<>();  // ThreadLocal para conexão por thread

    public static Connection getConnection() {
        Connection connection = threadConnection.get();
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                connection.setAutoCommit(false);
                threadConnection.set(connection);  // Armazenar a conexão por thread
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Erro ao conectar ao banco de dados", e);
            }
        }
        return connection;
    }

    public static void beginTransaction() {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                connection.setAutoCommit(false);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao iniciar transação", e);
        }
    }

    public static void commitTransaction() {
        try {
            Connection connection = getConnection();
            if (connection != null && !connection.isClosed()) {
                connection.commit();
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao cometer transação", e);
        }
    }

    public static void rollbackTransaction() {
        try {
            Connection connection = getConnection();
            if (connection != null && !connection.isClosed()) {
                connection.rollback();
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao reverter transação", e);
        }
    }

    public static void closeConnection() {
        try {
            Connection connection = threadConnection.get();
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao fechar a conexão", e);
        } finally {
            threadConnection.remove();  // Remover conexão após o fechamento
        }
    }
}
