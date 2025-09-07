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
    public void insertarVarios(List<Factura> EntidadDAO) {
        String sql =
            """
            INSERT INTO factura (idFactura, idCliente) VALUES
            """;

        ArrayList<String> values = new ArrayList<>(), placeholder = new ArrayList<>();

        for (Factura Entidad : EntidadDAO) {
            placeholder.add("(?,?)");
            values.add(String.valueOf(Entidad.getIdFactura()));
            values.add(String.valueOf(Entidad.getIdCliente()));
        }

        sql += String.join(",", placeholder);
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            for (Factura Entidad : EntidadDAO) {
                ps.setInt(1, Entidad.getIdFactura());
                ps.setInt(2, Entidad.getIdCliente());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void vaciar() {
        String sql = "DELETE FROM factura";

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
                idCliente INTEGER NOT NULL
                )
                """;
    }
}
