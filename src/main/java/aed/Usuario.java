package aed;

public  class Usuario implements IUsuario, Comparable<Usuario> {
    private int id;
    private int monto;
    private int posicionHeap;

    public Usuario(int id, int monto, int posicionHeap){
        Usuario usuario = this;
        usuario.id = id;
        usuario.monto = monto;
        usuario.posicionHeap = posicionHeap;
    }

    public int getMonto(){
        return this.monto;
    }

    public void updateMonto(int monto){
        this.monto += monto;
    }

    public int getId(){
        return this.id;
    }

    public int getPosicionHeap(){
        return this.posicionHeap;
    }

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
    };
}