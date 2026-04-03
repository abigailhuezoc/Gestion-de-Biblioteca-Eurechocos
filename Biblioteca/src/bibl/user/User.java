package bibl.user;

import java.time.LocalDate;
import java.time.Year;
import java.util.Random;

public class User extends Person {

    // ATRIBUTOS
    private LocalDate dateOfCreation;
    private String cellphone;
    private String email;
    private String userId;

    // CONSTRUCTOR
    public User(String name, String lastName, Gender gender, String dui, LocalDate dateOfBirth, LocalDate dateOfCreation, String cellphone, String email) {
        super(name, lastName, gender, dui, dateOfBirth);

        this.setDateOfCreation(dateOfCreation);
        this.setCellphone(cellphone);
        this.setEmail(email);

        this.userId = createCarne();
    }

    // METODOS
    @Override
    public void showInformation() {
        super.showInformation();
        System.out.println("Carnet (User ID): " + this.userId);
        System.out.println("Email: " + this.email);
        System.out.println("Celular: " + this.cellphone);
        System.out.println("Fecha de registro: " + this.dateOfCreation);
    }

    @Override
    public String createCarne() {
        String year = String.valueOf(Year.now().getValue());
        String name = this.getName();

        String letters;
        if (name.length() >= 2) {
            letters = name.substring(0, 2).toUpperCase();
        } else {
            letters = name.toUpperCase();
        }

        Random random = new Random();
        int randomNumber = random.nextInt(10000);

        String formattedNumbers = String.format("%04d", randomNumber);

        return year + letters + formattedNumbers;
    }

    // GETTERS
    public LocalDate getDateOfCreation() { return dateOfCreation; }
    public String getCellphone() { return cellphone; }
    public String getEmail() { return email; }
    public String getUserId() { return userId; }

    // SETTERS
    public void setDateOfCreation(LocalDate dateOfCreation) {
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
            throw new IllegalArgumentException("El celular no puede estar vacío.");
        }
    }

    public void setEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            this.email = email.trim();
        } else {
            throw new IllegalArgumentException("El email no puede estar vacío.");
        }
    }
}