import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

/** Ekalla viikolla keskityin tekem‰‰n yleisempi‰ osia ohjelmakoodista, koska en ollut
 *  viel‰ p‰‰tt‰nyt alanko toteuttaa sanaindeksointi vai regular expression-ohjelmaa **/

public class Sanatesti {
    private static Scanner lukija = new Scanner(System.in);
    private static String tiedostonNimi;
    private static File tiedosto;
    private static String hakusana;

    public static void main(String[] args) {
        System.out.println("Anna tekstitiedoston nimi, jonka haluat tulostaa ruudulle: ");
         tiedostonNimi = lukija.nextLine();
         tiedosto = new File(tiedostonNimi);
         
         try {
             Scanner tiedostolukija = new Scanner(tiedosto);
             while (tiedostolukija.hasNextLine()) {
             tiedosto = new File(tiedostonNimi);
             String rivi = tiedostolukija.nextLine();
             System.out.println(rivi);
             }
             tiedostolukija.close();
        }
         catch (FileNotFoundException e) {
             System.out.println("Tuli virhe: "+e.getMessage());
         }

         }
}
