package aed;

import java.util.ArrayList;

public interface IBloque {
    /**
     * Se agrega la transaccion en sus 2 ArrayList.
     * <ul>
     *     <li>transacciones</li>
     *     <li>heapTransacciones</li>
     * </ul>
     * @param nuevasTransaccion transaccion a agregar al bloque.
     */
    void agregarTransaccion(Transaccion nuevasTransaccion);

    /**
     * Reordena con un heapSort(); (funcion privada que tendrá el bloque) el heap de transacciones.
     */
    void sortHeapTransacciones();

    /**
     * mediante un bucle, agregamos a una lista de longitud finita,
     * una copia de las transacciones ordenadas por su ID.
     * @return lista de transacciones ordenadas por ID.
     */

    /**
     * @return devuelve la primera transaccion del heap.
     */
    Transaccion maximaTransaccion();

    Transaccion[] obtenerCopiaTransacciones();

    /**
     * se "elimina" de los registros
     * <ul>
     *     <li>transacciones</li>
     *     <li>heapTransacciones</li>
     * </ul>
     * la primera transaccion del heapTransacciones en ambos.
     * posterior a esto, se ven afectados los montos de los usuarios.
     * @return la transaccion de mayor monto, estraida del bloque.
     */
    Transaccion HackTransaccion();

    /**
     * se divide el monto total del bloque por la cantidad de transacciones de NO creacion que hayan.
     * 
     * @return devuelve el monto medio del bloque
     */
    float montoMedioBloque();
}
