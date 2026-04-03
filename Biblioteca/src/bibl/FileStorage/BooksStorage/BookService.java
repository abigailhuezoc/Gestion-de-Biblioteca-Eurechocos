package bibl.FileStorage.BooksStorage;

import bibl.books.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookService implements IBookService {

    private List<Book> stock;

    public BookService() {
        this.stock = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        if (book != null) {
            this.stock.add(book);
            System.out.println("Libro agregado al catálogo: " + book.getTitle());
        } else {
            throw new IllegalArgumentException("No se puede agregar un libro nulo al sistema.");
        }
    }

    @Override
    public void lookForBook(String wordOfSearch) {
        if (wordOfSearch == null || wordOfSearch.trim().isEmpty()) {
            System.out.println("Error: Por favor ingrese un término de búsqueda válido.");
            return;
        }

        boolean found = false;
        String termino = wordOfSearch.toLowerCase().trim();

        System.out.println("\n--- Resultados de búsqueda para: '" + wordOfSearch + "' ---");

        for (Book book : this.stock) {
            if (book.getTitle().toLowerCase().contains(termino) || book.getAuthor().toLowerCase().contains(termino)) {
                System.out.println("==========================================");
                book.showInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No se encontraron coincidencias en el catálogo.");
        }
    }

    @Override
    public void showBooks() {
        for (Book book : this.stock) {
            System.out.println("=====================================");
            book.showInfo();
        }
    }

    @Override
    public Book findBookByTitle(String searchTitle) {
        if (searchTitle == null || searchTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("El titulo de busqueda no puede estar vacio.");
        }

        for (Book book : this.stock) {
            if (book.getTitle().equalsIgnoreCase(searchTitle)) {
                return book;
            }
        }
        throw new java.util.NoSuchElementException("El libro '" + searchTitle + "' no existe.");
    }

    @Override
    public List<Book> getStock() {
        return Collections.unmodifiableList(stock);
    }
}