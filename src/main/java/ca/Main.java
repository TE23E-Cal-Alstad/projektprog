// Cal Alstad
// Filen innehåller listorna och alla funktioner som användaren kan välja

package ca;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

     // 1. Två listor där vi sparar böcker och tidningar
    static ArrayList<Books> books = new ArrayList<>();
    static ArrayList<Magazines> magazines = new ArrayList<>();

    //2.Adressen till servern svarat i en variable
    static final String SERVER = "http://10.151.168.5:3128";
    public static void main(String[] args) {
            boolean running = true;
        
            //3. Programmet körs i loop
            while(running){
                //5. Meny 
                IO.println("\n ---Bibliotek---");
                IO.println("1. Hämta bok");
                IO.println("2. Hämta magazin");
                IO.println("3. Visa Böcker");
                IO.println("4. Visa magazin");
                IO.println("5. Lägg till bok");
                IO.println("6. Lägg till tidning");
                IO.println("7. Avsluta");
                int val = Integer.parseInt( IO.readln("Ange val: "));
          

            //4. Kolla användares val
            switch(val){
                case "1"-> hämtaBöcker();
                case "2" -> hämtaMagazin();
                case "3" -> visaBöcker();
                case "4" -> VisaMagazin();
                case "5" -> läggTillBok();
                case "6" -> läggTillMagazin();
                case "7" -> running = false;
                default -> IO.println("Fel: Ange ett nummer mellan 1-7");
            }
          }
    }
}