package todo.app.yigit.demo.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import todo.app.yigit.demo.dto.auth.LoginRequest;
import todo.app.yigit.demo.dto.auth.LoginResponse;
import todo.app.yigit.demo.dto.auth.RegisterRequest;
import todo.app.yigit.demo.dto.auth.RegisterResponse;
import todo.app.yigit.demo.exception.AppException;
import todo.app.yigit.demo.model.User;
import todo.app.yigit.demo.repository.UserRepository;
import todo.app.yigit.demo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public RegisterResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.email())) {
            throw new AppException("Email is already in use");
        }

        User user = new User(
                request.email(),
                passwordEncoder.encode(request.password())
        );

        User saved = userRepository.save(user);

        return new RegisterResponse(saved.getId(), saved.getEmail());
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new AppException("Invalid credentials"));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new AppException("Invalid credentials");
        }

        return new LoginResponse("TEMP_TOKEN");
    }
}
