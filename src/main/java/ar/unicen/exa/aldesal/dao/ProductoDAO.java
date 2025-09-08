package ar.unicen.exa.aldesal.dao;

import ar.unicen.exa.aldesal.entity.Producto;

import java.sql.SQLException;

public interface ProductoDAO extends  CRUDDAO<Producto> {
    public Producto getMasRecaudado () throws SQLException;
}
