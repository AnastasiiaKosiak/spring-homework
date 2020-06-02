package mate.academy.dao;

import java.util.List;
import mate.academy.model.User;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
