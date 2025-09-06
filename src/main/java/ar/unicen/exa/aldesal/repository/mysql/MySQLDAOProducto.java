package ar.unicen.exa.aldesal.repository.mysql;

import ar.unicen.exa.aldesal.dao.ClienteDAO;
import ar.unicen.exa.aldesal.entity.Cliente;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MySQLDAOProducto extends MySQLEntidadDAO implements ClienteDAO {

    public MySQLDAOProducto(Connection connection) {
        super(connection);
    }

    @Override
    public void insertarVarios(List<Cliente> EntidadDAO) throws SQLException {

    }

    @Override
    public void vaciar() throws SQLException {
        String query =
                """
                DELETE * FROM Producto        
                """;
        connection.prepareStatement(query).execute();
    }

    @Override
    protected String getInitQuery() {

        return """
                CREATE TABLE IF NOT EXISTS Producto (
                idProducto INTEGER PRIMARY KEY,
                nombre VARCHAR(45) NOT NULL,
                valor FLOAT NOT NULL,
                """;
    }
}
