package mate.academy;

import mate.academy.config.AppConfig;
import mate.academy.model.User;
import mate.academy.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.add(new User("nastya", "mail@com.net", "123"));
        userService.add(new User("ivan", "mymail@com.net", "1234"));
        userService.listUsers().forEach(System.out::println);
    }
}
