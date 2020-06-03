package mate.academy.service;

import java.util.List;
import mate.academy.model.User;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
