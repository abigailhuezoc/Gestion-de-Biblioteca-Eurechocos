package bibl.books;

import bibl.books.Book;

public class DigitalBook extends Book {
    private String format;

    public DigitalBook(String title, String author, String isbn, String genre, int publicationYear, int inventory, String format, double fileSizeMB) {
        super(title, author, isbn, genre, publicationYear, inventory);
        this.setFormat(format);
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        if (format != null && !format.trim().isEmpty()) {
            this.format = format.trim().toUpperCase();
        } else {
            System.out.println("Error: El formato digital no puede ser nulo o estar vacío.");
        }
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Formato: " + this.format);
        System.out.println("Tipo de libro: Digital");
    }
}
