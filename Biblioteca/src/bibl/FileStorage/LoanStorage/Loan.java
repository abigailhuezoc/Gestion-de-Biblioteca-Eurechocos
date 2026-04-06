package bibl.FileStorage.LoanStorage;

import bibl.books.Book;
import bibl.user.User;
import java.time.LocalDate;
/**Representa la unión entre un libro, un usuario y una fecha
 * Es el responsable de activar los procesos de salida y entrada del inventario
 */
public class Loan {
    private Book book;
    private User user;
    private LocalDate loanDate;
    private boolean isActive;

    public Loan(Book book, User user, LocalDate loanDate) {
        // Establecemos el usuario y la fecha primero
        this.setUser(user);
        this.setLoanDate(loanDate);
        // El setter del libro dispara la lógica de inventario, por eso va al final
        this.setBook(book);
        this.isActive = true;
    }
/**Finaliza el préstamo.
 * Es fundamental porque actualiza el estado del libro (Physical o Digital)
 * aprovechando el POLIMORFISMO de la clase Book.
 */
    public void returnBook() {
        if (!this.isActive) {
            throw new IllegalStateException("Error: Este préstamo ya ha sido devuelto.");
        }

        this.book.toReturn();// Notifica al libro que ha sido devulto
        this.isActive = false;
    }

    public void showLoanDetails() {
        System.out.println("----------------------------------------");
        System.out.println("Libro: " + (book != null ? book.getTitle() : "N/A"));
        System.out.println("Usuario: " + (user != null ? user.getName() + " " + user.getLastName() : "N/A"));
        System.out.println("Fecha: " + this.loanDate);
        System.out.println("Estado: " + (this.isActive ? "ACTIVO" : "DEVUELTO"));
        System.out.println("----------------------------------------");
    }
    // --- Setters con lógica de negocio (ENCAPSULAMIENTO) ---
    public void setBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo.");
        }
// Validación de seguridad: antes de asignar, verificamos que haya algo que prestar
        if (book.getInventory() <= 0) {
            throw new IllegalStateException("Inventario insuficiente: El libro '"
                    + book.getTitle() + "' no tiene copias disponibles.");
        }

        this.book = book;
        // Al asignar el libro al préstamo, automáticamente se resta del stock.
        this.book.toLend();
    }

    public void setUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo.");
        }
        this.user = user;
    }

    public void setLoanDate(LocalDate loanDate) {
        // Si no nos pasan fecha, asumimos que el préstamo es hoy mismo
        this.loanDate = (loanDate != null) ? loanDate : LocalDate.now();
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Book getBook() { return book; }
    public User getUser() { return user; }
    public LocalDate getLoanDate() { return loanDate; }
    public boolean isActive() { return isActive; }
}