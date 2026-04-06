package bibl.user;

import java.time.LocalDate;
/**Aplicamos ABSTRACCIÓN: porque no tomamos personas genéricas, sino roles específicos
 * Aquí centralizamos los datos biográficos y legales básicos.
 */
public abstract class Person {

    // ENCAPSULAMIENTO: Atributos privados para proteger la integridad de la entidad
    private String name;
    private String lastName;
    private LocalDate dateOfBirth;
    private String dui;
    private Gender gender;

    // CONSTRUCTOR
    public Person(String name, String lastName, Gender gender, String dui, LocalDate dateOfBirth) {
        // Validamos desde el inicio para que no existan personas sin identidad válida
        this.setName(name);
        this.setLastName(lastName);
        this.setGender(gender);
        this.setDui(dui);
        this.setDateOfBirth(dateOfBirth);
    }

    // METODOS
    /**Muestra la base de la ficha personal
     * Se complementará en las clases hijas según su rol
     */
    public void showInformation() {
        System.out.println("Nombre completo: " + this.name + " " + this.lastName);
        System.out.println("Fecha de nacimiento: " + this.dateOfBirth);
        System.out.println("Género: " + this.gender);
        System.out.println("DUI: " + this.dui);
    }
    /**Obligamos a todas las subclases a implementar su propia lógica de identificación
     * Cada tipo de persona tendrá un formato de carnet distinto.
     */
    public abstract String createCarne();

    // SETTERS con validación

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        } else {
            throw new IllegalArgumentException("El nombre es obligatorio para el registro.");
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null && !lastName.trim().isEmpty()) {
            this.lastName = lastName.trim();
        } else {
            throw new IllegalArgumentException("El apellido es obligatorio.");
        }
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth != null) {
            this.dateOfBirth = dateOfBirth;
        } else {
            throw new IllegalArgumentException("La fecha de nacimiento es necesaria para procesos legales.");
        }
    }

    public void setGender(Gender gender) {
        if (gender != null) {
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("El género debe estar definido (MASCULINO, FEMENINO u OTRO).");
        }
    }

    public void setDui(String dui) {
        // Validación de formato: nos aseguramos que el DUI sea coherente (9 o 10 caracteres).
        if (dui != null && (dui.length() == 9 || dui.length() == 10)) {
            this.dui = dui;
        } else {
            throw new IllegalArgumentException("El formato de DUI es inválido. Verifique los dígitos.");
        }
    }

    // GETTERS
    public String getName() { return name; }
    public String getLastName() { return lastName; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public String getDui() { return dui; }
    public Gender getGender() { return gender; }
}