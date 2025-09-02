package ar.unicen.exa.aldesal.factory;

import ar.unicen.exa.aldesal.dao.*;
import ar.unicen.exa.aldesal.repository.mysql.MySQLDAOFactory;


public abstract class DAOFactory {

//  Implementación de Singleton
    private static volatile DAOFactory instance;

    protected DAOFactory(){};

    public static DAOFactory getDAOFactory(DBType dbType) {

        if (instance == null) {
            synchronized (DAOFactory.class){
                if (instance == null) {
                    switch (dbType) {
                        case mysql:
                            instance = new MySQLDAOFactory();
                            break;
                        case derby:
                            break;
                        case postgresql:
                            break;

                            default:
                                throw new UnsupportedOperationException("Unsupported DB type: " + dbType);
                    }
                }
            }
        }


        return instance;
    }

//  Métodos para obtener los DAO

    public abstract ClienteDAO getClienteDAO();

    public abstract ProductoDAO getProductoDAO();

    public abstract FacturaDAO getFacturaDAO();

    public abstract FacturaProductoDAO getFacturaProductoDAO();


}
