package bibl.books;
/**
 * Clase base para cualquier libro del sistema.
 * Es abstracta porque no tiene sentido tener un "libro genérico";
 * o es físico o es digital.
 */
public abstract class Book {

    private String title;
    private String author;
    private String isbn;
    private String genre;
    private int publicationYear;
    private int inventory;
    private boolean borrowed; // Nos dice si el libro está fuera de stock
    private int pageCount;


    public Book(String title, String author, String isbn, String genre, int publicationYear, int inventory, int pageCount) {
    // Usamos los setters para validar desde el principio
        this.setTitle(title);
        this.setAuthor(author);
        this.setIsbn(isbn);
        this.setGenre(genre);
        this.setPublicationYear(publicationYear);
        this.setInventory(inventory);
        this.setPageCount(pageCount);

        this.setBorrowed(this.inventory == 0);
    }


    public void toLend() {
        if (this.inventory > 0) {
            this.inventory--;
            if (this.inventory == 0) {
                this.borrowed = true;
            }
        } else {
            throw new IllegalStateException("Operación denegada: No hay inventario disponible para prestar.");
        }
    }

    public void toReturn() {
        this.inventory++;
        this.borrowed = false;
    }

    public void showInfo() {
        System.out.println("Título: " + this.title);
        System.out.println("Autor: " + this.author);
        System.out.println("ISBN: " + this.isbn);
        System.out.println("Género: " + this.genre);
        System.out.println("Año de publicación: " + this.publicationYear);
        System.out.println("Número de páginas: " + this.pageCount);
        System.out.println("Inventario: " + this.inventory);
        System.out.println("Estado: " + (this.borrowed ? "Prestado" : "Disponible"));
    }


    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public String getGenre() { return genre; }
    public int getPublicationYear() { return publicationYear; }
    public int getInventory() { return inventory; }
    public boolean isBorrowed() { return borrowed; }
    public int getPageCount() { return pageCount; }


    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title.trim();
        } else {
            // ¡ESTO ABORTA LA CREACIÓN!
            throw new IllegalArgumentException("El título no puede ser nulo o estar vacío.");
        }
    }

    public void setAuthor(String author) {
        if (author != null && !author.trim().isEmpty()) {
            this.author = author.trim();
        } else {
            throw new IllegalArgumentException("El autor no puede ser nulo o estar vacío.");
        }
    }

    public void setIsbn(String isbn) {
        if (isbn != null && !isbn.trim().isEmpty()) {
            this.isbn = isbn.trim();
        } else {
            throw new IllegalArgumentException("El ISBN no puede ser nulo o estar vacío.");
        }
    }

    public void setGenre(String genre) {
        if (genre != null && !genre.trim().isEmpty()) {
            this.genre = genre.trim();
        } else {
            throw new IllegalArgumentException("El género no puede ser nulo o estar vacío.");
        }
    }

    public void setPublicationYear(int publicationYear) {
        if (publicationYear > 0) {
            this.publicationYear = publicationYear;
        } else {
            throw new IllegalArgumentException("El año de publicación debe ser mayor a 0.");
        }
    }

    public void setInventory(int inventory) {
        if (inventory >= 0) {
            this.inventory = inventory;
            this.borrowed = (this.inventory == 0);
        } else {
            throw new IllegalArgumentException("El inventario no puede ser un número negativo.");
        }
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public void setPageCount(int pageCount) {
        if (pageCount > 0) {
            this.pageCount = pageCount;
        } else {
            throw new IllegalArgumentException("El número de páginas debe ser mayor a 0.");
        }
    }
}