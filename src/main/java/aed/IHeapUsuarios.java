package aed;

public interface IHeapUsuarios {
    void actualizarMontoUsuario(int id_usuario, int monto);
    int getMaximoTenedor();
    void sortHeap();
}
