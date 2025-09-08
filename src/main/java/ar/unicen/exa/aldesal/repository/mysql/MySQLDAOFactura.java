package ar.unicen.exa.aldesal.repository.mysql;

import ar.unicen.exa.aldesal.dao.FacturaDAO;
import ar.unicen.exa.aldesal.entity.Factura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLDAOFactura extends MySQLEntidadDAO implements FacturaDAO {
    public MySQLDAOFactura(Connection connection) {
        super(connection);
    }

    @Override
    public void insertarVarios(List<Factura> EntidadDAO) throws SQLException {
        String sql =
                """
                INSERT INTO Factura (idFactura, idCliente) VALUES
                """;

        ArrayList<String> values = new ArrayList<>(), placeholder = new ArrayList<>();

        for (Factura entidad : EntidadDAO) {
            placeholder.add("(?,?)");
            values.add(String.valueOf(entidad.getIdFactura()));
            values.add(String.valueOf(entidad.getIdCliente()));
        }

        sql += String.join(",", placeholder);
        PreparedStatement ps = connection.prepareStatement(sql);
        for (int i = 0; i < values.size(); i += 2) {
            ps.setInt(i + 1, Integer.parseInt(values.get(i)));
            ps.setInt(i + 2, Integer.parseInt(values.get(i + 1)));
        }

        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void vaciar() {
        String sql = "DELETE FROM Factura";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected String getInitQuery() {
        return
                """
                CREATE TABLE IF NOT EXISTS Factura (
                idFactura INTEGER PRIMARY KEY,
                idCliente INTEGER,
                FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
                )
                """;
    }
}
