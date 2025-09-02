package ar.unicen.exa.aldesal.entity;

public class FacturaProducto {
    private int idFactura;
    private int idCliente;
    private int cantidad;

    public FacturaProducto(int idFactura, int idCliente, int cantidad) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.cantidad = cantidad;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
