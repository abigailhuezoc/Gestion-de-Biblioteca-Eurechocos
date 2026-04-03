package bibl.FileStorage.LoanStorage;

import bibl.books.Book;
import bibl.user.User;
import java.time.LocalDate;

public class Loan {
    private Book book;
    private User user;
    private LocalDate loanDate;
    private boolean isActive;

    public Loan(Book book, User user, LocalDate loanDate) {
        this.setUser(user);
        this.setLoanDate(loanDate);
        this.setBook(book);
        this.isActive = true;
    }

    public void returnBook() {
        if (!this.isActive) {
            throw new IllegalStateException("Error: Este préstamo ya ha sido devuelto.");
        }

        this.book.toReturn();
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

    public void setBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo.");
        }

        if (book.getInventory() <= 0) {
            throw new IllegalStateException("Inventario insuficiente: El libro '"
                    + book.getTitle() + "' no tiene copias disponibles.");
        }

        this.book = book;
        this.book.toLend();
    }

    public void setUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo.");
        }
        this.user = user;
    }

    public void setLoanDate(LocalDate loanDate) {
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