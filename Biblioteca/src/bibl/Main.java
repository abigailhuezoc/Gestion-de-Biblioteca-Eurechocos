package bibl;

import bibl.books.Book;
import bibl.books.DigitalBook;
import bibl.books.PhysicalBook;
import bibl.books.CoverType;
import bibl.services.BookService;
import bibl.services.LoanService;
import bibl.user.Gender;
import bibl.user.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookService bookService = new BookService();
        LoanService loanService = new LoanService();
        List<User> listaUsuarios = new ArrayList<>();

        System.out.println("Iniciando Sistema de Biblioteca Eurechocos...");
        // Cargamos nuestros datos de prueba para no tener el sistema vacio al iniciar
        cargarDatosDePrueba(bookService, listaUsuarios);

        int opcion = 0;
        do {
            System.out.println("\n========================================");
            System.out.println("        MENU PRINCIPAL BIBLIOTECA       ");
            System.out.println("========================================");
            System.out.println("1. [HU-01] Registrar un nuevo libro");
            System.out.println("2. [HU-02] Registrar un nuevo usuario");
            System.out.println("3. [HU-03] Prestar libro a un usuario");
            System.out.println("4. [HU-04] Devolver un libro prestado");
            System.out.println("5. [HU-05] Buscar libro por titulo/autor");
            System.out.println("6. [HU-06] Ver lista de libros prestados");
            System.out.println("7. [HU-08] Ver reporte de todos los prestamos");
            System.out.println("8. Ver todo el catalogo (Extra)");
            System.out.println("0. Salir del sistema");
            System.out.println("========================================");
            System.out.print("Elige una opcion: ");

            // Validacion para evitar caidas si escriben letras en lugar de numeros
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer
            } else {
                sc.nextLine();
                opcion = -1;
            }

            // ==========================================
            // EVALUACION DE LAS OPCIONES DEL MENU
            // ==========================================

            if (opcion == 1) {
                // [HU-01] REGISTRAR LIBRO
                System.out.println("\n--- REGISTRAR NUEVO LIBRO ---");
                System.out.println("¿Que tipo de libro es? (1. Fisico | 2. Digital): ");
                int tipoLibro = sc.nextInt();
                sc.nextLine();

                System.out.print("Titulo: "); String titulo = sc.nextLine();
                System.out.print("Autor: "); String autor = sc.nextLine();
                System.out.print("ISBN: "); String isbn = sc.nextLine();
                System.out.print("Genero: "); String genero = sc.nextLine();

                System.out.print("Año de publicacion: "); int anio = sc.nextInt();
                System.out.print("Cantidad en inventario: "); int inventario = sc.nextInt();
                System.out.print("Numero de paginas: "); int paginas = sc.nextInt();
                sc.nextLine(); // Limpiamos buffer despues de pedir numeros

                if (tipoLibro == 1) {
                    System.out.print("Ubicacion en estante (Ej. Pasillo A): "); String ubicacion = sc.nextLine();
                    System.out.print("Tipo de cubierta (1. Tapa Dura | 2. Tapa Blanda): ");
                    int tipoCubierta = sc.nextInt();
                    sc.nextLine();

                    CoverType cover = (tipoCubierta == 1) ? CoverType.TAPA_DURA : CoverType.TAPA_BLANDA;

                    PhysicalBook nuevoFisico = new PhysicalBook(titulo, autor, isbn, genero, anio, inventario, paginas, ubicacion, cover);
                    bookService.agregarLibro(nuevoFisico);

                } else if (tipoLibro == 2) {
                    System.out.print("Formato (Ej. PDF, EPUB): "); String formato = sc.nextLine();
                    System.out.print("Tamaño del archivo en MB (Ej. 2.5): "); double tamano = sc.nextDouble();
                    sc.nextLine();

                    DigitalBook nuevoDigital = new DigitalBook(titulo, autor, isbn, genero, anio, inventario, paginas, formato, tamano);
                    bookService.agregarLibro(nuevoDigital);
                } else {
                    System.out.println("Tipo de libro invalido. Operacion cancelada.");
                }

            } else if (opcion == 2) {
                // [HU-02] REGISTRAR USUARIO
                System.out.println("\n--- REGISTRAR NUEVO USUARIO ---");
                System.out.print("Nombre: "); String nombre = sc.nextLine();
                System.out.print("Apellido: "); String apellido = sc.nextLine();

                System.out.print("Genero (1. Masculino | 2. Femenino | 3. Otro): ");
                int opcGenero = sc.nextInt();
                sc.nextLine();

                Gender generoEnum = Gender.OTRO; // Por defecto
                if (opcGenero == 1) { generoEnum = Gender.MASCULINO; }
                else if (opcGenero == 2) { generoEnum = Gender.FEMENINO; }

                System.out.print("DUI (Ej. 12345678-9): "); String dui = sc.nextLine();

                System.out.println("Fecha de nacimiento:");
                System.out.print("Año (Ej. 2000): "); int anioNac = sc.nextInt();
                System.out.print("Mes (1-12): "); int mesNac = sc.nextInt();
                System.out.print("Dia (1-31): "); int diaNac = sc.nextInt();
                sc.nextLine();

                LocalDate fechaNacimiento = LocalDate.of(anioNac, mesNac, diaNac);

                System.out.print("Celular: "); String celular = sc.nextLine();
                System.out.print("Correo electronico: "); String correo = sc.nextLine();

                // Creamos el usuario enviando LocalDate.now() como fecha de creacion
                User nuevoUsuario = new User(nombre, apellido, generoEnum, dui, fechaNacimiento, LocalDate.now(), celular, correo);
                listaUsuarios.add(nuevoUsuario);

            } else if (opcion == 3) {
                // [HU-03] PRESTAR LIBRO
                System.out.println("\n--- PRESTAR LIBRO ---");
                System.out.print("Ingresa el DUI del usuario: ");
                String duiBuscado = sc.nextLine();

                User usuarioEncontrado = null;
                for (User u : listaUsuarios) {
                    if (u.getDui().equals(duiBuscado)) {
                        usuarioEncontrado = u;
                        break;
                    }
                }

                if (usuarioEncontrado != null) {
                    System.out.println("Usuario activo: " + usuarioEncontrado.getName() + " " + usuarioEncontrado.getLastName());
                    System.out.print("Escribe el titulo exacto del libro que deseas prestar: ");
                    String tituloBuscado = sc.nextLine();

                    Book libroEncontrado = null;
                    for (Book libro : bookService.getInventario()) {
                        if (libro.getTitle().equalsIgnoreCase(tituloBuscado)) {
                            libroEncontrado = libro;
                            break;
                        }
                    }

                    if (libroEncontrado != null) {
                        Loan nuevoPrestamo = new Loan(libroEncontrado, usuarioEncontrado, LocalDate.now());
                        loanService.registrarPrestamo(nuevoPrestamo);
                    } else {
                        System.out.println("El libro no existe en el catalogo.");
                    }
                } else {
                    System.out.println("Usuario no encontrado en el sistema. Verifique el DUI.");
                }

            } else if (opcion == 4) {
                // [HU-04] DEVOLVER LIBRO
                System.out.println("\n--- DEVOLVER LIBRO ---");
                System.out.print("Escribe el titulo del libro que vas a devolver: ");
                String tituloDevolver = sc.nextLine();
                boolean devuelto = false;

                for (Loan prestamo : loanService.getListaPrestamos()) {
                    if (prestamo.isActive() && prestamo.getBook().getTitle().equalsIgnoreCase(tituloDevolver)) {
                        prestamo.returnBook();
                        devuelto = true;
                        break;
                    }
                }

                if (!devuelto) {
                    System.out.println("No se encontro un prestamo activo para ese libro.");
                }

            } else if (opcion == 5) {
                // [HU-05] BUSCAR LIBRO
                System.out.println("\n--- BUSCAR LIBRO ---");
                System.out.print("Ingresa el titulo o autor a buscar: ");
                String termino = sc.nextLine();
                bookService.buscarLibro(termino);

            } else if (opcion == 6) {
                // [HU-06] VER LIBROS PRESTADOS
                loanService.verLibrosPrestados();

            } else if (opcion == 7) {
                // [HU-08] REPORTE DE PRESTAMOS
                loanService.generarReportePrestamos();

            } else if (opcion == 8) {
                // Ver el catálogo completo
                System.out.println("\n--- CATÁLOGO COMPLETO ---");
                for (Book libro : bookService.getInventario()) {
                    libro.showInfo();
                    System.out.println("- - - - - - - - - - - - -");
                }

            } else if (opcion == 0) {
                System.out.println("Cerrando el sistema... ¡Adios y muchas gracias por usar nuestro programa!");
            } else {
                System.out.println("Opción no valida. Intenta con un numero del 0 al 8.");
            }

        } while (opcion != 0);

        sc.close();
    }


    // DATOS DE PRUEBA

    private static void cargarDatosDePrueba(BookService bookService, List<User> listaUsuarios) {
        // --- 3 USUARIOS DE PRUEBA ---
        listaUsuarios.add(new User("Carlos", "Perez", Gender.MASCULINO, "12345678-9", LocalDate.of(1995, 5, 20), LocalDate.now(), "7777-8888", "carlos@mail.com"));
        listaUsuarios.add(new User("Ana", "Gomez", Gender.FEMENINO, "98765432-1", LocalDate.of(1998, 10, 15), LocalDate.now(), "7777-9999", "ana@mail.com"));
        listaUsuarios.add(new User("Luis", "Martinez", Gender.MASCULINO, "55554444-2", LocalDate.of(2001, 2, 28), LocalDate.now(), "7777-1111", "luis@mail.com"));

        // --- 4 LIBROS DE PRUEBA ---
        bookService.agregarLibro(new PhysicalBook("El Senor de los Anillos", "J.R.R. Tolkien", "978-456", "Fantasia", 1954, 3, 1200, "Pasillo A", CoverType.TAPA_DURA));
        bookService.agregarLibro(new PhysicalBook("1984", "George Orwell", "978-111", "Ciencia Ficcion", 1949, 1, 328, "Pasillo B", CoverType.TAPA_BLANDA));
        bookService.agregarLibro(new DigitalBook("Habitos Atomicos", "James Clear", "978-123", "Autoayuda", 2018, 50, 320, "PDF", 2.5));
        bookService.agregarLibro(new DigitalBook("Clean Code", "Robert C. Martin", "978-999", "Programacion", 2008, 100, 464, "EPUB", 5.0));
    }
}