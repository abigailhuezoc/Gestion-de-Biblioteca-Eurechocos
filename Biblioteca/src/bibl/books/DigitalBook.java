package bibl.books;

public class DigitalBook extends Book {

    private String format;
    private double fileSizeMB;


    public DigitalBook(String title, String author, String isbn, String genre, int publicationYear, int inventory, int pageCount, String format, double fileSizeMB) {
        super(title, author, isbn, genre, publicationYear, inventory, pageCount);

        this.setFormat(format);
        this.setFileSizeMB(fileSizeMB);
    }


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