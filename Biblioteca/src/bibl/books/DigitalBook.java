package bibl.books;
/***Clase que aplica HERENCIA extendiendo de Book.
 * Especialización para libros que viven en la nube o en formato digital.
 * Añadimos cosas de IT como el peso del archivo
 */
public class DigitalBook extends Book {

    private String format; // Ej: PDF, EPUB, MOBI
    private double fileSizeMB;


    public DigitalBook(String title, String author, String isbn, String genre, int publicationYear, int inventory, int pageCount, String format, double fileSizeMB) {
        // Primero resolvemos lo básico de la clase padre (Book)
        super(title, author, isbn, genre, publicationYear, inventory, pageCount);
        // Atributos específicos de lo digital
        this.setFormat(format);
        this.setFileSizeMB(fileSizeMB);
    }
    /**
     * Aplicamos POLIMORFISMO mediante Overriding.
     * Reutilizamos la info base de la clase padre e inteframos
     * los detalles técnicos del archivo.
     */
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Formato: " + this.format);
        System.out.println("Tamaño del archivo: " + this.fileSizeMB + " MB");
        System.out.println("Tipo de libro: Digital");
    }

    public String getFormat() {return format;}
    public double getFileSizeMB() {return fileSizeMB;}

    public void setFormat(String format) {
        if (format != null && !format.trim().isEmpty()) {
            // Normalizamos a MAYÚSCULAS para facilitar búsquedas o comparaciones.
            this.format = format.trim().toUpperCase();
        } else {
            throw new IllegalArgumentException("El formato digital no puede ser nulo o estar vacío.");
        }
    }

    public void setFileSizeMB(double fileSizeMB) {
        if (fileSizeMB > 0) {
            this.fileSizeMB = fileSizeMB;
        } else {
            throw new IllegalArgumentException("El tamaño del archivo debe ser mayor a 0 MB.");
        }
    }
}