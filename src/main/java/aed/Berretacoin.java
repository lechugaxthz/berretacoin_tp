package aed;

import java.util.*;

public class Berretacoin implements IBerretacoin {

    private int cantUsuarios;
    private HeapUsuarios heapUsuarios;
    private Bloque bloque;

    public Berretacoin Berretacoin(int cantUsuarios) {
        Berretacoin berretacoin = this;
        berretacoin.cantUsuarios = cantUsuarios;
        berretacoin.heapUsuarios = new HeapUsuarios();
        return berretacoin;
    };


    @Override
    public void agregarBloque(ArrayList<Transaccion> transacciones) {
        return;
    }

    @Override
    public Transaccion txMayorValorUltimoBloque() {
        return null;
    }

    @Override
    public ArrayList<Transaccion> txUltimoBloque() {
        return null;
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
