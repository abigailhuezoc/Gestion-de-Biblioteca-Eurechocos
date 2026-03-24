package bibl.books;

public class PhysicalBook extends Book {
    private String shelfLocation;
    private CoverType coverType;


    public PhysicalBook(String title, String author, String isbn, String genre, int publicationYear, int inventory, int pageCount, String shelfLocation, CoverType coverType) {

        // 1. Enviamos todos los datos generales a la clase Book
        super(title, author, isbn, genre, publicationYear, inventory, pageCount);

        // 2. Usamos los setters de esta clase para validar los datos exclusivos de un libro físico
        this.setShelfLocation(shelfLocation);
        this.setCoverType(coverType);
    }


    // MÉTODOS
    @Override
    public void showInfo() {
        super.showInfo(); // Imprime título, autor, páginas, inventario, etc
        System.out.println("Ubicación en estante: " + this.shelfLocation);
        System.out.println("Tipo de cubierta: " + this.coverType);
        System.out.println("Tipo de libro: Físico");
    }


    // GETTERS

    public String getShelfLocation() {
        return shelfLocation;
    }

    public CoverType getCoverType() {
        return coverType;
    }


    // SETTERS CON VALIDACIONES

    public void setShelfLocation(String shelfLocation) {
        // Evitamos que registren un libro sin saber en qué pasillo o estante va
        if (shelfLocation != null && !shelfLocation.trim().isEmpty()) {
            this.shelfLocation = shelfLocation.trim();
        } else {
            System.out.println("Error: La ubicación en el estante no puede ser nula o estar vacía.");
        }
    }

    public void setCoverType(CoverType coverType) {
        if (coverType != null) {
            this.coverType = coverType;
        } else {
            System.out.println("Error: El tipo de cubierta no puede ser nulo.");
        }
    }
}