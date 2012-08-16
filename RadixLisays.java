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

    public V setArvo(V arvo) {
        this.arvo = arvo;
        return this.arvo;
    }

    public V getArvo() {
        return arvo;
    }

    public String getAvain() {
        return avain;
    }

    public String setAvain(String avain) {
        this.avain = avain;
        return this.avain;
    }

}
