/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pesonen
 */
import java.util.Map;

public class RadixLisays<V> implements Map.Entry<String, V> {
    private String avain;
    private V arvo;
    public RadixLisays() {

    }
    public RadixLisays(String avain) {
        this.avain = avain;
    }

    public RadixLisays(String avain, V arvo) {
        this.avain = avain;
        this.arvo = arvo;
    }

    public V setValue(V arvo) {
        this.arvo = arvo;
        return this.arvo;
    }

    public V getValue() {
        return arvo;
    }

    public String getKey() {
        return avain;
    }

    public String setKey(String avain) {
        this.avain = avain;
        return this.avain;
    }

}
