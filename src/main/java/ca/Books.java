// Cal Alstad
// Filen innehåller en barnklass till literaure som håller bokobjekt
package ca;

public class Books extends Literature{
   
    //Books variables
    private String author;
    private String genre;
    private int pages;

    //Konstruktor för subklassen Magazines
    public Books (String id, String title, Boolean isAvailable, String author, String genre, int pages) {

        //Super för att kalla in från föräldra klassen
        super(id, title, isAvailable );

        this.author = author;
        this.genre = genre;
        this.pages = pages;
    }

    @Override
    public String toString() {
        return super.toString() +
               ", Författare: " + author +
               ", Genre: " + genre +
               ", Sidor: " + pages;
    }
}
