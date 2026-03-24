package bibl.books;

public class DigitalBook extends Book {
    private String format;
    private double fileSizeMB;

    public DigitalBook(String title, String author, String isbn, String genre, int publicationYear, int inventory, int pageCount, String format, double fileSizeMB) {

        // 1. Enviamos todos los datos generales a la clase padre
        super(title, author, isbn, genre, publicationYear, inventory, pageCount);

        // 2. Usamos los setters de esta clase para los datos exclusivos de un libro digital
        this.setFormat(format);
        this.setFileSizeMB(fileSizeMB);
    }


    // MÉTODOS
    @Override
    public void showInfo() {
        super.showInfo(); // Llama a la información base (título, páginas, etc.)
        System.out.println("Formato: " + this.format);
        System.out.println("Tamaño del archivo: " + this.fileSizeMB + " MB");
        System.out.println("Tipo de libro: Digital");
    }


    // GETTERS


    public String getFormat() {
        return format;
    }

    public double getFileSizeMB() {
        return fileSizeMB;
    }


    // SETTERS CON VALIDACIONES


    public void setFormat(String format) {
        if (format != null && !format.trim().isEmpty()) {
            this.format = format.trim().toUpperCase(); // Guardamos en mayúsculas por estética (Ej: PDF)
        } else {
            System.out.println("Error: El formato digital no puede ser nulo o estar vacío.");
        }
    }

    public void setFileSizeMB(double fileSizeMB) {
        if (fileSizeMB > 0) {
            this.fileSizeMB = fileSizeMB;
        } else {
            System.out.println("Error: El tamaño del archivo debe ser mayor a 0 MB.");
        }
    }
}