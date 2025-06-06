package aed;

public interface ITransaccion {
    public boolean equals(Object otraTransaccion);

    public int monto();

    public int id_comprador();
    
    public int id_vendedor();
}
