package bibl.books;

public class PhysicalBook extends Book {

    private String shelfLocation;
    private CoverType coverType;


    public PhysicalBook(String title, String author, String isbn, String genre, int publicationYear, int inventory, int pageCount, String shelfLocation, CoverType coverType) {
        super(title, author, isbn, genre, publicationYear, inventory, pageCount);

        this.setShelfLocation(shelfLocation);
        this.setCoverType(coverType);
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Ubicación en estante: " + this.shelfLocation);
        System.out.println("Tipo de cubierta: " + this.coverType);
        System.out.println("Tipo de libro: Físico");
    }

    public String getShelfLocation() {return shelfLocation;}
    public CoverType getCoverType() {return coverType;}


    public void setShelfLocation(String shelfLocation) {
        if (shelfLocation != null && !shelfLocation.trim().isEmpty()) {
            this.shelfLocation = shelfLocation.trim();
        } else {
            throw new IllegalArgumentException("La ubicación en el estante no puede ser nula o estar vacía.");
        }
    }

    public void setCoverType(CoverType coverType) {
        if (coverType != null) {
            this.coverType = coverType;
        } else {
            throw new IllegalArgumentException("El tipo de cubierta no puede ser nulo.");
        }
    }
}