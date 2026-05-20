// Cal Alstad
// Filen innehåller listorna och alla funktioner som användaren kan välja

package ca;

import java.util.ArrayList;
import java.util.Arrays;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.net.URL;                //Håller webbadressen
import kong.unirest.*;
import java.lang.reflect.Type;



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
                String val = System.console().readLine("Ange val: ");
          

            //4. Kolla användares val
            switch(val){
                case "1"-> {
                    String json = HttpHelper.getBooks();

                    if (json != null) {
                        Gson gson = new Gson();
                        Type typ_arr_books = new TypeToken<ArrayList<Books>>(){}.getType();
                        books = gson.fromJson(json, typ_arr_books);
                        System.out.println("Böcker har hämtats från servern!");
                    }
                    
                }
                case "2" -> {
                    String json = HttpHelper.getMagazines();
                    
                    if (json != null) {
                        Gson gson = new Gson();
                        Type typ_arr_magazine = new TypeToken<ArrayList<Magazines>>(){}.getType(); 
                        magazines = gson.fromJson(json, typ_arr_magazine);
                        System.out.println("Tidningar har hämtats!");
                    }
                }
                case "3" -> {
                    System.out.println("\n--- Alla Böcker ---");
                    for (Books b : books) {
                    System.out.println(b);
                    }
                }
                case "4" -> {
                    System.out.println("\n--- Alla Tidningar ---");
                    for (Magazines m : magazines) {
                    System.out.println(m);
                    }
                }
                case "5" -> {
                    //Lägger till ett nytt objekt direkt i books-listan
                    try {
                        String id = System.console().readLine("ID: ");
                        String titel = System.console().readLine("Titel: ");
                        String forfattare = System.console().readLine("Författare: ");
                        String genre = System.console().readLine("Genre (Crime, Drama, Mystery, Adventure, Romance, Fantasy, Thriller och Science Fiction): ");
                        int sidor = Integer.parseInt(System.console().readLine("Sidor: "));

                        books.add(new Books(id, titel, true, forfattare, genre, sidor));
                        System.out.println("Boken sparad lokalt i listan!");
                    } catch (NumberFormatException e) {
                        System.out.println("Fel: Du måste ange ett heltal (siffror) för antal sidor. Försök igen.");
                    }
                }
                case "6" -> {
                    // Lägger till ett nytt objekt direkt i magazines-listan
                   try {
                        String id = System.console().readLine("ID: ");
                        String titel = System.console().readLine("Titel: ");
                        int nummer = Integer.parseInt(System.console().readLine("Nummer: "));
                        String kategori = System.console().readLine("Kategori: ");
                        int ar = Integer.parseInt(System.console().readLine("År: "));

                        magazines.add(new Magazines(id, titel, true, nummer, kategori, ar));
                        System.out.println("Tidningen sparad lokalt i listan!");
                    } catch (NumberFormatException e) {
                        System.out.println("Fel: Du måste ange heltal (siffror) för Nummer och År. Försök igen.");
                    }
                }
                case "7" -> running = false;
                default -> System.out.println("Fel: Ange ett nummer mellan 1-7");
            }
          }
    }
}