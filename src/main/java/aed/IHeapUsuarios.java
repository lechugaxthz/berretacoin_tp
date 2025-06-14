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

}
