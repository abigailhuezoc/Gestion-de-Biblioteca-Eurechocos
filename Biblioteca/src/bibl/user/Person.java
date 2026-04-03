package bibl.user;

import java.time.LocalDate;

public abstract class Person {

    // ATRIBUTOS
    private String name;
    private String lastName;
    private LocalDate dateOfBirth;
    private String dui;
    private Gender gender;

    // CONSTRUCTOR
    public Person(String name, String lastName, Gender gender, String dui, LocalDate dateOfBirth) {
        this.setName(name);
        this.setLastName(lastName);
        this.setGender(gender);
        this.setDui(dui);
        this.setDateOfBirth(dateOfBirth);
    }

    // METODOS
    public void showInformation() {
        System.out.println("Nombre completo: " + this.name + " " + this.lastName);
        System.out.println("Fecha de nacimiento: " + this.dateOfBirth);
        System.out.println("Género: " + this.gender);
        System.out.println("DUI: " + this.dui);
    }

    public abstract String createCarne();

    // GETTERS
    public String getName() { return name; }
    public String getLastName() { return lastName; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public String getDui() { return dui; }
    public Gender getGender() { return gender; }

    // SETTERS
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        } else {
            throw new IllegalArgumentException("El nombre no puede ser nulo o estar vacío.");
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null && !lastName.trim().isEmpty()) {
            this.lastName = lastName.trim();
        } else {
            throw new IllegalArgumentException("El apellido no puede ser nulo o estar vacío.");
        }
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth != null) {
            this.dateOfBirth = dateOfBirth;
        } else {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula.");
        }
    }

    public void setGender(Gender gender) {
        if (gender != null) {
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("El género no puede ser nulo.");
        }
    }

    public void setDui(String dui) {
        if (dui != null && (dui.length() == 9 || dui.length() == 10)) {
            this.dui = dui;
        } else {
            throw new IllegalArgumentException("Formato de DUI inválido.");
        }
    }
}