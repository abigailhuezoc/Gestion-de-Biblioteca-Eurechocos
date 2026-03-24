package bibl;

import bibl.books.Book;
import bibl.user.User;

import java.util.Date;

public class Loan {
    private Book book;
    private User user;
    private Date loanDate;
    private boolean isActive;

    public Loan(Book book, User user, Date loanDate) {

        if (book == null || user == null) {
            System.out.println("Error: Datos insuficientes para crear el prestamo.");
            this.isActive = false;
            return;
        }

        if (!book.isBorrowed()) {
            this.book = book;
            this.user = user;
            this.loanDate = loanDate;
            this.isActive = true;

            this.book.toLend();
            System.out.println("Prestamo registrado correctamente en el sistema.");
        } else {
            System.out.println("No se puede realizar el prestamo: El libro ya esta ocupado.");
            this.isActive = false;
        }
    }

    public void returnBook() {
        if (this.isActive && this.book != null) {
            this.book.toReturn();
            this.isActive = false;
            System.out.println("Registro de prestamo cerrado.");
        } else {
            System.out.println("Este prestamo ya no esta vigente o el libro es nulo.");
        }
    }

    // Getters para reportes y administración
    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public boolean isActive() {
        return isActive;
    }
}