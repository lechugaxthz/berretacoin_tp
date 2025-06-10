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
     * Mas que un sort, utiliza otros llamados propios de un heap para actualizar
     * las posiciones de los "Usuarios" definidos posterior a su actualizado de montos
     * al hacer la insercion del "nuevo bloque"
     * <br>
     * se hace uso de funciones privadas para su funcionamiento:
     * shiftUpAndDown(), que llama a changeSites()
     * <br>
     * se actualiza el estado del Heap
     */
    void sortHeap();
}
