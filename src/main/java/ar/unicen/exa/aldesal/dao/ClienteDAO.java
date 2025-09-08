package ar.unicen.exa.aldesal.dao;

import ar.unicen.exa.aldesal.entity.Cliente;

import java.sql.SQLException;
import java.util.List;

public interface ClienteDAO extends CRUDDAO<Cliente> {

    public List<Cliente> getClientesMasFacturado() throws SQLException;

}
