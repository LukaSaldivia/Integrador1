package ar.unicen.exa.aldesal;

import ar.unicen.exa.aldesal.dao.ClienteDAO;
import ar.unicen.exa.aldesal.dao.FacturaDAO;
import ar.unicen.exa.aldesal.dao.FacturaProductoDAO;
import ar.unicen.exa.aldesal.dao.ProductoDAO;
import ar.unicen.exa.aldesal.entity.Cliente;
import ar.unicen.exa.aldesal.entity.Factura;
import ar.unicen.exa.aldesal.factory.DAOFactory;
import ar.unicen.exa.aldesal.factory.DBType;
import ar.unicen.exa.aldesal.repository.mysql.MySQLDAOCliente;
import ar.unicen.exa.aldesal.repository.mysql.MySQLDAOFactory;
import ar.unicen.exa.aldesal.utils.VaciarRegistros;

import java.sql.SQLException;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        DAOFactory factory = DAOFactory.getDAOFactory(DBType.mysql);

        ClienteDAO clienteDAO = factory.getClienteDAO();
        ProductoDAO productoDAO = factory.getProductoDAO();
        FacturaDAO facturaDAO = factory.getFacturaDAO();
        FacturaProductoDAO  facturaProductoDAO = factory.getFacturaProductoDAO();

        VaciarRegistros.vaciarDAOs(clienteDAO,productoDAO,facturaDAO,facturaProductoDAO);


    }
}