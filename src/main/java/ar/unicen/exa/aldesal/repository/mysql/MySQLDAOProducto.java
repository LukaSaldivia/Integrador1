package ar.unicen.exa.aldesal.repository.mysql;


import ar.unicen.exa.aldesal.dao.ProductoDAO;
import ar.unicen.exa.aldesal.entity.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLDAOProducto extends MySQLEntidadDAO implements ProductoDAO {

    public MySQLDAOProducto(Connection connection) {
        super(connection);
    }

    @Override
    public void insertarVarios(List<Producto> EntidadDAO) throws SQLException {
        String query =
                """
                    INSERT INTO Producto (idProducto, nombre, valor) VALUES 
                """;

        ArrayList<String> values = new ArrayList<>();
        ArrayList<String> placeholders = new ArrayList<>();

        for (Producto producto : EntidadDAO) {
            placeholders.add("(?,?,?)");
            values.add(String.valueOf(producto.getIdProducto()));
            values.add(producto.getNombre());
            values.add(String.valueOf(producto.getValor()));
        }
        query += String.join(",",placeholders);
        PreparedStatement ps = connection.prepareStatement(query);
        for (int i = 0; i < values.size(); i++) {
            ps.setInt(i + 1, Integer.parseInt(values.get(i)));
            ps.setString(i + 2, values.get(i));
            ps.setInt(i + 3, Integer.parseInt(values.get(i)));
        }
        ps.executeUpdate();
        ps.close();
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
