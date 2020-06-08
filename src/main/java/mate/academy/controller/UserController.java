package mate.academy.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.dto.UserResponseDto;
import mate.academy.model.User;
import mate.academy.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/inject", method = RequestMethod.GET)
    public void injectUserData() {
        userService.add(new User("nastya", "first_mail@com.net", "123"));
        userService.add(new User("ivan", "second_mail@com.net", "1234"));
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public UserResponseDto get(@PathVariable Long userId) {
        User user = userService.get(userId);
        return new UserResponseDto(user.getName(), user.getEmail(), user.getPassword());
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserResponseDto> getAll() {
        return userService.listUsers()
                .stream()
                .map(u -> new UserResponseDto(u.getName(), u.getEmail(), u.getPassword()))
                .collect(Collectors.toList());
    }
}
