package bibl;

import bibl.books.Book;
import bibl.user.User;
import java.time.LocalDate;

public class Loan {
    private Book book;
    private User user;
    private LocalDate loanDate;
    private boolean isActive;

    public Loan(Book book, User user, LocalDate loanDate) {
        this.setBook(book);
        this.setUser(user);
        this.setLoanDate(loanDate);

        // Validamos si el proceso fue exitoso antes de imprimir el mensaje final
        if (this.isActive()) {
            System.out.println("Préstamo registrado exitosamente.");
        } else {
            System.out.println("Atención: El préstamo no pudo ser activado. Verifique los datos.");
        }
    }

    // MÉTODOS
    public void returnBook() {
        if (this.isActive() && this.getBook() != null) {
            this.getBook().toReturn(); // Devuelve el inventario en la clase Book
            this.setActive(false);
            System.out.println("Registro de préstamo cerrado. Libro devuelto.");
        } else {
            System.out.println("Este préstamo ya no esta vigente o el libro es nulo.");
        }
    }

    public void showLoanDetails() {
        // 1. Mostramos el Libro (validando que no sea nulo)
        if (this.book != null) {
            System.out.println("Libro prestado: " + this.book.getTitle());
        } else {
            System.out.println("Libro prestado: N/A");
        }

        // 2. Mostramos el Usuario (validando que no sea nulo)
        if (this.user != null) {
            System.out.println("Usuario: " + this.user.getName() + " " + this.user.getLastName());
        } else {
            System.out.println("Usuario: N/A");
        }

        // 3. Mostramos la Fecha (siempre existe por nuestro setter, no lo validamos)
        System.out.println("Fecha de préstamo: " + this.loanDate);

        // 4. Mostramos el Estado en texto
        if (this.isActive) {
            System.out.println("Estado: Activo");
        } else {
            System.out.println("Estado: Devuelto");
        }
    }

    // GETTERS
    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public boolean isActive() {
        return isActive;
    }

    // SETTERS
    public void setBook(Book book) {
        // Validamos que el libro exista y tenga inventario disponible
        if (book != null && !book.isBorrowed()) {
            this.book = book;
            this.book.toLend(); // Descuenta el inventario y actualiza el estado del libro
            this.setActive(true);
        } else {
            System.out.println("Error: El libro es nulo, no tiene inventario o ya esta prestado.");
            this.setActive(false);
        }
    }

    public void setUser(User user) {
        if (user != null) {
            this.user = user;
        } else {
            System.out.println("Error: El usuario proporcionado es nulo.");
            this.setActive(false);
        }
    }

    public void setLoanDate(LocalDate loanDate) {
        if (loanDate != null) {
            this.loanDate = loanDate;
        } else {
            // Si mandan la fecha nula por error, ponemos la fecha actual como respaldo
            this.loanDate = LocalDate.now();
        }
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
}