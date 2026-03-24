package bibl.user;

import java.time.LocalDate;
import java.time.Year;
import java.util.Random;

public class User extends Person {
    private LocalDate dateOfCreation;
    private String cellphone;
    private String email;
    private String userId; // Solo se declara, se calcula en el constructor

    public User(String name, String lastName, Gender gender, String dui, LocalDate dateOfBirth, LocalDate dateOfCreation, String cellphone, String email) {
        // 1. Llama a la clase padre, esto asigna el nombre, apellido, etc.
        super(name, lastName, gender, dui, dateOfBirth);

        // 2. Usamos los setters de esta clase para validar los nuevos datos
        this.setDateOfCreation(dateOfCreation);
        this.setCellphone(cellphone);
        this.setEmail(email);

        // 3. Generamos el carnet ahora, porque la clase padre ya guardó el nombre
        this.userId = createCarne();

        System.out.println("Usuario creado exitosamente");
    }

    // Metodos
    @Override
    public void showInformation() {
        super.showInformation(); // Muestra la informacion base (nombre, DUI, etc.)
        System.out.println("Carnet (User ID): " + this.userId);
        System.out.println("Email: " + this.email);
        System.out.println("Celular: " + this.cellphone);
        System.out.println("Fecha de registro: " + this.dateOfCreation);
    }

    @Override
    public String createCarne() {
        String year = String.valueOf(Year.now().getValue());
        String name = this.getName();

        // Validamos la longitud del nombre para evitar errores al cortar el texto
        String letters;
        if (name.length() >= 2) {
            // Si el nombre tiene 2 o más letras, cortamos las primeras dos
            letters = name.substring(0, 2).toUpperCase();
        } else {
            // Si tiene solo 1 letra, la usamos toda
            letters = name.toUpperCase();
        }

        Random random = new Random();
        int randomNumber = random.nextInt(10000);

        String formattedNumbers = String.format("%04d", randomNumber);

        return year + letters + formattedNumbers;
    }

    // GETTERS
    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getEmail() {
        return email;
    }

    public String getUserId() {
        return userId;
    }

    // SETTERS
    public void setDateOfCreation(LocalDate dateOfCreation) {
        // Si por error envian null, asignamos la fecha de hoy por defecto
        if (dateOfCreation != null) {
            this.dateOfCreation = dateOfCreation;
        } else {
            this.dateOfCreation = LocalDate.now();
        }
    }

    public void setCellphone(String cellphone) {
        if (cellphone != null && !cellphone.trim().isEmpty()) {
            this.cellphone = cellphone.trim();
        } else {
            System.out.println("Error: El celular no puede estar vacio.");
        }
    }

    public void setEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            this.email = email.trim();
        } else {
            System.out.println("Error: El email no puede estar vacio.");
        }
    }
}