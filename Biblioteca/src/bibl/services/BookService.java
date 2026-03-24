package bibl.services;

import bibl.books.Book;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    // Aquí guardaremos todos los libros físicos y digitales usando polimorfismo
    private List<Book> inventario;

    // Constructor
    public BookService() {
        this.inventario = new ArrayList<>();
    }

    // Metodo para agregar libros a esta lista desde el Main
    public void agregarLibro(Book libro) {
        if (libro != null) {
            this.inventario.add(libro);
            System.out.println("Libro agregado al catalogo: " + libro.getTitle());
        } else {
            System.out.println("Error: No se puede agregar un libro nulo al sistema.");
        }
    }

    // MÉTODOS DE BÚSQUEDA

    // Buscar libro por titulo o autor
    public void buscarLibro(String terminoBusqueda) {
        // 1. Validamos que la busqueda no sea nula o puros espacios
        if (terminoBusqueda == null || terminoBusqueda.trim().isEmpty()) {
            System.out.println("Error: Por favor ingrese un termino de busqueda valido.");
            return; // Corta el metodo aqui para no hacer busquedas vacias
        }

        boolean encontrado = false;
        // Convertimos a minusculas para que coincida sin importar como escriba el usuario
        String termino = terminoBusqueda.toLowerCase().trim();

        System.out.println("\n--- Resultados de busqueda para: '" + terminoBusqueda + "' ---");

        for (Book libro : this.inventario) {
            // Buscamos coincidencias parciales (.contains) en titulo o autor
            if (libro.getTitle().toLowerCase().contains(termino) || libro.getAuthor().toLowerCase().contains(termino)) {
                String estado;
                if (libro.isBorrowed()) {
                    estado = "Prestado";
                } else {
                    estado = "Disponible";
                }

                System.out.println("- " + libro.getTitle() + " | Autor: " + libro.getAuthor() + " | Estado: " + estado);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron coincidencias en el catalogo.");
        }
    }

    // GETTERS
    public List<Book> getInventario() {
        return inventario;
    }
}