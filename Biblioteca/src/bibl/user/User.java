package bibl.user;

import java.time.LocalDate;
import java.time.Year;
import java.util.Random;
/**HERENCIA
 * User extiende de Person añadiendo la faceta de "cliente"
 */
public class User extends Person {

    // ATRIBUTOS
    private LocalDate dateOfCreation;
    private String cellphone;
    private String email;
    private String userId; //ID único que lo identifica en el sistema de préstamos


    // CONSTRUCTOR
    public User(String name, String lastName, Gender gender, String dui, LocalDate dateOfBirth, LocalDate dateOfCreation, String cellphone, String email) {
        // Invocamos el constructor de Person para inicializar los datos básicos.
        super(name, lastName, gender, dui, dateOfBirth);

        this.setDateOfCreation(dateOfCreation);
        this.setCellphone(cellphone);
        this.setEmail(email);
// Generamos el ID automáticamente al momento de la creación
        this.userId = createCarne();
    }

    // METODOS
    /**POLIMORFISMO: Redefinimos cómo se muestra la info.
     * No borramos lo de Person, sino que le sumamos los datos de contacto y el Carnet.
     */
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
        int randomNumber = random.nextInt(10000);// Rango de 0 a 9999
// Formateamos para que siempre tenga 4 dígitos (ej: 0005)
        String formattedNumbers = String.format("%04d", randomNumber);

        return year + letters + formattedNumbers;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        // Si no hay fecha, el sistema le asigna la de hoy por defecto.
        this.dateOfCreation = (dateOfCreation != null) ? dateOfCreation : LocalDate.now();
    }

    public void setCellphone(String cellphone) {
        if (cellphone != null && !cellphone.trim().isEmpty()) {
            this.cellphone = cellphone.trim();
        } else {
            throw new IllegalArgumentException("El contacto telefónico es obligatorio.");
        }
    }

    public void setEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            this.email = email.trim();
        } else {
            throw new IllegalArgumentException("El correo electrónico es necesario para notificaciones.");
        }
    }

    // GETTERS
    public LocalDate getDateOfCreation() { return dateOfCreation; }
    public String getCellphone() { return cellphone; }
    public String getEmail() { return email; }
    public String getUserId() { return userId; }
}