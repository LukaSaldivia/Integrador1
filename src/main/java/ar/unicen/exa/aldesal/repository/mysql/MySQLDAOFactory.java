package ar.unicen.exa.aldesal.repository.mysql;

import ar.unicen.exa.aldesal.dao.ClienteDAO;
import ar.unicen.exa.aldesal.dao.FacturaDAO;
import ar.unicen.exa.aldesal.dao.FacturaProductoDAO;
import ar.unicen.exa.aldesal.dao.ProductoDAO;
import ar.unicen.exa.aldesal.factory.DAOFactory;
import ar.unicen.exa.aldesal.factory.MySQLConnectionManager;

public class MySQLDAOFactory extends DAOFactory {

    @Override
    public ClienteDAO getClienteDAO() {
        return new MySQLDAOCliente(MySQLConnectionManager.getInstance().getConnection());
    }

    @Override
    public ProductoDAO getProductoDAO() {
        return null;
    }

    @Override
    public FacturaDAO getFacturaDAO() {
        return null;
    }

    @Override
    public FacturaProductoDAO getFacturaProductoDAO() {
        return null;
    }
}
