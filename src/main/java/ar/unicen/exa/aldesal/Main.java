package ar.unicen.exa.aldesal;

import ar.unicen.exa.aldesal.dao.ClienteDAO;
import ar.unicen.exa.aldesal.entity.Cliente;
import ar.unicen.exa.aldesal.factory.DAOFactory;
import ar.unicen.exa.aldesal.factory.DBType;
import ar.unicen.exa.aldesal.repository.mysql.MySQLDAOCliente;
import ar.unicen.exa.aldesal.repository.mysql.MySQLDAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        DAOFactory factory = DAOFactory.getDAOFactory(DBType.mysql);
        ClienteDAO clienteDAO = factory.getClienteDAO();
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1,"Lukita", "papa"));
        clientes.add(new Cliente(2,"Lukita", "papa"));
        clientes.add(new Cliente(3,"Lukita", "papa"));
        clientes.add(new Cliente(4,"Lukita", "papa"));

        clienteDAO.insertarVarios(clientes);
    }
}