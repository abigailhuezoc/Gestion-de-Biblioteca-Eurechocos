package bibl.FileStorage.BooksStorage;

import bibl.books.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**Esta clase es la implementación real de nuestro almacén de libros
 * Su misión es centralizar todo lo que tenga que ver con el inventario
 */
public class BookService implements IBookService {
    // Aplicamos ENCAPSULAMIENTO: La lista es privada para que nadie
    // borre libros desde fuera sin usar nuestros métodos.
    private List<Book> stock;

    public BookService() {
        // Elegimos ArrayList para las búsquedas frecuentes
        this.stock = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        // Validación preventiva para que el sistema no explote con nulos
        if (book != null) {
            this.stock.add(book);
            System.out.println("Libro agregado al catálogo: " + book.getTitle());
        } else {
            throw new IllegalArgumentException("No se puede agregar un libro nulo al sistema.");
        }
    }
    /**Buscador flexible
     * Pensamos en el usuario: no importa si escribe en mayúsculas o con espacios extra.
     */
    @Override
    public void lookForBook(String wordOfSearch) {
        if (wordOfSearch == null || wordOfSearch.trim().isEmpty()) {
            System.out.println("Error: Por favor ingrese un término de búsqueda válido.");
            return;
        }

        boolean found = false;
        // Normalizamos la búsqueda para que no importe si el usuario ingresa mayúsculas/minúsculas
        String termino = wordOfSearch.toLowerCase().trim();

        System.out.println("\n--- Resultados de búsqueda para: '" + wordOfSearch + "' ---");

        for (Book book : this.stock) {
            // Buscamos coincidencias tanto en título como en autor para practicidad.
            if (book.getTitle().toLowerCase().contains(termino) || book.getAuthor().toLowerCase().contains(termino)) {
                System.out.println("==========================================");
                //POLIMORFISMO: llamamos a showInfo() y se ejecutará
                // la versión específica (físico o digital) según toque.
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
    /**Búsqueda exacta de un libro.
     * Útil para procesos internos como préstamos donde necesitamos el objeto preciso
     */
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
        // Si llegamos aquí, es que el libro no existe. Lanzamos error para avisar al flujo.
        throw new java.util.NoSuchElementException("El libro '" + searchTitle + "' no existe.");
    }
    /**Seguridad de datos
     * Al devolver la lista, la resguardamos en 'unmodifiableList'.
     * Así, quien la pida puede leer los libros, pero NO puede borrar o añadir
     * nada saltándose el Service.
     */
    @Override
    public List<Book> getStock() {
        return Collections.unmodifiableList(stock);
    }
}