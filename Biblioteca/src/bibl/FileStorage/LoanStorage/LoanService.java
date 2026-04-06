package bibl.FileStorage.LoanStorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**Implementación del servicio de préstamos
 * Se encarga del historial y de realizar búsquedas administrativas.
 */
public class LoanService implements ILoanService {
    // Histórial de todos los préstamos (activos y devueltos).
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
    /**Filtra la lista para mostrar solo lo que todavía no ha regresado.
     */
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
    /**Análisis de datos simple para ver tendencias de la biblioteca.
     */
    @Override
    public void createLoanReport() {
        System.out.println("\n--- REPORTE ESTADÍSTICO DE PRÉSTAMOS ---");

        if (this.lendList.isEmpty()) {
            System.out.println("No hay datos suficientes para generar el reporte.");
            return;
        }

        System.out.println("Total histórico de transacciones: " + this.lendList.size());
// Lógica para encontrar el libro más popular
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

        // Usamos streams para un conteo rápido de los activos
        long actives = this.lendList.stream().filter(Loan::isActive).count();
        System.out.println("Préstamos pendientes de devolución: " + actives);
    }
    /**Busca un préstamo activo por el título del libro para marcar su devolución
     */
    @Override
    public void returnLoanByBookTitle(String title) {
        boolean found = false;

        for (Loan loan : this.lendList) {
            // Buscamos solo en los activos que coincidan con el título
            if (loan.isActive() && loan.getBook().getTitle().equalsIgnoreCase(title)) {
                loan.returnBook();
                found = true;
                break; // Terminamos al encontrar el primero
            }
        }

        if (!found) {
            throw new java.util.NoSuchElementException("No se encontro un prestamo activo para el libro: " + title);
        }
    }

    @Override
    public List<Loan> getLendList() {
        // Protegemos la lista para que no sea modificada externamente
        return Collections.unmodifiableList(lendList);
    }
}