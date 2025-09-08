package ar.unicen.exa.aldesal.repository.mysql;

import ar.unicen.exa.aldesal.dao.FacturaProductoDAO;
import ar.unicen.exa.aldesal.entity.FacturaProducto;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLDAOFacturaProducto extends MySQLEntidadDAO implements FacturaProductoDAO {

    public MySQLDAOFacturaProducto(Connection connection){super(connection);}

    @Override
    protected String getInitQuery(){
        // Esta tabla relaciona facturas con productos y la cantidad de cada uno.
        // Se define una clave primaria compuesta (idFactura, idProducto) y las FK
        // correspondientes a Factura y Producto.
        return
                """
                CREATE TABLE Factura_Producto (
                    idFactura INT NOT NULL,
                    idProducto INT NOT NULL,
                    cantidad INT NOT NULL,
                    PRIMARY KEY (idFactura, idProducto),
                    FOREIGN KEY (idFactura) REFERENCES Factura(idFactura),
                    FOREIGN KEY (idProducto) REFERENCES Producto(idProducto)
                );
                """;
    }

    @Override
    public void insertarVarios(List<FacturaProducto> EntidadDAO) throws SQLException {
        // Inserta varias filas en la tabla Factura_Producto en una sola query.
        // Construye un placeholders "(?,?,?)" por cada FacturaProducto.
        String query = """
                INSERT INTO Factura_Producto (idFactura, idProducto, cantidad) VALUES 
                """;
        ArrayList<String> placeholders = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();

        //Recorre la lista y acumula los valores de cada FacturaProducto
        for(FacturaProducto facturaCliente : EntidadDAO){
            placeholders.add("(?,?,?)");
            values.add(String.valueOf(facturaCliente.getIdFactura()));
            values.add(String.valueOf(facturaCliente.getIdProducto()));
            values.add(String.valueOf(facturaCliente.getCantidad()));
        }

        //Arma la query final con todos los placeholdes separados por coma
        query += String.join(",", placeholders);
        PreparedStatement ps = connection.prepareStatement(query);

        //Asigna los valores a cada placeholdes en el PreparedStatement
        for(int i = 0; i < values.size(); i+=3){
            ps.setInt(i+1, Integer.parseInt(values.get(i)));
            ps.setInt(i+2, Integer.parseInt(values.get(i+1)));
            ps.setInt(i+3, Integer.parseInt(values.get(i+2)));
        }

        //Ejecuta la insercion en la base de datos
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void vaciar() throws SQLException {
        // Elimina todas las filas de la tabla Factura_Producto.
        String query = """
                DELETE FROM Factura_Producto
                """;
        connection.prepareStatement(query).execute();
    }
}