public class RadixPuuSolmu<V> {

    private String avain;
    private V arvo;
    private boolean tosi;
    private RadixPuuSolmu<V> seurSolmu;
    private RadixPuuSolmu<V> ekaLapsi;
    private int lastenKoko;

    public RadixPuuSolmu() {

    }

    public void setAvain(String avain) {
        this.avain = avain;
    }

    public void setTosi(boolean tosi) {
        this.tosi = tosi;
    }

}