package bibl.FileStorage.LoanStorage;

import java.util.List;

public interface ILoanService {
    void registerLoan(Loan prestamo);
    void showLendBooks();
    void createLoanReport();
    void returnLoanByBookTitle(String title);
    List<Loan> getLendList();
}