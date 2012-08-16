/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pesonen
 */
import java.util.ArrayList;
import java.util.List;

public class RadixPuuSolmu<V> {

    private String avain;
    private List<RadixPuuSolmu<V>> lapset;
    private V arvo;
    private boolean tosi;
    private RadixPuuSolmu<V> seurSolmu;
    private RadixPuuSolmu<V> ekaLapsi;
    private int lastenKoko;

    public RadixPuuSolmu() {
        avain = "";
        lapset = new ArrayList<RadixPuuSolmu<V>>();
        tosi = false;
    }

    public V getArvo() {
        return arvo;
    }

    public void setArvo(V arvo) {
        this.arvo = arvo;
    }

    public String getAvain() {
        return avain;
    }

    public void setAvain(String avain) {
        this.avain = avain;
    }

    public boolean onkoTosi() {
        return tosi;
    }

    public void setTosi(boolean tosi) {
        this.tosi = tosi;
    }

    public List<RadixPuuSolmu<V>> getLapset() {
        return lapset;
    }

    public void setLapset(List<RadixPuuSolmu<V>> lapset) {
        this.lapset = lapset;
    }

    public int sopivienMerkkienLkm(String avain) {
        int sopivienMerkkienLkm = 0;
        //pitääkö olla this?
        while (sopivienMerkkienLkm < avain.length() && sopivienMerkkienLkm < getAvain().length()) {
           if (avain.charAt(sopivienMerkkienLkm) != getAvain().charAt(sopivienMerkkienLkm)) {
               break; //lopetetaan kaikki
           }
           sopivienMerkkienLkm++; //lisätään joka kierroksella
        }
        return sopivienMerkkienLkm;
    }

    public String toString() {
        return avain;
    }

}
