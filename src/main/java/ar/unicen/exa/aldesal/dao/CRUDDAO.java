package ar.unicen.exa.aldesal.dao;
import java.sql.SQLException;
import java.util.List;

public interface CRUDDAO<T> {
    public abstract void insertarVarios(List<T> EntidadDAO) throws SQLException;
    public abstract void vaciar() throws SQLException;
}
