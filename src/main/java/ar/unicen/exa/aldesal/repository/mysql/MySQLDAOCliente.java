package ar.unicen.exa.aldesal.repository.mysql;

import ar.unicen.exa.aldesal.dao.ClienteDAO;
import ar.unicen.exa.aldesal.entity.Cliente;

import java.sql.Connection;
import java.util.List;

public class MySQLDAOCliente extends MySQLEntidadDAO implements ClienteDAO {


    public MySQLDAOCliente(Connection connection) {
        super(connection);
    }

    @Override
    protected String getInitQuery() {
        return
                """
                CREATE TABLE IF NOT EXISTS Cliente (
                idCliente INTEGER PRIMARY KEY,
                nombre VARCHAR(100) NOT NULL,
                email VARCHAR(100) NOT NULL
                )
                """;
    }

    @Override
    public void insertarVarios(List<Cliente> EntidadDAO) {

    }

    @Override
    public void vaciar(Cliente EntidadDAO) {

    }
}
