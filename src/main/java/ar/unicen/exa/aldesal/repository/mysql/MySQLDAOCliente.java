package ar.unicen.exa.aldesal.repository.mysql;

import ar.unicen.exa.aldesal.dao.ClienteDAO;
import ar.unicen.exa.aldesal.entity.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public void insertarVarios(List<Cliente> EntidadDAO) throws SQLException {

        String query =
                """
                INSERT INTO Cliente (idCliente, nombre, email) VALUES 
                """;

        ArrayList<String> values = new ArrayList<>(), placeholders = new ArrayList<>();

        for (Cliente cliente : EntidadDAO) {
           placeholders.add("(?,?,?)");
           values.add(String.valueOf(cliente.getIdCliente()));
           values.add(cliente.getNombre());
           values.add(cliente.getEmail());
        }

        query += String.join(",",placeholders);
        PreparedStatement ps = connection.prepareStatement(query);

        for (int i = 0; i < values.size(); i+=3) {
            ps.setInt(i+1, Integer.parseInt(values.get(i)));
            ps.setString(i+2, values.get(i+1));
            ps.setString(i+3, values.get(i+2));
        }

        ps.executeUpdate();
        ps.close();


    }

    @Override
    public void vaciar() throws SQLException {

        String query =
                """
                DELETE * FROM Cliente
                """;

        connection.prepareStatement(query).execute();

    }
}
