package ar.unicen.exa.aldesal.entity;

public class Factura {
    private int idFactura;
    private int idCliente;

    public Factura(int idFactura, int idCliente) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
