package dev.starzynski.learnify.Service;

import dev.starzynski.learnify.Model.User;
import dev.starzynski.learnify.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JWTService jwtService;

    public String login(User user) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
            if(authentication.isAuthenticated()){
                return jwtService.generateToken(user.getUsername());
            }
            else {
                return "Failed";
            }
        } catch (AuthenticationException e) {
            return "Failed";
        }
    }

    public String register(User user) {
        userRepository.insert(user);
        return jwtService.generateToken(user.getUsername());
    }
}
