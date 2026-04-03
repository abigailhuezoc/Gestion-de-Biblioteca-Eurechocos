package bibl.FileStorage.UserStorage;

import bibl.user.User;
import java.util.List;

public interface IUserService {
    void addUser(User user);
    void showUsers();
    User findUserById(String searchId);
    List<User> getRegistered();
}