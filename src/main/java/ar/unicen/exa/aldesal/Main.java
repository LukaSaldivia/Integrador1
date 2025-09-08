package ar.unicen.exa.aldesal;

import ar.unicen.exa.aldesal.dao.ClienteDAO;
import ar.unicen.exa.aldesal.dao.FacturaDAO;
import ar.unicen.exa.aldesal.dao.FacturaProductoDAO;
import ar.unicen.exa.aldesal.dao.ProductoDAO;
import ar.unicen.exa.aldesal.entity.Cliente;
import ar.unicen.exa.aldesal.entity.Factura;
import ar.unicen.exa.aldesal.factory.DAOFactory;
import ar.unicen.exa.aldesal.factory.DBType;
import ar.unicen.exa.aldesal.utils.CargarCSV;
import ar.unicen.exa.aldesal.utils.VaciarRegistros;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        DAOFactory factory = DAOFactory.getDAOFactory(DBType.mysql);

        ClienteDAO clienteDAO = factory.getClienteDAO();
        ProductoDAO productoDAO = factory.getProductoDAO();
        FacturaDAO facturaDAO = factory.getFacturaDAO();
        FacturaProductoDAO  facturaProductoDAO = factory.getFacturaProductoDAO();

        VaciarRegistros.vaciarDAOs(clienteDAO,productoDAO,facturaDAO,facturaProductoDAO);
        CargarCSV.cargar(clienteDAO, "clientes.csv");
        CargarCSV.cargar(productoDAO, "productos.csv");
        CargarCSV.cargar(facturaProductoDAO, "factura-productos.csv");
        CargarCSV.cargar(facturaDAO, "facturas.csv");




    }
}