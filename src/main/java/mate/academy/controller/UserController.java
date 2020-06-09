package mate.academy.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.dto.UserResponseDto;
import mate.academy.model.User;
import mate.academy.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/inject")
    public void injectUserData() {
        userService.add(new User("nastya", "first_mail@com.net", "123"));
        userService.add(new User("ivan", "second_mail@com.net", "1234"));
    }

    @GetMapping("/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        User user = userService.get(userId);
        return new UserResponseDto(user.getName(), user.getEmail(), user.getPassword());
    }

    @GetMapping("/")
    public List<UserResponseDto> getAll() {
        return userService.listUsers()
                .stream()
                .map(u -> new UserResponseDto(u.getName(), u.getEmail(), u.getPassword()))
                .collect(Collectors.toList());
    }
}
