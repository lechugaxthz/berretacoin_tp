package aed;

import java.util.*;

public class Berretacoin implements IBerretacoin {

    private int cantUsuarios;
    private HeapUsuarios heapUsuarios;
    private Bloque bloque;

    public Berretacoin(int cantUsuarios) {
        Berretacoin berretacoin = this;
        berretacoin.cantUsuarios = cantUsuarios;
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
        return 0;
    }

    @Override
    public int montoMedioUltimoBloque() {
        return 0;
    }

    @Override
    public void hackearTx() {
        return;
    }
}
