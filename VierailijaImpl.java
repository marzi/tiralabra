/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pesonen
 */
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

    abstract public void vieraile(String avain, RadixPuuSolmu<V> vanhempi, RadixPuuSolmu<V> solmu);

}
