package bibl.FileStorage.UserStorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import bibl.user.User;
/**Esta clase centraliza la base de datos de usuarios registrados
 * Implementa IUserService para separar la definición de la lógica real
 */
public class UserService implements IUserService {
    // Encapsulamiento: Lista privada para que el acceso sea controlado
    // exclusivamente por los métodos de esta clase.
    private List<User> registered;

    public UserService() {
        this.registered = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        // Validación preventiva: No permitimos que entren nulos al sistema
        if (user != null) {
            this.registered.add(user);
            System.out.println("Persona agregada exitosamente: " + user.getName());
        } else {
            throw new IllegalArgumentException("No se puede agregar un usuario nulo al sistema.");
        }
    }

    @Override
    public void showUsers() {
        if (this.registered.isEmpty()) {
            System.out.println("No hay usuarios registrados en el sistema.");
            return;
        }
        for (User user : this.registered) {
            System.out.println("=====================================");
            // Polimorfismo: Llamamos a showInformation() que viene de Person y se hereda en User
            user.showInformation();
        }
    }
    /** Buscador por ID.
     * El ID es nuestra "llave primaria", por lo que la búsqueda es exacta
     */
    @Override
    public User findUserById(String searchId) {
        if (searchId == null || searchId.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID de búsqueda no puede estar vacío.");
        }

        for (User user : this.registered) {
            if (user.getUserId().equals(searchId.trim())) {
                System.out.println("Usuario encontrado: " + user.getName() + " " + user.getLastName());
                return user;
            }
        }
        // Si no lo encontramos, lanzamos una excepción clara para que el Main sepa qué pasó
        throw new java.util.NoSuchElementException("No se encontró ningún usuario con el ID: " + searchId);
    }
    /**Seguridad de la info
     * Retornamos una vista de "solo lectura" de la lista.
     * Esto evita que se puedan añadir o quitar usuarios externamente sin pasar por addUser()
     */
    @Override
    public List<User> getRegistered() {
        return Collections.unmodifiableList(registered);
    }
}