package ar.unicen.exa.aldesal;

import ar.unicen.exa.aldesal.dao.ClienteDAO;
import ar.unicen.exa.aldesal.factory.DAOFactory;
import ar.unicen.exa.aldesal.factory.DBType;
import ar.unicen.exa.aldesal.repository.mysql.MySQLDAOCliente;
import ar.unicen.exa.aldesal.repository.mysql.MySQLDAOFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DAOFactory factory = DAOFactory.getDAOFactory(DBType.mysql);
        ClienteDAO clienteDAO = factory.getClienteDAO();
    }
}