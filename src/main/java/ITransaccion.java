public interface ITransaccion {
    public int compareTo(ITransaccion otraTransaccion);

    public boolean equals(Object otraTransaccion);

    public int monto();

    public int id_comprador();
    
    public int id_vendedor();
}
