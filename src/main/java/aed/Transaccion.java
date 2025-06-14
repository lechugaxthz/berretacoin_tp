package aed;

public class Transaccion implements ITransaccion, Comparable<Transaccion> {
    private final int id;
    private final int id_comprador;
    private final int id_vendedor;
    private final int monto;

    public Transaccion(int id, int id_comprador, int id_vendedor, int monto) {
        this.id = id;
        this.id_comprador = id_comprador;
        this.id_vendedor = id_vendedor;
        this.monto = monto;
    }

    @Override
    public int compareTo(Transaccion transaccion2) {
        int difMonto = transaccion2.monto() - monto;
        if (difMonto == 0) {
            return transaccion2.id() - id;
        }
        return difMonto;
    }

    @Override
    public boolean equals(Object transaccion2) {
        if (transaccion2 instanceof Transaccion){
            Transaccion t = (Transaccion) transaccion2;
            if (this.compareTo(t) == 0 && id_vendedor == t.id_vendedor() && id_comprador == t.id_comprador()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int id(){
        return id;
    }

    @Override
    public int monto() {
        return monto;
    }

    @Override
    public int id_comprador() {
        return id_comprador;
    }

    @Override
    public int id_vendedor() {
        return id_vendedor;
    }
}