// Cal Alstad
// Filen innehåller hjälpklass för http Get
package ca;


import kong.unirest.*;


public class HttpHelper {

    //Hämtar text från URL (books) och ger tbx text
    public static String getBooks() {
        try {
            //Gör om till URL objekt
            String  url = "http://10.151.168.5:3128/books" ;
            //Öppnar koppling till server
            HttpResponse<String> response = Unirest.get(url).asString();

            String json_data = response.getBody();
            //Sparar text läst från servern

            return json_data; // Skickat tillbaka strängen
            


        } catch (Exception e) {
            System.out.println("Fel vid GET books: " + e.getMessage());
            return null; //Om något går fel säg att det inte gick
        }
    }

     //Hämtar text från URL (books) och ger tbx text
    public static String getMagazines() {
        try {
            //Gör om till URL objekt
            String  url = "http://10.151.168.5:3128/magazines" ;
            //Öppnar koppling till server
            HttpResponse<String> response = Unirest.get(url).asString();

            String json_data = response.getBody();
            //Sparar text läst från servern

           return json_data; // Skickat tillbaka strängen

        } catch (Exception e) {
            System.out.println("Fel vid GET magazines: " + e.getMessage());
            return null; //Om något går fel säg att det inte gick
        }
    }
}