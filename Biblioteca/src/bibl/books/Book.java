package bibl.books;

import java.util.Scanner;

public abstract class Book {
    private String title;
    private String author;
    private String isbn;
    private String genre;
    private int publicationYear;
    private int inventory;
    private boolean borrowed;

    public Book (String title, String author, String isbn, String genre, int publicationYear, int inventory) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.inventory = inventory;
        this.borrowed = false;
    }

    /*
    public void toReceive() {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Cuál es el título del libro?");
        this.title = sc.nextLine();

        System.out.println("¿Quién es el autor del libro?");
        this.author = sc.nextLine();

        System.out.println("¿Cuál es su código de identificación?");
        this.isbn = sc.nextLine();

        System.out.println("¿Cuál es el género del libro?");
        this.genre = sc.nextLine();

        System.out.println("¿Cuál es el año de publicación del libro?");
        this.publicationYear = sc.nextInt();
        sc.nextLine();

        System.out.println("¿Cuántas existencias hay del libro?");
        this.inventory = sc.nextInt();
        sc.nextLine();

        this.borrowed = false;
    } */

    public void available(int inventory, boolean borrowed){
        if(inventory > 0) {
            this.borrowed = borrowed;
        }}

    public void showInfo (){
        System.out.println("Título: " + this.title);
        System.out.println("Autor: " + this.author);
        System.out.println("ISBN: " + this.isbn);
        System.out.println("Género: " + this.genre);
        System.out.println("Año de publicación: " + this.publicationYear);
        System.out.println("Inventario: " + this.inventory);

        System.out.println("Estado: " + (this.borrowed ? "Prestado" : "Disponible"));
    }

    public boolean isBorrowed() {
        return borrowed;
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

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}

