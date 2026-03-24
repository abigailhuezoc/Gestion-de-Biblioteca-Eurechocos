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
    //page count

    public Book(String title, String author, String isbn, String genre, int publicationYear, int inventory) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setIsbn(isbn);
        this.setGenre(genre);
        this.setPublicationYear(publicationYear);
        this.setInventory(inventory);

        // El estado prestado se calcula automáticamente basándose en el inventario
        this.setBorrowed(inventory == 0);

        System.out.println("Libro creado exitosamente");
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

    /*public void available(int inventory, boolean borrowed){
        if(inventory > 0) {
            this.borrowed = borrowed;
        }}*/

    public void toLend() {
        if (this.inventory > 0) {
            this.inventory--;
            if (this.inventory == 0) {
                this.borrowed = true;
            }
        } else {
            System.out.println("Operación denegada: No hay inventario disponible.");
        }
    }

    public void toReturn() {
        this.inventory++;

        this.borrowed = false;
    }

    public void showInfo (){
        System.out.println("Título: " + this.title);
        System.out.println("Autor: " + this.author);
        System.out.println("ISBN: " + this.isbn);
        System.out.println("Género: " + this.genre);
        System.out.println("Año de publicación: " + this.publicationYear);
        System.out.println("Inventario: " + this.inventory);

        System.out.println("Estado: " + (this.borrowed ? "Prestado" : "Disponible"));
    }

    //GETTERS

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public String getGenre() { return genre; }
    public int getPublicationYear() { return publicationYear; }
    public int getInventory() { return inventory; }
    public boolean isBorrowed() { return borrowed; }

    //SETTERS

    public void setTitle(String title) {

        if (title != null && !title.trim().isEmpty()) {
            this.title = title.trim();
        } else {
            System.out.println("Error: El título no puede ser nulo o estar vacío.");
        }
    }

    public void setAuthor(String author) {
        if (author != null && !author.trim().isEmpty()) {
            this.author = author.trim();
        } else {
            System.out.println("Error: El autor no puede ser nulo o estar vacío.");
        }
    }

    public void setIsbn(String isbn) {
        if (isbn != null && !isbn.trim().isEmpty()) {
            this.isbn = isbn.trim();
        } else {
            System.out.println("Error: El ISBN no puede ser nulo o estar vacío.");
        }
    }

    public void setGenre(String genre) {
        if (genre != null && !genre.trim().isEmpty()) {
            this.genre = genre.trim();
        } else {
            System.out.println("Error: El género no puede ser nulo o estar vacío.");
        }
    }

    public void setPublicationYear(int publicationYear) {
        if (publicationYear > 0) {
            this.publicationYear = publicationYear;
        } else {
            System.out.println("Error: El año de publicación debe ser mayor a 0.");
        }
    }

    public void setInventory(int inventory) {
        if (inventory >= 0) {
            this.inventory = inventory;
            this.borrowed = (this.inventory == 0);
        } else {
            System.out.println("Error: El inventario no puede ser un número negativo.");
        }
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

}

