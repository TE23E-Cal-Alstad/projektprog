// Cal Alstad
// Filen innehåller hjälpklass för http Get
package ca;

import java.net.URL;                //Håller webbadressen
import java.util.ArrayList;
import com.google.gson.reflect.TypeToken;
import kong.unirest.*;
import java.lang.reflect.Type;
import com.google.gson.*;

public class HttpHelper {

    //Hämtar text från URL och ger tbx text
    public static String getBooks() {
        try {
            //Gör om till URL objekt
            String  url = "http://10.151.168.5:3128/books" ;
            //Öppnar koppling till server
            HttpResponse<String> response = Unirest(url).asString();

            String json_data = response.getBody();
            //Sparar text läst från servern

            // ska hämta Böcker
            ArrayList<Books> books;

            // Skapa en typ som besrkiverArrayLirt<Books>
            Type typ_arr_books = new TypeToken<ArrayList<Books>>(){}.getType(); 

            Gson gson = new Gson();
            books = gson.fromJson(json_data, typ_arr_books);

        } catch (Exception e) {
            System.out.println("Fel vid GET: " + e.getMessage());
            return null; //Om något går fel säg att det inte gick
        }
    }
}