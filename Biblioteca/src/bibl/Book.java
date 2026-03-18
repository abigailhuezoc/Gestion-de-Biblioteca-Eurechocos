package bibl;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private String genre;
    private int publicationYear;
    private int inventory;
    private boolean borrowed;

    public Book (String title, String author,  String isbn, String genre, int publicationYear, int inventory){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.inventory = inventory;
        this.borrowed = false;
        
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getGenre() {
        return genre;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public int getInventory() {
        return inventory;
    }
    public boolean isBorrowed(){
        return borrowed;
    }

    
    public void setTitle(String title){
        this.title =title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setIsbn(String isbn){
        this.isbn=isbn;
    }
    public void setGenre(String genre){
        this.genre=genre;
    }
    public void setPublicationYear(int publicationYear){
        this.publicationYear= publicationYear;
    }
    public void setInventory(int inventory){
        this.inventory=inventory;
    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
    public void toLend() {
        if (!borrowed) {
            borrowed = true;
            System.out.println("El libro '" + title + "' ha sido prestado.");
        } else {
            System.out.println("El libro '" + title + "' ya está prestado.");
        }
    }
    public void toReturn() {
        if (borrowed) {
            borrowed = false;
            System.out.println("El libro '" + title + "' ha sido devuelto.");
        } else {
            System.out.println("El libro '" + title + "' no estaba prestado.");
        }
    public void showInfo() {
        System.out.println("Título: " + title);
        System.out.println("Autor: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Género: " + genre);
        System.out.println("Año: " + publicationYear);
        System.out.println("Estado: " + (borrowed ? "Prestado" : "Disponible"));
        System.out.println("Inventario: " + inventory);
    }
    
}
