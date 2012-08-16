/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pesonen
 */
import java.util.LinkedList;

public class RadixHakutulos<V> {
    private LinkedList<RadixPuuSolmu<V>> loytoLista;
    private LinkedList<String> loytoKokoAvain;
    private RadixPuuSolmu<V> osaLoyto;
    private int vikaNumLoytoChar;
    private boolean taysinSama;
    private RadixPuuSolmu<V> vikaYritys;
    private String vikaLoytoAvain;
    private RadixPuuSolmu<V> aiempiSolmu;
    private boolean kuuluuEnnen;
    private RadixPuuSolmu<V> vanhempi;

    public RadixHakutulos() {
        loytoLista = new LinkedList<RadixPuuSolmu<V>>();
        loytoKokoAvain = new LinkedList<String>();
        taysinSama = false;
    }
}
