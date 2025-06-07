package aed;

public  class Usuario implements IUsuario, Comparable<Usuario> {
    private int id;
    private int monto;

    public Usuario(int id, int monto){
        Usuario usuario = this;
        usuario.id = id;
        usuario.monto = monto;
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

    @Override
    public int compareTo(Usuario usuario2){
        int difMonto = Float.compare(usuario2.getMonto(), this.getMonto());
        if (difMonto == 0){
            return (usuario2.id - this.id);
        } else {
            return difMonto;
        }
    };
}