package bibl.user;
import java.time.LocalDate;

public abstract class Person {
    private String name;
    private String lastName;
    private LocalDate dateOfBirth;
    private String dui;
    private Gender gender;

    public Person(String name, String lastName, Gender gender, String dui, LocalDate dateOfBirth) {
        this.setName(name);
        this.setLastName(lastName);
        this.setGender(gender);
        this.setDui(dui);
        this.setDateOfBirth(dateOfBirth);
        System.out.println("Persona creada exitosamente");
    }

    // Metodos
    public void showInformation() {
        System.out.println("Nombre completo: " + this.name + " " + this.lastName);
        System.out.println("Fecha de nacimiento: " + this.dateOfBirth);
        System.out.println("Género: " + this.gender);
        System.out.println("DUI: " + this.dui);
    }

    // Metodo abstracto que obliga a las clases hijas a definir como crear el carnet
    public abstract String createCarne();

    // GETTERS
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDui() {
        return dui;
    }

    public Gender getGender() {
        return gender;
    }

    // SETTERS
    public void setName(String name) {
        // Evita valores nulos y cadenas de texto vacias o con solo espacios
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null && !lastName.trim().isEmpty()) {
            this.lastName = lastName.trim();
        }
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth != null) {
            this.dateOfBirth = dateOfBirth;
        }
    }

    public void setGender(Gender gender) {
        if (gender != null) {
            this.gender = gender;
        }
    }

    public void setDui(String dui) {
        // Verifica que no sea nulo antes de medir su longitud para evitar caídas del sistema
        // Soporta 9 digitos (sin guion) o 10 digitos (con guion)
        if (dui != null && (dui.length() == 9 || dui.length() == 10)) {
            this.dui = dui;
        } else {
            System.out.println("Error: Formato de DUI invalido.");
        }
    }
}
