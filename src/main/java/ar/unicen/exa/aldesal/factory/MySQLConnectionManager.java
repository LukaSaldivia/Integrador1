package ar.unicen.exa.aldesal.factory;

import java.sql.*;


public final class MySQLConnectionManager {

    // Implementación de Singleton
    private static volatile MySQLConnectionManager instance;

    private Connection connection;

    // Configuración
    private static final String URL = "jdbc:mysql://localhost:3306/db_integrador_1";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private MySQLConnectionManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.err.println("Error: No se encontró el driver de MySQL.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Error al conectar con la base de datos.");
            e.printStackTrace();
        }
    }

    public static MySQLConnectionManager getInstance() {
        if (instance == null) {
            synchronized (MySQLConnectionManager.class) {
                if (instance == null) {
                    instance = new MySQLConnectionManager();
                }
            }
        }
        return instance;
    }


    public Connection getConnection() {
        return connection;
    }
}
