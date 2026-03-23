package bibl;
import bibl.books.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public Main(){}
    
    public static void main(String[] args) {
        System.out.println("\t BIBLIOTECA EURECHOCOS");
        
        Scanner scanner = new Scanner(System.in);
        List<Book> library = new ArrayList<>();
        int selection = -1;
        while (selection != 0) {
            System.out.println("Selecciona la actividad que deseas realizar: Recuerda que con 0 puedes salir");
            System.out.println("--------------------------" + "\n" + "1. Registrar libro" + "\n" +
                    "2. Registrar usuario" + "\n" +
                    "3. Prestar libro" + "\n" + "4. Devolver libro"
                    + "\n" + "5. Buscar libro " + "\n" + "6. Ver libros prestados" + "\n" + "--------------------------");

            int seleccion = scanner.nextInt();
            scanner.nextLine();


            System.out.println("Seleccionaste " + seleccion);
            if (seleccion == 1) {
                Book libro = new Book("", "", "", "", 0, 0, false);
                libro.toReceive();
                library.add(libro);
                System.out.println("Libro registrado: " + libro.getTitle() + " de " + libro.getAuthor());

            } else if (seleccion == 2) {
                System.out.println("");
            } else if (seleccion == 3) {
                System.out.println("");
            } else if (seleccion == 4) {
                System.out.println("");
            } else if (seleccion == 5) {
                System.out.println("Introduce el título del libro a buscar:");
                String titleSearch = scanner.nextLine();
                boolean found = false;
                for (Book b : library) {
                    if (b.getTitle().equalsIgnoreCase(titleSearch)) {
                        System.out.println("Libro encontrado: " + b.getTitle() + " de " + b.getAuthor());
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("El libro no está registrado.");
                }
            } else if (seleccion == 6) {
                System.out.println("Libros prestados:");
                for (Book b : library) {
                    if (b.isBorrowed()) {
                        System.out.println(b.getTitle() + " de " + b.getAuthor());
                    }
                }
            } else if (seleccion == 0) {
                System.out.println("Saliendo del sistema...");

            } else {
                System.out.println("Opción inválida.");
            }

        }
    }}
            
    }
}
