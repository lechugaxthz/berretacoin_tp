package aed;

import java.util.ArrayList;

public class Bloque implements IBloque {
    private ArrayList<Transaccion> transacciones;
    private ArrayList<Transaccion> heapTransacciones;
    private int montoTotal;
    private int cant_transacciones_no_creacion;

    public Bloque() {
        this.transacciones = new ArrayList<>();
        this.heapTransacciones = new ArrayList<>();
        this.montoTotal = 0;
        this.cant_transacciones_no_creacion= 0;
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
        for (int i = (transacciones.size() / 2) - 1; i >= 0; i--) {
            shiftUpAndDown(i);
        }
    }

    /**
     * Quiza mal el nombre, pero compara con las posiciones Hijas en el heap para poder
     * verificar quien debe ir a la cabeza del heap.
     * @param i posicion del heap.
     */

    private void shiftUpAndDown(int i) {
        while(true) {
            int izq = (2 * i) + 1;
            int der = (2 * i) + 2;
            int mayor = i;
            if (izq < heapTransacciones.size()  && heapTransacciones.get(mayor).compareTo(heapTransacciones.get(izq)) > 0) {
                mayor = izq;
            }
            if (der < heapTransacciones.size() && heapTransacciones.get(mayor).compareTo(heapTransacciones.get(der)) > 0) {
                mayor = der;
            }
            if (mayor == i) break;
            changeSites(i, mayor);
            i = mayor;
        }
    }

    /**
     * cambia las posiciones de las transacciones en el heap
     * @param i transaccion menor
     * @param j transaccion mayor
     */
    private void changeSites(int i, int j){
        Transaccion aux = heapTransacciones.get(i);
        this.heapTransacciones.set(i, heapTransacciones.get(j));
        this.heapTransacciones.set(j, aux);
    }

    @Override
    public Transaccion maximaTransaccion() {
        Transaccion mayorValor = heapTransacciones.get(0);
        return new Transaccion(mayorValor.id(), mayorValor.id_comprador(), mayorValor.id_vendedor(),mayorValor.monto());
    }

    @Override
    public Transaccion[] obtenerCopiaTransacciones() {
        if (heapTransacciones.size() == 0) return new Transaccion[0];
        Transaccion[] copiaTransacciones = new Transaccion[heapTransacciones.size()];
        int posicion = 0;
        for (int i = 0; i < heapTransacciones.size(); i++) {
            Transaccion thisTransaccion = transacciones.get(posicion);
            if (thisTransaccion != null){
                copiaTransacciones[i] = new Transaccion(
                    thisTransaccion.id(), 
                    thisTransaccion.id_comprador(), 
                    thisTransaccion.id_vendedor(), 
                    thisTransaccion.monto());
            } else {
                i--;
            }
            posicion++;
        }
        return copiaTransacciones;
    }

    @Override
    public int montoMedioBloque() {
        int montoMedio = 0;
        if (cant_transacciones_no_creacion > 0){
            montoMedio = montoTotal / cant_transacciones_no_creacion;
        }
        return montoMedio;
    }

    @Override
    public Transaccion HackTransaccion() {
        Transaccion maxValor = heapTransacciones.get(0);
        heapTransacciones.remove(0);
        transacciones.set(maxValor.id(), null);
        shiftUpAndDown(0);
        montoTotal -= maxValor.monto();
        cant_transacciones_no_creacion -= 1;
        return maxValor;
    }
}
