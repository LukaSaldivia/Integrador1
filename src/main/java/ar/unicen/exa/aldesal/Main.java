package ar.unicen.exa.aldesal;

import ar.unicen.exa.aldesal.dao.ClienteDAO;
import ar.unicen.exa.aldesal.dao.FacturaDAO;
import ar.unicen.exa.aldesal.dao.FacturaProductoDAO;
import ar.unicen.exa.aldesal.dao.ProductoDAO;
import ar.unicen.exa.aldesal.entity.Cliente;
import ar.unicen.exa.aldesal.entity.Producto;
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
        CargarCSV.cargar(facturaDAO, "facturas.csv");
        CargarCSV.cargar(facturaProductoDAO, "facturas-productos.csv");

        ArrayList<Cliente> clientes = new ArrayList<>(clienteDAO.getClientesMasFacturado());

        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNombre() + " " + cliente.getEmail());
        }

        Producto recaudado = productoDAO.getMasRecaudado();
        System.out.println();
        System.out.println(recaudado.getNombre());




    }
}