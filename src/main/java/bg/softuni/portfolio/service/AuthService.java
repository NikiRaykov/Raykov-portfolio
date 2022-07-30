package bg.softuni.portfolio.service;

import bg.softuni.portfolio.model.binding.UserRegisterBindingModel;
import bg.softuni.portfolio.model.entity.User;
import bg.softuni.portfolio.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(UserRegisterBindingModel userRegisterBindingModel) {

        Optional<User> byEmail = this.userRepository.findByEmail(userRegisterBindingModel.getEmail());

        if (byEmail.isPresent()) {
            throw new RuntimeException("email.used");
        }

        User user = new User();
        user.setUsername(userRegisterBindingModel.getUsername());
        user.setEmail(userRegisterBindingModel.getEmail());
        user.setBudget(userRegisterBindingModel.getBudget());
        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));

        userRepository.save(user);
    }
}
