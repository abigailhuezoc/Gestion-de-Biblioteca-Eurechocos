package bibl.books;
/**
 * Clase base para cualquier libro del sistema.
 * Aplicamos abtracción porque no tiene sentido tener un "libro genérico";
 * o es físico o es digital.
 */
public abstract class Book {
    // Aplicamos ENCAPSULAMIENTO: Atributos privados para que nadie modifique el estado interno
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
// Lógica de negocio inicial: si no hay stock, nace como prestado.
        this.setBorrowed(this.inventory == 0);
    }
    /**
     * Lógica para prestar un libro
     * Resta una unidad y si llegamos a cero, cambia el estado a "prestado"
     */
    public void toLend() {
        if (this.inventory > 0) {
            this.inventory--;
            if (this.inventory == 0) {
                this.borrowed = true;
            }
        } else {
            // Si alguien intenta prestar sin stock, lanzamos error para no romper la lógica
            throw new IllegalStateException("Operación denegada: No hay inventario disponible para prestar.");
        }
    }
    /**
     * Para cuando devuelven el libro
     * Sumamos al stock y nos aseguramos de que ya no figure como "prestado"
     */
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

    // --- Getters ---
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public String getGenre() { return genre; }
    public int getPublicationYear() { return publicationYear; }
    public int getInventory() { return inventory; }
    public boolean isBorrowed() { return borrowed; }
    public int getPageCount() { return pageCount; }

    // --- Setters para validaciones ---
    //Encapsulamiento: Estas validaciones evitan que el objeto tenga datos basura
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
        // No se aceptan años negativos o cero
        if (publicationYear > 0) {
            this.publicationYear = publicationYear;
        } else {
            throw new IllegalArgumentException("El año de publicación debe ser mayor a 0.");
        }
    }

    public void setInventory(int inventory) {
        if (inventory >= 0) {
            this.inventory = inventory;
            // Sincronizamos el estado 'borrowed' con el stock real
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