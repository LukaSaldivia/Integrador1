package ar.unicen.exa.aldesal.utils;

import ar.unicen.exa.aldesal.dao.ClienteDAO;
import ar.unicen.exa.aldesal.dao.FacturaDAO;
import ar.unicen.exa.aldesal.dao.FacturaProductoDAO;
import ar.unicen.exa.aldesal.dao.ProductoDAO;

import java.sql.SQLException;

public class VaciarRegistros {
    public static void vaciarDAOs(ClienteDAO d1, ProductoDAO d2, FacturaDAO d3, FacturaProductoDAO d4) throws SQLException {
        d4.vaciar();d1.vaciar();d2.vaciar();d3.vaciar();
    }
}
