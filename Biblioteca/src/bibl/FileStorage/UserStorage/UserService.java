package bibl.FileStorage.UserStorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import bibl.user.User;

public class UserService implements IUserService {

    private List<User> registered;

    public UserService() {
        this.registered = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
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
            user.showInformation();
        }
    }

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
        throw new java.util.NoSuchElementException("No se encontró ningún usuario con el ID: " + searchId);
    }

    @Override
    public List<User> getRegistered() {
        return Collections.unmodifiableList(registered);
    }
}