package bibl.FileStorage.LoanStorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoanService implements ILoanService {

    private List<Loan> lendList;

    public LoanService() {
        this.lendList = new ArrayList<>();
    }

    @Override
    public void registerLoan(Loan prestamo) {
        if (prestamo != null && prestamo.isActive()) {
            this.lendList.add(prestamo);
            System.out.println("Registro guardado exitosamente en el historial.");
        } else {
            throw new IllegalArgumentException("No se pudo registrar el préstamo: El objeto es nulo o está inactivo.");
        }
    }

    @Override
    public void showLendBooks() {
        System.out.println("\n--- LIBROS ACTUALMENTE PRESTADOS ---");
        boolean lendExistence = false;

        for (Loan loan : this.lendList) {
            if (loan.isActive()) {
                loan.showLoanDetails();
                System.out.println("-------------------------------------");
                lendExistence = true;
            }
        }

        if (!lendExistence) {
            System.out.println("Actualmente no hay ningún libro prestado en el sistema.");
        }
    }

    @Override
    public void createLoanReport() {
        System.out.println("\n--- REPORTE ESTADÍSTICO DE PRÉSTAMOS ---");

        if (this.lendList.isEmpty()) {
            System.out.println("No hay datos suficientes para generar el reporte.");
            return;
        }

        System.out.println("Total histórico de transacciones: " + this.lendList.size());

        int max = 0;
        String mostLendBook = "N/A";

        for (Loan currentLoan : this.lendList) {
            int count = 0;
            String currentTitle = currentLoan.getBook().getTitle();

            for (Loan comparisonLoan : this.lendList) {
                if (currentTitle.equalsIgnoreCase(comparisonLoan.getBook().getTitle())) {
                    count++;
                }
            }

            if (count > max) {
                max = count;
                mostLendBook = currentTitle;
            }
        }

        System.out.println("Libro más solicitado: " + mostLendBook + " (" + max + " veces)");

        long actives = this.lendList.stream().filter(Loan::isActive).count();
        System.out.println("Préstamos pendientes de devolución: " + actives);
    }

    public void returnLoanByBookTitle(String title) {
        boolean found = false;

        for (Loan loan : this.lendList) {
            if (loan.isActive() && loan.getBook().getTitle().equalsIgnoreCase(title)) {
                loan.returnBook();
                found = true;
                break;
            }
        }

        if (!found) {
            throw new java.util.NoSuchElementException("No se encontro un prestamo activo para el libro: " + title);
        }
    }

    @Override
    public List<Loan> getLendList() {
        return Collections.unmodifiableList(lendList);
    }
}