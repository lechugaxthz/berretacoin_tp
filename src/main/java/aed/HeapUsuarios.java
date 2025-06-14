package aed;

import java.util.ArrayList;

public class HeapUsuarios implements IHeapUsuarios {

    private ArrayList<Usuario> heap;
    private ArrayList<Usuario> listaUsuarios;
    private int size; // tranquilamente esta variable se cambia por listaUsuarios.size(), pero ya está implementado.

    /**
     * Se inicia el heap de usuario a modo lineal (Igual que la lista) ya que no importa su posicion,
     * inician todos en 0 de monto.
     * Se agrega un mismo usuario a heap y listaUsuario ya que el mismo se actualizará mas facil siendo agarrado
     * por indice y no por busqueda en el heap.
     * @param cantUsuarios la cantidad de usuarios entrantes. van de usuario 1 a "n". reservando el 0 para admin.
     */
    public HeapUsuarios(int cantUsuarios){
        this.heap = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
        this.size = cantUsuarios;
        for (int i = 0; i < cantUsuarios; i++){
            Usuario nuevoUsuario = new Usuario(i+1, 0, i);
            this.heap.add(i, nuevoUsuario);
            this.listaUsuarios.add(i, nuevoUsuario);
        }
    }

    @Override
    public void actualizarMontoUsuario(int id_usuario, int monto) {
        this.listaUsuarios.get(id_usuario - 1).updateMonto(monto);
    }

    @Override
    public int getMaximoTenedor() {
        return heap.get(0).getId();
    }


    @Override
    public void shiftDown(int i){
        while(true) {
            int izq = (2 * i) + 1;
            int der = (2 * i) + 2;
            int mayor = i;
            if (izq < this.size && this.heap.get(mayor).compareTo(this.heap.get(izq)) > 0) {
                mayor = izq;
            }
            if (der < this.size && this.heap.get(mayor).compareTo(this.heap.get(der)) > 0) {
                mayor = der;
            }
            if (mayor == i) break;
            changeSites(i, mayor);
            i = mayor;
        }
    }

    @Override
    public void shiftUp(int i){
        while(i > 0){
            int padre = (i-1)/2;
            if(this.heap.get(i).compareTo(this.heap.get(padre)) < 0){
                changeSites(i, padre);
                i = padre;
            } else break;
        }
    }

    /**
     * Se "swappea" los valores padre e hijo
     * <br>
     * @param i indice padre
     * @param j indice hijo
     */
    private void changeSites(int i, int j){
        Usuario auxI = this.heap.get(i);
        Usuario auxJ = this.heap.get(j);
        int auxPosicionHeapI = auxI.getPosicionHeap();
        auxI.updatePosicionHeap(auxJ.getPosicionHeap());
        auxJ.updatePosicionHeap(auxPosicionHeapI);
        this.heap.set(i, auxJ);
        this.heap.set(j, auxI);
    }

    @Override
    public int getPosicionHeapUsuario(int id){
        return listaUsuarios.get(id - 1).getPosicionHeap();
    }
}
