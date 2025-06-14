package aed;

public  class Usuario implements IUsuario, Comparable<Usuario> {
    private final int id;
    private int monto;
    private int posicionHeap;

    public Usuario(int id, int monto, int posicionHeap){
        this.id = id;
        this.monto = monto;
        this.posicionHeap = posicionHeap;
    }

    @Override
    public int getMonto(){
        return this.monto;
    }

    @Override
    public void updateMonto(int monto){
        this.monto += monto;
    }

    @Override
    public int getId(){
        return this.id;
    }

    @Override
    public int getPosicionHeap(){
        return this.posicionHeap;
    }

    @Override
    public void updatePosicionHeap(int posicionHeap){
        this.posicionHeap = posicionHeap;
    }

    @Override
    public int compareTo(Usuario usuario2){
        int difMonto = usuario2.getMonto() - monto;
        if (difMonto == 0){
            return id - usuario2.id;
        } else {
            return difMonto;
        }
    }
}