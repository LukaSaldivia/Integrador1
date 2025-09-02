package ar.unicen.exa.aldesal.repository.mysql;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class MySQLEntidadDAO {
    private final Connection connection;

    public MySQLEntidadDAO(Connection connection) {
        this.connection = connection;
        try {
            this.createTableIfNotExists();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createTableIfNotExists() throws SQLException {
        String query = getInitQuery();
        connection.prepareStatement(query).execute();
    }

    protected abstract String getInitQuery();
}
