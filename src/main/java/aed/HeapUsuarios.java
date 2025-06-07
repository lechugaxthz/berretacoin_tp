package aed;

import java.util.ArrayList;

public class HeapUsuarios implements IHeapUsuarios {

    private ArrayList<Usuario> heap;

    public HeapUsuarios(int cantUsuarios){
        HeapUsuarios heapUsuarios = this;
        heapUsuarios.heap = new ArrayList<Usuario>();
        for (int i = 0; i < cantUsuarios; i++){
            heapUsuarios.heap.add(i, new Usuario(i+1, 0));
        }
    };

    @Override
    public void actualizarMontoUsuario(int id_usuario, int monto) {
        heap.get(id_usuario - 1).updateMonto(monto);
    }

    @Override
    public int getMaximoTenedor() {
        return heap.get(0).getId();
    }

    @Override
    public void sortHeap() {
        this.heap.sort((u1, u2) -> u1.compareTo(u2));
    };
}
