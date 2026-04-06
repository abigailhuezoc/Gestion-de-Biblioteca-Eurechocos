package bibl.FileStorage.UserStorage;

import bibl.user.User;
import java.util.List;
/** Contrato para la gestión de usuarios
 * Define las acciones esenciales para administrar a las personas que
 * interactúan con la biblioteca
 */
public interface IUserService {
    void addUser(User user);
    void showUsers();
    User findUserById(String searchId);
    List<User> getRegistered();
}