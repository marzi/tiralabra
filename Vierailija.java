/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pesonen
 */
public interface Vierailija<V, T> {

    public void vieraile(String avain, RadixPuuSolmu<V> vanhempi, RadixPuuSolmu<V> solmu);

    public T getTulos();

}
