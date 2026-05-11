// Cal Alstad
// Filen innehåller listorna och alla funktioner som användaren kan välja

package ca;

import java.util.ArrayList;
import java.util.Arrays;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;


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
                
                System.out.println("\n ---Bibliotek---");
                System.out.println("1. Hämta bok");
                System.out.println("2. Hämta magazin");
                System.out.println("3. Visa Böcker");
                System.out.println("4. Visa magazin");
                System.out.println("5. Lägg till bok");
                System.out.println("6. Lägg till tidning");
                System.out.println("7. Avsluta");
                int val = Integer.parseInt( System.out.readln("Ange val: "));
          

            //4. Kolla användares val
            switch(val){
                case "1"-> {
                    HttpHelper.getBooks();
                    /*
                     Skapa en typ som besrkiverArrayLirt<Books>
                    Type typ_arr_books = new TypeToken<ArrayList<Books>>(){}.getType(); 
                            Gson gson = new Gson();
                        ArrayList<Books>    books = gson.fromJson(json_data, typ_arr_books);
                */
                }
                case "2" -> getMagazines();
                case "3" -> visaBöcker();
                case "4" -> VisaMagazin();
                case "5" -> läggTillBok();
                case "6" -> läggTillMagazin();
                case "7" -> running = false;
                default -> System.out.println("Fel: Ange ett nummer mellan 1-7");
            }
          }

    }
}