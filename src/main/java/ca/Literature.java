// Cal Alstad
// Filen innehåller föräldraklassen för biblioteksobjekten
package ca;

public class Literature {

    //Literature variables
    protected String id;
    protected String title;
    protected Boolean isAvailable;

    //Konstruktor för Literature
    public Literature (String id, String title, Boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.isAvailable = isAvailable;
    }

    //Getter-metod
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public Boolean getisAvailable() {
        return isAvailable;
    }

    //toString-metod
    @Override
    public String toString(){
        return "Literatur: Id-" + this.id + ", Title-" + this.title + ", Availabile-" + this.isAvailable;
    }
}
