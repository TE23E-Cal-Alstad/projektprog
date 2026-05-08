// Cal Alstad
// Filen innehåller hjälpklass för http Get
package ca;

import java.io.BufferedReader;      //Läser text rad för rad
import java.io.InputStreamReader;   //Gör om bytes -> text
import java.net.HttpURLConnection;  //Kopplar upp mot server
import java.net.URL;                //Håller webbadressen

public class HttpHelper {

    //Hämtar text från URL och ger tbx text
    public static String get(String urlString) {
        try {
            //Gör om till URL objekt
            URL url = new URL(urlString); 
            //Öppnar koppling till server
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //säger att göra Get anropp
            conn.setRequestMethod("GET");

            //Skapar en läsare för texten servern skickar tbx
            BufferedReader läsare = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            //Sparar text läst från servern
            StringBuilder stringBuild = new StringBuilder();
            String rad;

            //Läser tills ingen mer text
            while ((rad = läsare.readLine()) != null) {
                stringBuild.append(rad); //Lägger till raden i text
            }

            läsare.close();
            return stringBuild.toString();

        } catch (Exception e) {
            System.out.println("Fel vid GET: " + e.getMessage());
            return null; //Om något går fel säg att det inte gick
        }
    }
}