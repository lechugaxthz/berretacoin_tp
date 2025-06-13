package aed;

import java.util.ArrayList;

public class Bloque implements IBloque {
    private ArrayList<Transaccion> transacciones;
    private ArrayList<Transaccion> heapTransacciones;

    public Bloque() {
        Bloque bloque = this;
        bloque.transacciones = new ArrayList<Transaccion>();
        bloque.heapTransacciones = new ArrayList<Transaccion>();
    }


    @Override
    public void agregarTransaccion(Transaccion nuevasTransaccion) {
        transacciones.add(nuevasTransaccion);
        heapTransacciones.add(nuevasTransaccion);
    }

    @Override
    public void sortHeapTransacciones() {
        for (int i = (transacciones.size() / 2) - 1; i >= 0; i--) {}
    }

    private void shiftUpAndDown(int i) {
        while(true) {
            int izq = (2 * i) + 1;
            int der = (2 * i) + 2;
            int mayor = i;
            if (izq < transacciones.size()) break;
        }
        System.out.print(i);
    }

    @Override
    public Transaccion maximaTransaccion() {
        return heapTransacciones.get(0);
    }

    @Override
    public Transaccion[] obtenerCopiaTransacciones() {
        return new Transaccion[0];
    }

    @Override
    public Transaccion HackTransaccion() {
        return null;
    }
}
