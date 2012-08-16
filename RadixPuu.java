/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pesonen
 */
import java.util.ArrayList;

/** Interface-luokka RadixPuulle, joka tullaan
 * toteuttamaan implementointi-luokassa **/

public interface RadixPuu<V> {
    
    public void aseta(String avain, V arvo);

    /** Poistetaan avain ja sen arvo puusta **/
    public boolean poista(String avain);

    /** Etsitaan avaimen arvo **/
    public V loyda(String avain);

    /** Tarkistaa, sisältääkö puu kyseistä avainta **/
    public boolean sisaltaa(String avain);

    /** Etsii alkuosan annetun raja-arvon sisältä **/
    //vielä kesken, täydennetään
    public ArrayList<V> etsiAlkuosa(String alkuosa, int rajaArvo);

    /** Palauttaa RadixPuun koon **/
    public int getKoko();

    /** Täydentää alkuosan siihen kohtaan jossa se alkaa
     * jakaantua eri sanoiksi
     * @param alkuosa saa arvoksi esim. au ja puu sisältää
     * sanat auto ja automaattinen
     * @return palauttaisi au-tapauksessa sanan auto
     */
    public String taydenna(String alkuosa);

}
