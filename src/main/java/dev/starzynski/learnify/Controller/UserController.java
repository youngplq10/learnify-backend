package dev.starzynski.learnify.Controller;

import dev.starzynski.learnify.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
}
