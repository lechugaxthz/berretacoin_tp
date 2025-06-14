package aed;

public interface ITransaccion {
    /**
     * @return ID transaccion.
     */
    int id();

    /**
     * @return monto transferido.
     */
    int monto();

    /**
     * @return ID comprador.
     */
    int id_comprador();

    /**
     * @return ID vendedor.
     */
    int id_vendedor();
}
