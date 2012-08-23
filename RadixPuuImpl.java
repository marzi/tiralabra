import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class RadixPuuImpl<V> implements RadixPuu<V> {

    private RadixPuuSolmu<V> juuri;

    private int koko;

    /** Luo RadixPuun, jossa vain juurisolmu **/
    public RadixPuuImpl() {
        juuri = new RadixPuuSolmu<V>();
        juuri.setAvain("");
        koko = 0;
    }

    public <R> void vieraile(String avain, Vierailija<V,R> vierailija) {
        if (juuri != null) {
            vieraile(avain, vierailija, null, juuri);
        }
    }

    private <R> void vieraile(String alkuosa, Vierailija<V,R> vierailija, RadixPuuSolmu<V> vanhempi, RadixPuuSolmu<V> solmu) {
        int sopivienMerkkienLkm = solmu.sopivienMerkkienLkm(alkuosa);

        if (sopivienMerkkienLkm == alkuosa.length() && sopivienMerkkienLkm == solmu.getAvain().length()) {
            vierailija.vieraile(alkuosa, vanhempi, solmu);
            //olemmeko juuressa?
        } else if (solmu.getAvain().equals("") == true || (sopivienMerkkienLkm < alkuosa.length() && sopivienMerkkienLkm >= solmu.getAvain().length())) {
            //vai käymmenkö läpi lapset?
            String uusi = alkuosa.substring(sopivienMerkkienLkm, alkuosa.length());
            for (RadixPuuSolmu<V> lapsi : solmu.getLapset()) {
            //rekursio
            vieraile(uusi, vierailija, solmu, lapsi);
            break;
            }
        }
    }
    
    public String taydenna(String alkuosa) {
        return taydenna(alkuosa, juuri, "");
    }

    private String taydenna(String avain, RadixPuuSolmu<V> solmu, String perusosa) {
        int i = 0;
        int avaimenpituus = avain.length();
        int solmunpituus = solmu.getAvain().length();

        while (i < avaimenpituus && i < solmunpituus) {
            if (avain.charAt(i) != solmu.getAvain().charAt(i)) {
                break;
            }
            i++;
        }
        if (i == avaimenpituus && i <= solmunpituus) {
            return perusosa + solmu.getAvain();
        }
 else if (solmunpituus == 0 || (i < avaimenpituus && i >= solmunpituus)) {
     String alku = avain.substring(0, i);
     String loppu = avain.substring(i, avaimenpituus);
     //Huom! Mahdollisesti korvataan
     for (RadixPuuSolmu<V> lapsi : solmu.getLapset()) {
         if (lapsi.getAvain().startsWith(loppu.charAt(0) + "")) {
             return taydenna(loppu, lapsi, perusosa + alku);
         }
     }
 }
        return "";
    }
    
    public boolean sisaltaa(String avain) {
        Vierailija<V,Boolean> vierailija = new VierailijaImpl<V,Boolean> (Boolean.FALSE) {
            public void vieraile(String avain, RadixPuuSolmu<V> vanhempi, RadixPuuSolmu<V> solmu) {
                setTulos(solmu.onkoTosi());
            }
        };
        
        vieraile(avain, vierailija);
        
        return vierailija.getTulos().booleanValue();
    }

    public int getKoko() {
        return koko;
    }

    public V loyda(String avain) {
        Vierailija<V,V> vierailija = new VierailijaImpl<V,V>() {
            public void vieraile(String avain, RadixPuuSolmu<V> vanhempi,
                    RadixPuuSolmu<V> solmu) {
                if (solmu.onkoTosi()==true)
                    setTulos(solmu.getArvo());
            }
        };

        vieraile(avain, vierailija);

        return vierailija.getTulos();
    }
    
    private RadixPuuSolmu<V> etsiAlkuosa(String avain, RadixPuuSolmu<V> solmu) {
        RadixPuuSolmu<V> tulos = null;
        
        int sopivienMerkkienLkm = solmu.sopivienMerkkienLkm(avain);
        
        if (sopivienMerkkienLkm == avain.length() && sopivienMerkkienLkm <= solmu.getAvain().length()) {
            tulos = solmu;
        } else if (solmu.getAvain().equals("") == true || (sopivienMerkkienLkm < avain.length() && sopivienMerkkienLkm >= solmu.getAvain().length())) {
            String uusi = avain.substring(sopivienMerkkienLkm, avain.length());
            for (RadixPuuSolmu<V> lapsi : solmu.getLapset()) {
                if (lapsi.getAvain().startsWith(uusi.charAt(0) + "")) {
                    tulos = etsiAlkuosa(uusi, lapsi);
                    break;
                }
            }
        }
        return tulos;
    }

    public boolean poista(String avain) {
        //Huom! Kesken, täydennetään
        Vierailija<V, Boolean> vierailija = new VierailijaImpl<V, Boolean>(Boolean.FALSE) {
            public void vieraile(String avain, RadixPuuSolmu<V> vanhempi, RadixPuuSolmu<V> solmu) {
                setTulos(solmu.onkoTosi());
                //jos oikea solmu
                if (solmu.onkoTosi() == true) {
                    //jos ei lapsia, niin poistetaan
                    //se vanhemman lapsilistalta
                    if (solmu.getLapset().size() == 0) {
                       Iterator<RadixPuuSolmu<V>> iteraattori = vanhempi.getLapset().iterator();
                        while (iteraattori.hasNext()) {
                            if (iteraattori.next().getAvain().equals(solmu.getAvain())) {
                                iteraattori.remove();
                                break;
                            }
                        }
                        if (vanhempi.getLapset().size() == 1 && vanhempi.onkoTosi() == false) {
                            
                        }
                    }
                }
            }
        }
    }

}
