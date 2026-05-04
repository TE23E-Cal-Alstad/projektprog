// Cal Alstad
// Filen innehåller en barnklass till literature som håller magazinobjekt
package ca;

public class Magazines extends Literature{
   
    //Magazines variables
    private int issueNumber;
    private String category;
    private int publishedYear;

    //Konstruktor för subklassen Magazines
    public Magazines (String id, String title, Boolean isAvailable, int issueNumber, String category, int publishedYear) {

        //Super för att kalla in från föräldra klassen
        super(id, title, isAvailable );

        this.issueNumber = issueNumber;
        this.category = category;
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return super.toString() +
               ", Nummer: " + issueNumber +
               ", Kategori: " + category +
               ", År: " + publishedYear;
    }

}
