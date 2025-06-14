package aed;

public class Berretacoin implements IBerretacoin {

    private HeapUsuarios heapUsuarios;
    private Bloque bloque;

    public Berretacoin(int cantUsuarios) {
        Berretacoin berretacoin = this;
        berretacoin.heapUsuarios = new HeapUsuarios(cantUsuarios);
    };


    @Override
    public void agregarBloque(Transaccion[] transacciones) {
        bloque = new Bloque();
        for (Transaccion transaccion : transacciones) {
            bloque.agregarTransaccion(transaccion);
            int id_comprador = transaccion.id_comprador();
            int id_vendedor = transaccion.id_vendedor();
            int monto =  transaccion.monto();
            if (id_comprador != 0){
                heapUsuarios.actualizarMontoUsuario(id_comprador, -monto);
            }
            heapUsuarios.actualizarMontoUsuario(id_vendedor, monto);
        }
        bloque.sortHeapTransacciones();
        heapUsuarios.sortHeap();
    }

    @Override
    public Transaccion txMayorValorUltimoBloque() {
        return bloque.maximaTransaccion();
    }

    @Override
    public Transaccion[] txUltimoBloque() {
        return bloque.obtenerCopiaTransacciones();
    }

    @Override
    public int maximoTenedor() {
        return heapUsuarios.getMaximoTenedor();
    }

    @Override
    public int montoMedioUltimoBloque() {
        return bloque.montoMedioBloque();
    }

    @Override
    public void hackearTx() {
        Transaccion transaccion = bloque.HackTransaccion();
        heapUsuarios.actualizarMontoUsuario(transaccion.id_vendedor(), -transaccion.monto());
        heapUsuarios.actualizarMontoUsuario(transaccion.id_comprador(), transaccion.monto());
        int posicionUsuarioEnHeapVendedor = heapUsuarios.getPosicionHeapUsuario(transaccion.id_vendedor());
        /* int posicionUsuarioEnHeapComprador = heapUsuarios.getPosicionHeapUsuario(transaccion.id_comprador());
        if (posicionUsuarioEnHeapComprador % 2 == 0) {
            
        } */
        heapUsuarios.shiftUpAndDown(posicionUsuarioEnHeapVendedor);
        
    }
}
