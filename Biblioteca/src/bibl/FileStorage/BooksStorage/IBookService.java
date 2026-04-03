package bibl.FileStorage.BooksStorage;

import bibl.books.Book;
import java.util.List;

public interface IBookService {
    void addBook(Book book);
    void lookForBook(String wordOfSearch);
    void showBooks();
    Book findBookByTitle(String searchTitle);
    List<Book> getStock();
}