package bibl;

import bibl.books.*;
import bibl.FileStorage.BooksStorage.*;
import bibl.FileStorage.LoanStorage.*;
import bibl.FileStorage.UserStorage.*;
import bibl.user.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String systemName = "Eurochocos Library";
        final double version = 1.0;

        Scanner scanner = new Scanner(System.in);

        IBookService bookService = new BookService();
        ILoanService loanService = new LoanService();
        IUserService userService = new UserService();

        System.out.println(systemName + " Version " + version);
        cargarDatosDePrueba(bookService, userService);

        int option = 0;

        do {
            System.out.println("\n========================================");
            System.out.println("        MENU PRINCIPAL BIBLIOTECA       ");
            System.out.println("========================================");
            System.out.println("1. Registrar un nuevo libro");
            System.out.println("2. Registrar un nuevo usuario");
            System.out.println("3. Prestar libro a un usuario");
            System.out.println("4. Devolver un libro prestado");
            System.out.println("5. Buscar libro por titulo/autor");
            System.out.println("6. Ver lista de libros prestados");
            System.out.println("7. Ver reporte de todos los prestamos");
            System.out.println("8. Ver todo el catalogo");
            System.out.println("9. Lista de todos los usuarios registrados");
            System.out.println("0. Salir del sistema");
            System.out.println("========================================");
            System.out.print("Elige una opcion: ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
                option = -1;
            }

            switch (option) {
                case 1:
                    System.out.println("\n--- REGISTRAR NUEVO LIBRO ---");
                    try {
                        System.out.print("Tipo de libro (1. Fisico | 2. Digital): ");
                        int bookType = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Titulo: "); String title = scanner.nextLine();
                        System.out.print("Autor: "); String author = scanner.nextLine();
                        System.out.print("ISBN: "); String isbn = scanner.nextLine();
                        System.out.print("Genero: "); String genre = scanner.nextLine();
                        System.out.print("Año de publicacion: "); int year = scanner.nextInt();
                        System.out.print("Cantidad en inventario: "); int stock = scanner.nextInt();
                        System.out.print("Numero de paginas: "); int pages = scanner.nextInt();
                        scanner.nextLine();

                        if (bookType == 1) {
                            System.out.print("Ubicacion en estante: "); String loc = scanner.nextLine();
                            System.out.print("Cubierta (1. Tapa Dura | 2. Tapa Blanda): ");
                            CoverType cover = (scanner.nextInt() == 1) ? CoverType.TAPA_DURA : CoverType.TAPA_BLANDA;
                            scanner.nextLine();
                            bookService.addBook(new PhysicalBook(title, author, isbn, genre, year, stock, pages, loc, cover));
                        } else if (bookType == 2) {
                            System.out.print("Formato (PDF/EPUB): "); String format = scanner.nextLine();
                            System.out.print("Tamaño del archivo (MB): "); double size = scanner.nextDouble();
                            scanner.nextLine();
                            bookService.addBook(new DigitalBook(title, author, isbn, genre, year, stock, pages, format, size));
                        } else {
                            System.out.println("Tipo de libro no valido.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error en el registro: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("\n--- REGISTRAR NUEVO USUARIO ---");
                    try {
                        System.out.print("Nombre: "); String fName = scanner.nextLine();
                        System.out.print("Apellido: "); String lName = scanner.nextLine();
                        System.out.print("Genero (1. Masculino | 2. Femenino | 3. Otro): ");
                        int gOpt = scanner.nextInt();
                        scanner.nextLine();

                        Gender g = (gOpt == 1) ? Gender.MASCULINO : (gOpt == 2 ? Gender.FEMENINO : Gender.OTRO);
                        System.out.print("DUI: "); String dui = scanner.nextLine();
                        System.out.println("Fecha de nacimiento:");
                        System.out.print("Año: "); int y = scanner.nextInt();
                        System.out.print("Mes: "); int m = scanner.nextInt();
                        System.out.print("Dia: "); int d = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Celular: "); String cel = scanner.nextLine();
                        System.out.print("Email: "); String mail = scanner.nextLine();

                        userService.addUser(new User(fName, lName, g, dui, LocalDate.of(y, m, d), LocalDate.now(), cel, mail));
                    } catch (Exception e) {
                        System.out.println("Error al crear usuario: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("\n--- PRESTAR LIBRO ---");
                    try {
                        System.out.print("Ingrese el ID del usuario (Carnet): ");
                        User u = userService.findUserById(scanner.nextLine());

                        System.out.print("Ingrese el titulo exacto del libro: ");
                        Book b = bookService.findBookByTitle(scanner.nextLine());

                        loanService.registerLoan(new Loan(b, u, LocalDate.now()));
                    } catch (Exception e) {
                        System.out.println("No se pudo realizar el prestamo: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("\n--- DEVOLVER LIBRO ---");
                    try {
                        System.out.print("Escribe el titulo del libro que vas a devolver: ");
                        String returnTitle = scanner.nextLine();

                        loanService.returnLoanByBookTitle(returnTitle);
                    } catch (Exception e) {
                        System.out.println("Error en la devolucion: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("\n--- BUSCAR LIBRO ---");
                    System.out.print("Ingrese el termino de busqueda: ");
                    bookService.lookForBook(scanner.nextLine());
                    break;

                case 6:
                    System.out.println("\n--- LISTA DE PRESTAMOS ACTIVOS ---");
                    loanService.showLendBooks();
                    break;

                case 7:
                    System.out.println("\n--- REPORTE ESTADISTICO GENERAL ---");
                    loanService.createLoanReport();
                    break;

                case 8:
                    System.out.println("\n--- CATALOGO COMPLETO ---");
                    bookService.showBooks();
                    break;

                case 9:
                    System.out.println("\n--- USUARIOS REGISTRADOS ---");
                    userService.showUsers();
                    break;

                case 0:
                    System.out.println("Finalizando sesion en " + systemName);
                    break;

                default:
                    System.out.println("Opcion no reconocida. Por favor, intente de nuevo.");
                    break;
            }
        } while (option != 0);

        scanner.close();
    }

    private static void cargarDatosDePrueba(IBookService bs, IUserService us) {
        try {
            us.addUser(new User("Carlos", "Perez", Gender.MASCULINO, "12345678-9",  LocalDate.of(1995, 5, 20), LocalDate.now(), "7777-8888", "carlos@mail.com"));
            us.addUser(new User("Maria", "Lopez", Gender.FEMENINO, "09876543-2",  LocalDate.of(1998, 8, 15), LocalDate.now(), "7123-4567", "maria.lopez@mail.com"));
            us.addUser(new User("Luis", "Hernandez", Gender.MASCULINO, "05554443-1",  LocalDate.of(2000, 1, 10), LocalDate.now(), "7000-1111", "luis.mario@mail.com"));


            bs.addBook(new PhysicalBook("1984", "George Orwell", "978-111", "Ciencia Ficcion", 1949, 1, 328, "Pasillo B", CoverType.TAPA_BLANDA));
            bs.addBook(new DigitalBook("Clean Code", "Robert C. Martin", "978-999", "Programacion", 2008, 100, 464, "EPUB", 5.0));
            bs.addBook(new PhysicalBook("Don Quijote", "Miguel de Cervantes", "978-222", "Clasico", 1605, 3, 864, "Seccion A-1", CoverType.TAPA_DURA));

        } catch (Exception e) {
            System.out.println("Error al cargar los datos iniciales de prueba: " + e.getMessage());
        }
    }}
