package aed;

public interface IHeapUsuarios {

    /**
     * Se actualiza el usuario en listaUsuario, posicionado en id_usuario - 1;
     * @param id_usuario posicion de usuario en - 1
     * @param monto cantidad (+/-) a agregar
     */
    void actualizarMontoUsuario(int id_usuario, int monto);

    /**
     * Llama al primero en la posicion del Heap
     * @return Usuario
     */
    int getMaximoTenedor();

    /**
     * Se verifica bloque por bloque, a modode. primero comparo y verifico si "este" usuario está en orden
     * <br>
     * De no estarlo, se eleva el "primer" correspondiente.
     * <br>
     * Posterior a eso, se vuelve a comparar con el otro restante a ver si quedaron en orden.
     * (no se evita la comparacion con los otros nuevamente...).
     * <br>
     * se hace uso de izq y der, refiriendo a los hijos izquierdo y derecho del
     * supuesto "mayor" (i actual)
     * @param i indice por el que se parte con la comparacion entre usuarios.
     */
    void shiftDown(int i);

    /**
     * Se ve comparan, de existir, el nodo hijo con el nodo padre o, sucesor mas cercano.
     * <br>
     * Dado el caso (nodo padre es menor en comparacion al nodo hijo).
     * Se cambian las posiciones del mismo y se vuelve nuevamente, mediante el bucle,
     * a realizar la misma comparacion el la sigueinte posicion padre/sucesor.
     * <br>
     * En caso de que esta comparacion no resulte, se termina el ciclo, o, en caso de
     * que el nodo "hijo" termine siendo la raiz, ya cierra su ejecucion.
     * @param i posicion del nodo a elevar en posicion.
     */
    void shiftUp(int i);

    /**
     * obtiene una propiedad de Usuario, que es la posicion actual en el Heap.
     * @param id ID del usuario.
     * @return posicion en el heap.
     */
    int getPosicionHeapUsuario(int id);
}
