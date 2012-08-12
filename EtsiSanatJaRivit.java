import java.io.*;
import java.util.Scanner;

/** Keskityin tällä viikolla tiedoston käsittelyyn ja sanojen etsintään sekä miten saan rivit laskettua ja 
*   tulostettua. Aloitin myös tietorakenteiden koodauksen mutta laitan ne vasta myöhemmin viikonlopun aikana 
*   GitHubiin koska ne ovat vielä jonkin verran keskeneräisiä ja haluan vielä muokata niitä **/

public class EtsiSanatJaRivit {
  private static Scanner lukija = new Scanner(System.in);
  private static String hakusana = "";
  private static String tiedostonNimi = "";
  
  private static String hakusana() {
     System.out.println("Anna hakusana");
     hakusana = lukija.nextLine();
     return hakusana;
  }

  private static String tiedostonNimi() {
     System.out.println("Minkä tiedoston "+hakusana+" rivit haluat nähdä?");
     tiedostonNimi = lukija.nextLine();
     return tiedostonNimi;
  }

  private static void tiedosto() throws FileNotFoundException {
     File tiedostoKahva = new File(tiedostonNimi);

     if (!tiedostoKahva.exists()) {
      System.out.println("Tiedostoa "+ tiedostonNimi +" ei löydy!");
      return;
     }

     Scanner syottotiedosto = new Scanner(tiedostoKahva);
     int riviNumero = 0;

     while (syottotiedosto.hasNextLine()) {
       riviNumero++;
       String rivi = syottotiedosto.nextLine();
       String apurivi = rivi.toLowerCase();
       if (apurivi.indexOf(hakusana.toLowerCase()) != -1)
         System.out.println(tiedostoKahva.getName()+": rivi "+riviNumero+": "+rivi);
     }

     syottotiedosto.close();
  }

   public static void main(String[] args) throws FileNotFoundException {
   
   //Pientä testausta, toimivatko metodit

       hakusana();
       tiedostonNimi();
       tiedosto();
       tiedostonNimi();
       tiedosto();

}
}
