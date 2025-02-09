package dev.starzynski.learnify.Controller;

import dev.starzynski.learnify.Model.User;
import dev.starzynski.learnify.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/public/login")
    public ResponseEntity<String> login(@RequestBody User user){
        return new ResponseEntity<String> (userService.login(user), HttpStatus.OK);
    }

    @PostMapping("/public/register")
    public ResponseEntity<String> register(@RequestBody User user){
        return new ResponseEntity<String> (userService.register(user), HttpStatus.OK);
    }
}
