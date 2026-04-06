package bibl.FileStorage.BooksStorage;

import bibl.books.Book;
import java.util.List;
/**Nuestro "contrato" de servicios.
 * Define qué puede hacer el sistema con los libros
 * Nos permite poder implementar una Base de Datos a futuro si quiseramos
 */
public interface IBookService {
    void addBook(Book book);
    void lookForBook(String wordOfSearch);
    void showBooks();
    Book findBookByTitle(String searchTitle);
    List<Book> getStock();
}