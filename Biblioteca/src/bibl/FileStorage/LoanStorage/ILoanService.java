package bibl.FileStorage.LoanStorage;

import java.util.List;
/**Define las operaciones permitidas para la gestión de préstamos
 * Al usar una interfaz, garantizamos que cualquier implementación (memoria, DB, etc.)
 * cumpla con el flujo de registro, reporte y devolución.
 */
public interface ILoanService {
    void registerLoan(Loan prestamo);
    void showLendBooks();
    void createLoanReport();
    void returnLoanByBookTitle(String title);
    List<Loan> getLendList();
}