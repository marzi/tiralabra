public interface Vierailija<V, T> {

    public void vieraile(String avain, RadixPuuSolmu<V> vanhempi, RadixPuuSolmu<V> solmu);

    public T getTulos();

}
