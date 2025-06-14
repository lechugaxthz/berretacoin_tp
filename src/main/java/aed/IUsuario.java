package aed;

public interface IUsuario {

    /**
     * @return devuelve el monto acumulado del usuario.
     */
    int getMonto() ;

    /**
     * Actualiza el monto del usuario
     * @param monto se suma el monto indicado (+/- monto)
     */
    void updateMonto(int monto);

    /**
     * @return devuelve el ID del usuario.
     */
    int getId();

    /**
     * @return la posicion del usuario en el Heap.
     */
    int getPosicionHeap();

    /**
     * actualiza la la nueva posicion del usuario en el heap (actualiza la variable).
     * @param posicionHeap nueva posicion del heap.
     */
    void updatePosicionHeap(int posicionHeap);
}
