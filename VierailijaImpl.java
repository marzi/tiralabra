public abstract class VierailijaImpl<V, T> implements Vierailija<V, T> {

    private T tulos;

    public VierailijaImpl() {
        this.tulos = null;
    }

    public VierailijaImpl(T alkuArvo) {
        this.tulos = alkuArvo;
    }

    public T getTulos() {
        return tulos;
    }
    
    public void setTulos(T tulos) {
        this.tulos = tulos;
    }

    abstract public void vieraile(String avain, RadixPuuSolmu<V> vanhempi, RadixPuuSolmu<V> solmu);

}
