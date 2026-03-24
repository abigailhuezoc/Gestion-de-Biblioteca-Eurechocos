package bibl.services;

import bibl.Loan;
import java.util.ArrayList;
import java.util.List;

public class LoanService {
    // Lista que guardara el historial de todos los préstamos
    private List<Loan> listaPrestamos;

    // Constructor
    public LoanService() {
        this.listaPrestamos = new ArrayList<>();
    }

    // Metodo para guardar el prestamo en el historial después de crearlo
    public void registrarPrestamo(Loan prestamo) {
        // Solo lo agregamos si existe y si el prestamo fue exitoso
        if (prestamo != null && prestamo.isActive()) {
            this.listaPrestamos.add(prestamo);
            System.out.println("Registro guardado en el historial de prestamos.");
        } else {
            System.out.println("Error: No se pudo guardar el registro. El prestamo es nulo o inactivo.");
        }
    }

    // MÉTODOS DE REPORTE

    // Ver libros actualmente prestados
    public void verLibrosPrestados() {
        boolean hayPrestamos = false;
        System.out.println("\n--- LISTA DE LIBROS ACTUALMENTE PRESTADOS ---");

        for (Loan prestamo : this.listaPrestamos) {
            // Filtramos unicamente los préstamos que siguen activos
            if (prestamo.isActive()) {
                System.out.println("Libro: " + prestamo.getBook().getTitle());
                System.out.println("   -> Usuario: " + prestamo.getUser().getName() + " " + prestamo.getUser().getLastName());
                System.out.println("   -> Fecha de prestamo: " + prestamo.getLoanDate());
                System.out.println("-------------------------------------------------");
                hayPrestamos = true;
            }
        }

        if (!hayPrestamos) {
            System.out.println("Actualmente no hay ningún libro prestado en el sistema.");
        }
    }

    // HU-08: Reporte estadístico de préstamos
    public void generarReportePrestamos() {
        System.out.println("\n--- REPORTE GENERAL DE PRESTAMOS ---");

        int totalPrestamos = this.listaPrestamos.size();

        // Si la lista está vacía, no hay nada que reportar
        if (totalPrestamos == 0) {
            System.out.println("Aun no se ha registrado ningun prestamo en el sistema.");
            return;
        }

        System.out.println("Total de prestamos registrados historicamente: " + totalPrestamos);

        // Variables para encontrar el libro más prestado
        int maxCantidad = 0;
        String libroMasPrestado = "Ninguno";

        // Ciclo simple para contar cuantas veces aparece cada libro en el historial
        for (Loan prestamoA : this.listaPrestamos) {
            int contadorActual = 0;
            String tituloActual = prestamoA.getBook().getTitle();

            // Comparamos el título actual contra todos los demás en la lista
            for (Loan prestamoB : this.listaPrestamos) {
                if (tituloActual.equalsIgnoreCase(prestamoB.getBook().getTitle())) {
                    contadorActual++;
                }
            }

            // Si el libro actual tiene más préstamos que nuestro record anterior, lo actualizamos
            if (contadorActual > maxCantidad) {
                maxCantidad = contadorActual;
                libroMasPrestado = tituloActual;
            }
        }

        System.out.println("Libro mas popular: '" + libroMasPrestado + "' (Prestado " + maxCantidad + " veces)");

        // Extra: Contamos cuantos préstamos siguen activos en este momento
        int activos = 0;
        for (Loan p : this.listaPrestamos) {
            if (p.isActive()) {
                activos++;
            }
        }
        System.out.println("Prestamos actualmente activos (sin devolver): " + activos);
    }

    // GETTERS
    public List<Loan> getListaPrestamos() {
        return listaPrestamos;
    }
}