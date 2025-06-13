package aed;

import java.util.ArrayList;

public class Bloque implements IBloque {
    private ArrayList<Transaccion> transacciones;
    private ArrayList<Transaccion> heapTransacciones;
    private float montoTotal;
    private float cant_transacciones_no_creacion;

    public Bloque() {
        Bloque bloque = this;
        bloque.transacciones = new ArrayList<Transaccion>();
        bloque.heapTransacciones = new ArrayList<Transaccion>();
        bloque.montoTotal = 0;
        bloque.cant_transacciones_no_creacion= 0;
    }


    @Override
    public void agregarTransaccion(Transaccion nuevasTransaccion) {
        transacciones.add(nuevasTransaccion);
        heapTransacciones.add(nuevasTransaccion);
        if (nuevasTransaccion.id_comprador() != 0){
            montoTotal += nuevasTransaccion.monto();
            cant_transacciones_no_creacion += 1;
        } 
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

            
            if (mayor == i) break;
        }
    }

    @Override
    public Transaccion maximaTransaccion() {
        Transaccion mayorValor = heapTransacciones.get(0);
        Transaccion copiaMayorValor = new Transaccion(mayorValor.id(), mayorValor.id_comprador(), mayorValor.id_vendedor(),mayorValor.monto());
        return copiaMayorValor;
    }

    @Override
    public Transaccion[] obtenerCopiaTransacciones() {
        Transaccion[] copiaTransacciones = new Transaccion[transacciones.size()];
        for (int i = 0; i < transacciones.size(); i++) {
            Transaccion thisTransaccion = transacciones.get(i);
            copiaTransacciones[i] = new Transaccion(
                thisTransaccion.id(), 
                thisTransaccion.id_comprador(), 
                thisTransaccion.id_vendedor(), 
                thisTransaccion.monto());
        }
        return copiaTransacciones;
    }

    @Override
    public float montoMedioBloque() {
        float montoMedio = 0f;
        if (cant_transacciones_no_creacion != 0){
            montoMedio = montoTotal / cant_transacciones_no_creacion;
        }
        return montoMedio;
    }

    @Override
    public Transaccion HackTransaccion() {
        return null;
    }
}
