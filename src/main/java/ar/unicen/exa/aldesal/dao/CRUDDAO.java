package ar.unicen.exa.aldesal.dao;
import java.util.List;

public interface CRUDDAO<T> {
    public abstract void insertarVarios(List<T> EntidadDAO);
    public abstract void vaciar(T EntidadDAO);
}
