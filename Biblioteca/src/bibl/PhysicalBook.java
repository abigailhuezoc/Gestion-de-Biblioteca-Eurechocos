package bibl;

public class PhysicalBook extends Book {
    private String shelfLocation;
    private int pageCount;

    public PhysicalBook(String title, String author, String isbn, String genre, int publicationYear, int inventory, String shelfLocation, int pageCount) {
        super(title, author, isbn, genre, publicationYear, inventory);
        
        this.shelfLocation = shelfLocation;
        this.pageCount = pageCount;
    }

    public String getShelfLocation() {
        return shelfLocation;
    }

    public void setShelfLocation(String shelfLocation) {
        this.shelfLocation = shelfLocation;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Ubicación en el estante: " + shelfLocation);
        System.out.println("Número de páginas: " + pageCount);
        System.out.println("Tipo de libro: físico");
    }
}